import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class Client {
  public static void main(String[] args) throws IOException {
    Request request = new Request();

    request.setCommand("Hello");
    request.setCommandLength(request.getCommand().length());
    request.setEncode(Encode.UTF8.getValue());

    System.out.println("commandLength:" + request.getCommandLength());
    System.out.println("command:" + request.getCommand());

    // 连接服务端
    Socket client = new Socket("127.0.0.1", 4567);

    OutputStream output = client.getOutputStream();

    // 发送请求
    ProtocolUtil.writeRequest(output, request);

    // 读取响应数据
    InputStream input = client.getInputStream();
    Response response = ProtocolUtil.readResponse(input);
    client.shutdownOutput();

    System.out.println("responseLength:" + response.getResponseLength());
    System.out.println("response:" + response.getResponse());

  }
}
