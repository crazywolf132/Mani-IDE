package com.sol.util;

public class StringUtils {

    public static final String EMPTY = "";

    public StringUtils() {

    }

    public static String replace(String text, String searchString, String replacement) {
        if (text != null && !text.isEmpty() && !searchString.isEmpty()) {
            if (replacement == null) {
                replacement = "";
            }

            int start = 0;
            int max = -1;
            int end = text.indexOf(searchString, start);
            if (end == -1) {
                return text;
            } else {
                int replaceLength = searchString.length();
                int increase = replacement.length() - replaceLength;
                increase = increase < 0 ? 0 : increase;
                increase *= 16;

                StringBuilder sb;
                for(sb = new StringBuilder(text.length() + increase); end != -1; end = text.indexOf(searchString, start)) {
                    sb.append(text.substring(start, end)).append(replacement);
                    start = end + replaceLength;
                    --max;
                    if (max == 0) {
                        break;
                    }
                }

                sb.append(text.substring(start));
                return sb.toString();
            }
        } else {
            return text;
        }
    }
}
