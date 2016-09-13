/**
 * 描述: TODO:
 * 包名: PACKAGE_NAME.
 * 作者: barton.
 * 日期: 16-9-12.
 * 项目名称: socket
 * 版本: 1.0
 * JDK: since 1.8
 */
public enum Encode {

  UTF8((byte) 0), GBK((byte) 1);

  private byte value;

  Encode(byte value) {
    this.value = value;
  }

  public byte getValue() {
    return value;
  }
}
