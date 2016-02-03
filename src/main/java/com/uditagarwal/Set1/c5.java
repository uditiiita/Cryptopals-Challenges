package com.uditagarwal.Set1;

import com.uditagarwal.RepeatingKeyXOR;
import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;

/**
 * Created by uditagarwal on 2/3/16.
 */
public class c5 {
    static public void solve() {
        String text = "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal";
        String key = "ICE";

        String result = Hex.encodeHexString(RepeatingKeyXOR.repeatingKeyXOR(text.getBytes(), key.getBytes()));
        System.out.println(result);
    }
}
