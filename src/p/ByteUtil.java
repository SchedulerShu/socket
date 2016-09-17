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
public class ByteUtil {
  public static int bytes2int(byte[] bytes) {
    int num = bytes[3] & 0xFF;

    num |= ((bytes[2] << 8) & 0xFF00);

    num |= ((bytes[1] << 16) & 0xFF0000);

    num |= ((bytes[0] << 24) & 0xFF000000);
    return num;
  }

  public static byte[] int2ByteArray(int i) {
    byte[] result = new byte[4];

    result[0] = (byte) ((i >> 24) & 0xFF);
    result[1] = (byte) ((i >> 16) & 0xFF);
    result[2] = (byte) ((i >> 8) & 0xFF);
    result[3] = (byte) ((i) & 0xFF);

    return result;
  }
}
