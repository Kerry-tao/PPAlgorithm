import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    public static void main(String[] args) {
        // 公共参数（素数 p 和原根 g）
        BigInteger p = new BigInteger("23"); // 素数
        BigInteger g = new BigInteger("5");  // 原根

        // 使用安全的随机数生成器
        SecureRandom random = new SecureRandom();

        // Alice 选择一个私有密钥 a
        BigInteger a = new BigInteger(p.bitLength() - 1, random);
        // 计算 Alice 的公钥 A
        BigInteger A = g.modPow(a, p);

        // Bob 选择一个私有密钥 b
        BigInteger b = new BigInteger(p.bitLength() - 1, random);
        // 计算 Bob 的公钥 B
        BigInteger B = g.modPow(b, p);

        // Alice 计算共享密钥
        BigInteger sharedKeyAlice = B.modPow(a, p);

        // Bob 计算共享密钥
        BigInteger sharedKeyBob = A.modPow(b, p);

        // 验证共享密钥是否相同
        System.out.println("Alice's Shared Key: " + sharedKeyAlice);
        System.out.println("Bob's Shared Key: " + sharedKeyBob);
        System.out.println("Shared keys are equal: " + sharedKeyAlice.equals(sharedKeyBob));
    }
}