package vip.codemonkey.datastore.data.jpa.utils;

/**
 *  StringOperator 创建者
 * @author  wang zhengtao
 */
public class StringOperatorBuilder {

    private String regex;
    private String delimiter;

    public StringOperatorBuilder(){
        this.regex = Punctuations.COMMA;
    }

    public  StringOperatorBuilder delimiter(String delimiter){
        this.delimiter = delimiter;
        return this;
    }

    public  StringOperatorBuilder regex(String regex){
        this.regex = regex;
        return this;
    }

    public StringOperator create(){
        StringOperator operator = new StringOperator();
        operator.setRegex(this.regex);
        operator.setDelimiter(delimiter);
        return operator;
    }
}
