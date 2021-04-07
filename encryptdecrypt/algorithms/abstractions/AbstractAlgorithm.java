package encryptdecrypt.algorithms.abstractions;

public abstract class AbstractAlgorithm implements AlgorithmInterface {

    String mode;

    public AbstractAlgorithm(String mode) {
        this.mode = mode;
    }

    protected abstract String encode(String line);
    protected abstract String decode(String line);

    public String compute(String line) {
        if ("enc".equals(mode)) {
            return encode(line);
        } else {
            return decode(line);
        }
    }

}
