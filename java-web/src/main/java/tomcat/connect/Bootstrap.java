package tomcat.connect;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public class Bootstrap {
    public static void main(String[] args) {
        // httpConnector 连接
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
