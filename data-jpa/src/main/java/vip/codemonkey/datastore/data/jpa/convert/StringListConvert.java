package vip.codemonkey.datastore.data.jpa.convert;

import vip.codemonkey.datastore.data.jpa.utils.Punctuations;
import vip.codemonkey.datastore.data.jpa.utils.StringOperator;
import vip.codemonkey.datastore.data.jpa.utils.StringOperatorBuilder;

import javax.persistence.AttributeConverter;
import java.util.List;

public class StringListConvert implements AttributeConverter<List<String>,String> {
    private final StringOperator stringOperator = new StringOperatorBuilder().regex(Punctuations.COMMA).delimiter(Punctuations.COMMA).create();

    @Override
    public  String convertToDatabaseColumn(List<String> attribute) {
        return stringOperator.compose(attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return stringOperator.split(dbData);
    }
}
