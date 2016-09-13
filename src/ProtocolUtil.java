import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 描述: TODO:
 * 包名: PACKAGE_NAME.
 * 作者: barton.
 * 日期: 16-9-12.
 * 项目名称: socket
 * 版本: 1.0
 * JDK: since 1.8
 */
public class ProtocolUtil {

  public static Request readRequest(InputStream input) throws IOException {
    // 读取编码
    byte[] encodeByte = new byte[1];
    input.read(encodeByte);
    byte encode = encodeByte[0];

    // 读取命令长度
    byte[] commandLengthBytes = new byte[4];
    input.read(commandLengthBytes);
    int commandLength = ByteUtil.bytes2int(commandLengthBytes);

    // 读取命令
    byte[] commandBytes = new byte[commandLength];
    input.read(commandBytes);
    String command;
    if (Encode.GBK.getValue() == encode) {
      command = new String(commandBytes, "GBK");
    } else {
      command = new String(commandBytes, "UTF8");
    }

    // 组装请求并返回
    Request request = new Request();
    request.setCommand(command);
    request.setCommandLength(commandLength);
    request.setEncode(encode);

    return request;
  }

  public static Response readResponse(InputStream input) throws IOException {
    // 读取编码
    byte[] encodeByte = new byte[1];
    input.read(encodeByte);
    byte encode = encodeByte[0];

    // 读取命令长度
    byte[] responseLengthBytes = new byte[4];
    input.read(responseLengthBytes);
    int responseLength = ByteUtil.bytes2int(responseLengthBytes);

    // 读取命令
    byte[] responseBytes = new byte[responseLength];
    input.read(responseBytes);
    String responseStr;
    if (Encode.GBK.getValue() == encode) {
      responseStr = new String(responseBytes, "GBK");
    } else {
      responseStr = new String(responseBytes, "UTF8");
    }

    // 组装响应并返回
    Response response = new Response();
    response.setResponse(responseStr);
    response.setEncode(encode);
    response.setResponseLength(responseLength);

    return response;
  }

  public static void writeResponse(OutputStream output, Response response) throws IOException {

    //将response响应返回给客户端
    output.write(response.getEncode());
    output.write(ByteUtil.int2ByteArray(response.getResponseLength()));

    if (Encode.GBK.getValue() == response.getEncode()) {
      output.write(response.getResponse().getBytes("GBK"));
    } else {
      output.write(response.getResponse().getBytes("UTF8"));
    }

    output.flush();
  }

  public static void writeRequest(OutputStream output, Request request) throws IOException {
    // 将request请求发送到服务端
    output.write(request.getEncode());
    output.write(ByteUtil.int2ByteArray(request.getCommandLength()));

    if (Encode.GBK.getValue() == request.getEncode()) {
      output.write(request.getCommand().getBytes("GBK"));
    } else {
      output.write(request.getCommand().getBytes("UTF8"));
    }

    output.flush();
  }
}
