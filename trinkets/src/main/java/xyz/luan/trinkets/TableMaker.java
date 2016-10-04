package xyz.luan.trinkets;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.google.common.base.Joiner;

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
            String error = error(columns[i + 1]);
            int decimalPlaces = error.split("\\.")[1].length();
            String rawValue = columns[i];
            if (rawValue.indexOf("\\.") == -1) {
                rawValue += ".0";
            }
            String value = value(rawValue, decimalPlaces);
            actualColumns.add("$" + value + " \\pm " + error + "$");
        }
        return Joiner.on(" & ").join(actualColumns) + " \\\\";
    }

    private static String value(String value, int dp) {
      int dot = value.indexOf('.');
      int p = dot + dp + 1;
      if (p >= value.length()) {
          while (p > value.length()) {
              value += '0';
          }
          return value;
      }
      boolean roundUp = value.charAt(dot + dp + 1) >= '5';
      String n = value.substring(0, p);
      return roundUp ? next(n) : n;
    }

    private static String error(String error) {
      boolean dot = false;
      String result = "";
      for (int i = 0; i < error.length(); i++) {
        char c = error.charAt(i);
        result += c;
        if (dot) {
          if (c != '0') {
            if (error.length() == i + 1 || error.charAt(i + 1) < '5') {
              return result;
            }
            return next(result);
          }
        } else {
          if (c == '.') {
            dot = true;
          }
        }
      }
      return result;
    }

    private static String next(String number) {
        String end = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            char c = number.charAt(i);
            if (c == '.') {
                end = '.' + end;
            } else if (c != '9') {
                end = (char) (c + 1) + end;
                return number.substring(0, i) + end;
            } else {
                end = '0' + end;
            }
        }
        return '1' + number;
    }
}
