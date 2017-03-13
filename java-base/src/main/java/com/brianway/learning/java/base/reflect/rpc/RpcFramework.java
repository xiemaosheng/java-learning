package com.brianway.learning.java.base.reflect.rpc;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public class RpcFramework {

    /**
     * 暴露服务
     * @param service 服务实现
     * @param port 服务端口
     * @throws Exception
     */
    public static void export(final Object service,int port) throws Exception{
        if (null == service){
            throw new IllegalArgumentException("service instance null");
        }

        if(port <= 0 || port > 65535){
            throw new IllegalArgumentException("Invalid port:" + port);
        }

        System.out.println("Export service : " + service.getClass().getName() + " on port : " + port);

        ServerSocket server = new ServerSocket(port);

        for (;;){
            try {
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                            try {
                                String methodName = input.readUTF();
                                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                                Object[] arguments = (Object[]) input.readObject();
                                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                                try {
                                    Method method = service.getClass().getMethod(methodName,parameterTypes);
                                    Object result = method.invoke(service,arguments);
                                    output.writeObject(result);
                                }catch (Throwable t){
                                    output.writeObject(t);
                                }finally {
                                    output.close();
                                }
                            }finally {
                                input.close();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 引用服务
     * @param interfaceClass 接口类型
     * @param host 服务主机名
     * @param port 服务端口
     * @param <T>  接口泛型
     * @return     远程服务
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<T> interfaceClass,final String host,final int port) throws Exception{
        if (null == interfaceClass){
            throw new IllegalArgumentException("Interface class == null");
        }

        if (! interfaceClass.isInterface()){
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        }

        if(null == host || host.length() == 0){
            throw new IllegalArgumentException("Host == null");
        }

        if(port <= 0 || port > 65535){
            throw new IllegalArgumentException("Invalid port:" + port);
        }

        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] {interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host,port);
                try {
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);
                        InputStream is = socket.getInputStream();
                        ObjectInputStream input = new ObjectInputStream(is);
                        try {
                            Object result = input.readObject();
                            if(result instanceof  Throwable){
                                throw (Throwable) result;
                            }
                            return result;
                        }finally {
                            input.close();
                        }
                    }finally {
                        output.close();
                    }
                }finally {
                    socket.close();
                }
            }
        });
    }
}
