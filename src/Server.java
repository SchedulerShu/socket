import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 描述: TODO:
 * 包名: PACKAGE_NAME.
 * 作者: barton.
 * 日期: 16-9-12.
 * 项目名称: socket
 * 版本: 1.0
 * JDK: since 1.8
 */
public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(4567);

    while (true) {
      Socket client = server.accept();

      // 读取响应数据
      InputStream input = client.getInputStream();
      Request request = ProtocolUtil.readRequest(input);

      OutputStream output = client.getOutputStream();

      // 组装响应
      Response response = new Response();
      response.setEncode(Encode.UTF8.getValue());
      if (request.getCommand().equals("Hello")) {
        response.setResponse("hello!");
      } else {
        response.setResponse("bye bye!");
      }

      response.setResponseLength(response.getResponse().length());

      ProtocolUtil.writeResponse(output, response);

      client.shutdownOutput();
    }
  }
}
