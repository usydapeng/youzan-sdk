package org.zunpeng.utils;

import java.security.MessageDigest;

public class Md5Utils {

    public static String md5(String src) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            return new String(Hex.encodeDigest(md.digest(src.getBytes())));
        } catch (Exception e) {
            throw new RuntimeException("Failed to digest security token.");
        }
    }

    private static final class Hex {

        private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        public static char[] encodeDigest(byte[] bytes) {
            final int nBytes = bytes.length;
            char[] result = new char[2 * nBytes];

            int j = 0;
            for (int i = 0; i < nBytes; i++) {

                int n = bytes[i];
                if (n < 0) {
                    n = 256 + n;
                }
                int d1 = n / 16;
                int d2 = n % 16;

                result[j++] = HEX[d1];
                result[j++] = HEX[d2];
            }
            return result;
        }
    }
}
