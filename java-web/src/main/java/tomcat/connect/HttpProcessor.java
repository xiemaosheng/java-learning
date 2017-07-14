package tomcat.connect;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public class HttpProcessor {

    private HttpRequestLine requestLine = new HttpRequestLine();

    public void process(Socket socket) {
        SocketInputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new SocketInputStream(socket.getInputStream(), 2048);
            outputStream = socket.getOutputStream();

            // TODO 创建request对象和parse

            // TODO 创建response对象

            // TODO 检查请求类型，静态资源请求还是动态资源请求
        } catch (IOException e) {

        }
    }

    private void parseRequest(SocketInputStream input, OutputStream output) throws IOException, ServletException {

        input.readRequestLine(requestLine);

        String method = new String(requestLine.method, 0, requestLine.methodEnd);

        String uri = null;

        String protocol = new String(requestLine.protocol, 0, requestLine.protocolEnd);

        if (method.length() < 1) {
            throw new ServletException("Messing HTTP request method");
        } else if (requestLine.uriEnd < 1) {
            throw new ServletException("Messing HTTP request uri");
        }
        int question = requestLine.indexOf("?");

        if (question >= 0){

        }
    }
}
