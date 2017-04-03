package edu.umbc.cmsc652;

import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

import java.security.SecureRandom;

public class DifferentialCryptanalysis {

    public static void main(String[] args) {
        DESKeyGenerator keyGenerator = new DESKeyGenerator();
        KeyGenerationParameters keyGenerationParameters =
                new KeyGenerationParameters(new SecureRandom(), 0);
        keyGenerator.init(keyGenerationParameters);
        byte[] key = keyGenerator.generateKey();
        key = Hex.decode("8000000000000000");


        DESEngine engine = new DESEngine();
        KeyParameter keyParameter = new KeyParameter(key);
        engine.init(true, keyParameter);

        byte[] in = Hex.decode("0000000000000000");
        byte[] out = new byte[8];
        engine.processBlock(in, 0, out, 0);


    }
}
