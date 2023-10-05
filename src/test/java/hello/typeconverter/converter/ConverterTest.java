package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @Test
    void stringToInteger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString(){
        IntegerToStringConverter co = new IntegerToStringConverter();
        String convert = co.convert(10);
        Assertions.assertThat(convert).isEqualTo("10");
    }
    
    @Test
    void StringToIpPort(){
        IpPortToStringConverter converter = new IpPortToStringConverter();

        String result = converter.convert(new IpPort("127", 8080));
        Assertions.assertThat(result).isEqualTo("127:8080");
    }

    @Test
    void ipPortToString(){
        StringToIpPortConverter convert = new StringToIpPortConverter();
        IpPort result = convert.convert("127:8080");
        Assertions.assertThat(result).isEqualTo(new IpPort("127",8080));
    }
}
