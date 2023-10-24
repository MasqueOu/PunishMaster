package be.masqueou.punishmaster.spigot.utils.ip;

import be.masqueou.punishmaster.spigot.PunishMaster;
import org.bukkit.entity.Player;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public class AddressUtils {

    protected SecretKeySpec secretKey;
    protected byte[] key;
    protected final String ALGORITHM = "AES";

    public AddressUtils(PunishMaster punishMaster) {
        this.initSecretKey(punishMaster.getSettings().cryptography_Key);
    }

    public String getIPAddress(Player player) {
        return Objects.requireNonNull(player.getAddress()).getAddress().getHostAddress();
    }

    private void initSecretKey(String cryptoKey) {
        try {
            this.key = cryptoKey.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            this.key = sha.digest(this.key);
            this.key = Arrays.copyOf(this.key, 16);
            this.secretKey = new SecretKeySpec(this.key, this.ALGORITHM);
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.out.println("Cryptography SecretKey Error: "+noSuchAlgorithmException.getMessage());
        }
    }

    public String encrypt(String ip_address) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(ip_address.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception exception) {
            System.out.println("Cryptography Encryption Error: "+exception.getMessage());
        }
        return null;
    }

    public String decrypt(String ip_address) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(ip_address)));
        } catch (Exception exception) {
            System.out.println("Cryptography Decryption Error: "+exception.getMessage());
        }
        return null;
    }

}
