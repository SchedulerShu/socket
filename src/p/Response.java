package src.p;

/**
 * 描述: TODO:
 * 包名: PACKAGE_NAME.
 * 作者: barton.
 * 日期: 16-9-12.
 * 项目名称: socket
 * 版本: 1.0
 * JDK: since 1.8
 */
public class Response {
  private byte encode; // 协议编码

  private String response; // 响应

  private int responseLength; // 响应长度

  public byte getEncode() {
    return encode;
  }

  public void setEncode(byte encode) {
    this.encode = encode;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public int getResponseLength() {
    return responseLength;
  }

  public void setResponseLength(int responseLength) {
    this.responseLength = responseLength;
  }
}
