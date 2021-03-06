package com.uditagarwal;

/**
 * Created by uditagarwal on 1/28/16.
 */
public class Base64Encoder {
    private String mapper;
    public Base64Encoder() {
        this.mapper = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        assert mapper.length() == 4;
    }

    String base64Block(String bits) {
        Integer decimal = Integer.parseInt(bits, 2);
        return "" + mapper.charAt(decimal); // To convert char to string.
    }

    String base64From24Bits(String binary) {
        String result = "";
        for (int i = 0; i < binary.length(); i += 6) {
            String block = binary.substring(i, i + 6);
            result += base64Block(block);
        }
        return result;
    }

    String base64BlockFromMax24Bits(String binary) {
        String equalsChars = "";
        String zeroPadding = "";
        if (binary.length() == 16) {
            equalsChars = "=";
            zeroPadding = "00";
        } else if (binary.length() == 8) {
            equalsChars = "==";
            zeroPadding = "0000";
        }
        binary += zeroPadding;
        return base64From24Bits(binary) + equalsChars;
    }

    String binaryToBase64(String binary) {
        String base64 = "";
        while (binary.length() > 0) {
            String block;
            if (binary.length() > 24) {
                block = binary.substring(0, 24);
            } else  {
                block = binary;
            }
            base64 += base64BlockFromMax24Bits(block);
            binary = binary.substring(block.length());
        }

        return base64;
    }

    public String base64EncodingFromHex(String hexString) {
        String binaryString = BaseConverter.hexToBin(hexString);
        return binaryToBase64(binaryString);
    }
}
