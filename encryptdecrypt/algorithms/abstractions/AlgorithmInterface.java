package encryptdecrypt.algorithms.abstractions;

public interface AlgorithmInterface {

    void setKey(String key);

    String compute(String line);

}
