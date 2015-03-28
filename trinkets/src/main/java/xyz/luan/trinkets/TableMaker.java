package xyz.luan.trinkets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableMaker {

    public static String convertBody(String table) {
        String result = "";
        for (String line : table.split("\n")) {
            result += parseLine(line) + "\n";
        }
        return result;
    }

    private static String parseLine(String line) {
        List<String> actualColumns = new ArrayList<>();
        String[] columns = line.split("\\s+");
        for (int i = 0; i < columns.length; i += 2) {
            BigDecimal value = new BigDecimal(columns[i]);
            BigDecimal error = new BigDecimal(columns[i + 1]);
            String errorString = error(error, 1);
            int decimalPlaces = errorString.split("\\.")[1].length();
            String valueString = String.format("%." + decimalPlaces + "f", value);

            actualColumns.add("$" + valueString + " \\pm " + errorString + "$");
        }
        return actualColumns.stream().collect(Collectors.joining(" & ")) + " \\\\";
    }

    private static String error(BigDecimal bd, int significantFigures) {
        return String.format("%." + significantFigures + "G", bd);
    }
}