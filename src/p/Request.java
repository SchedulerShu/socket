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
public class Request {
  private String command; // 命令
  private int commandLength; // 命令长度
  private byte encode; // 协议编码

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public int getCommandLength() {
    return commandLength;
  }

  public void setCommandLength(int commandLength) {
    this.commandLength = commandLength;
  }

  public byte getEncode() {
    return encode;
  }

  public void setEncode(byte encode) {
    this.encode = encode;
  }
}
