package org.bestsoft.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.stereotype.Component;

@Component
public class PinYinUtils {
    public String getHanziInitials(String hanzi) {
        String result = null;
        if (null != hanzi && !"".equals(hanzi)) {
            char[] charArray = hanzi.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char ch : charArray) {
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(ch);
                if (null != stringArray) {
                    sb.append(stringArray[0].charAt(0));
                }
            }
            if (sb.length() > 0) {
                result = sb.toString().toUpperCase();
            }
        }
        return result;
    }

    public String getHanziPinYin(String hanzi) {
        String result = null;
        if (null != hanzi && !"".equals(hanzi)) {
            char[] charArray = hanzi.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char ch : charArray) {
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(ch);
                if (null != stringArray) {
                    sb.append(stringArray[0].replaceAll("\\d", ""));
                }
            }
            if (sb.length() > 0) {
                result = sb.toString();
            }
        }
        return result;
    }
}
