package encryptdecrypt;

import encryptdecrypt.algorithms.factories.AlgorithmFactory;
import encryptdecrypt.algorithms.abstractions.AlgorithmInterface;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CryptographicMachine {

    private final BufferedReader reader;
    private final PrintWriter printer;
    private final AlgorithmInterface algorithm;

    public CryptographicMachine(String[] args) {

        Map<String, String> configMap = new HashMap<>();

        int argsNumber = args.length;

        for (int i = 0; i < argsNumber; i++) {
            String token = args[i];
            String value = "";
            if (i + 1 < argsNumber) {
                value = args[i + 1];
            }
            if (token.startsWith("-")) {
                configMap.put(token.toLowerCase(), value);
            }
        }

        this.algorithm = AlgorithmFactory.getAlgorithm(configMap);
        this.reader = getInputData(configMap);
        this.printer = getPrintWriter(configMap);

    }

    private BufferedReader getInputData(Map<String, String> configMap) {

        BufferedReader bufferedReader = new BufferedReader(new StringReader(""));

        String data = configMap.get("-data");
        String fileName = configMap.get("-in");

        if (data == null) {
            if (fileName != null) {
                try {
                    FileReader fileReader = new FileReader(fileName);
                    bufferedReader = new BufferedReader(fileReader);
                } catch (FileNotFoundException e) {
                    // do not worry
                }
            }
        } else {
            bufferedReader = new BufferedReader(new StringReader(data));
        }

        return bufferedReader;
    }

    private PrintWriter getPrintWriter(Map<String, String> configMap) {
        PrintWriter printWriter = new PrintWriter(System.out);
        String fileName = configMap.get("-out");

        if (fileName != null) {
            try {
                return new PrintWriter(fileName);
            } catch (FileNotFoundException e) {
                // do not worry
            }
        }

        return printWriter;
    }

    public void execute() {
        String line;
        try {
            while ((line = this.reader.readLine()) != null) {
                this.printer.println(algorithm.compute(line));
            }
            this.reader.close();
            this.printer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
