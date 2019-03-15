package vip.codemonkey.datastore.data.jpa.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 字符串常用操作
 * @author  wang zhengtao
 */
public class StringOperator {
    private String regex;
    private String delimiter;

    public List<String> split(String splitStr){
        return Arrays.asList(splitStr.split(regex));
    }

    public String compose(List<String> stringList){
        return String.join(delimiter,stringList);
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
