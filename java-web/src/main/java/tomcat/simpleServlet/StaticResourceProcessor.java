package tomcat.simpleServlet;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
