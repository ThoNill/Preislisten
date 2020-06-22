package tho.nill.preislisten.simpleAttributes;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TarifkennzeichenAdapter implements
        AttributeConverter<Tarifkennzeichen, String> {

    @Override
    public String convertToDatabaseColumn(Tarifkennzeichen attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.toString();
    }

    @Override
    public Tarifkennzeichen convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return new Tarifkennzeichen(dbData);
    }

 

}