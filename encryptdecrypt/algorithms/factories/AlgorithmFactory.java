package encryptdecrypt.algorithms.factories;

import encryptdecrypt.algorithms.ShiftAlgorithm;
import encryptdecrypt.algorithms.UnicodeAlgorithm;
import encryptdecrypt.algorithms.abstractions.UnknownAlgorithmException;
import encryptdecrypt.algorithms.abstractions.AbstractAlgorithm;

import java.util.Map;

public enum AlgorithmFactory {
    ;

    public static AbstractAlgorithm getAlgorithm(Map<String, String> configMap) {

        AbstractAlgorithm algorithm;

        String alg = configMap.get("-alg") == null ? "shift" : configMap.get("-alg");
        String mode = configMap.get("-mode") == null ? "enc" : configMap.get("-mode");
        String key = configMap.get("-key") == null ? "0" : configMap.get("-key");

        if ("unicode".equals(alg)) {
            algorithm = new UnicodeAlgorithm(mode);
        } else if ("shift".equals(alg)) {
            algorithm  = new ShiftAlgorithm(mode);
        } else {
            throw new UnknownAlgorithmException("Error");
        }

        algorithm.setKey(key);

        return algorithm;
    }
}
