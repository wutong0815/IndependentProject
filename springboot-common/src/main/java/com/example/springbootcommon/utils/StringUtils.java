package com.example.springbootcommon.utils;

import java.util.regex.Pattern;

public class StringUtils extends org.springframework.util.StringUtils {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^1[3-9]\\d{9}$");

    private static final Pattern ID_CARD_PATTERN =
            Pattern.compile("^\\d{17}[0-9Xx]$");

    private static final Pattern BANK_CARD_PATTERN =
            Pattern.compile("^\\d{16,19}$");

    private static final Pattern URL_PATTERN =
            Pattern.compile("^https?://[\\w-]+(\\.[\\w-]+)+([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?$");

    private static final Pattern IP_ADDRESS_PATTERN =
            Pattern.compile("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{}|;:'\",.<>/?]{8,}$");

    public static boolean isEmail(String str) {
        return EMAIL_PATTERN.matcher(str).matches();
    }

    public static boolean isPhone(String str) {
        return PHONE_PATTERN.matcher(str).matches();
    }

    public static boolean isIdCard(String str) {
        return ID_CARD_PATTERN.matcher(str).matches();
    }

    public static boolean isBankCard(String str) {
        return BANK_CARD_PATTERN.matcher(str).matches();
    }


    public static boolean isUrl(String str) {
        return URL_PATTERN.matcher(str).matches();
    }

    public static boolean isIpAddress(String str) {
        return IP_ADDRESS_PATTERN.matcher(str).matches();
    }

    public static boolean isPassword(String str) {
        return PASSWORD_PATTERN.matcher(str).matches();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String defaultIfEmpty(String str, String defaultValue) {
        return hasText(str) ? str : defaultValue;
    }
}
