package org.blueant.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Leon, created at: 05/14/2015, 10:48 AM.
 */

public class CSVParser {
  public List<String> parse(String str) {
    if (str == null || str.length() == 0) return null;
    List<String> res = new ArrayList<>();
    boolean hasQuote = str.charAt(0) == '"';
    int st = 0, ed = 1;
    while (ed < str.length()) {
      char ch = str.charAt(ed);
      if (ch == '"') {
        hasQuote = !hasQuote;
      } else if (ch == ',' && !hasQuote) {
        res.add(str.substring(st, ed));
        st = ed + 1;
        hasQuote = false;
      }
      ed++;
    }
    if (st < ed) res.add(str.substring(st, ed));
    return res;
  }

  public static void main(String[] args) {
    new CSVParser().parse("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1");
    new CSVParser().parse("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0");
    new CSVParser().parse("John,Smith,john.smith@gmail.com,Los Angeles,1");
  }
}
