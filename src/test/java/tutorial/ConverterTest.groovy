package tutorial

import spock.lang.Specification

/**
 * Created by eric567 [email:gyc567@126.com] 
 * on 10/21/2016.
 */
class ConverterTest extends Specification {
    def "Convert"() {
        given:"  ConvertorUtil,the String 123 "
        String from="123"
        when:"invoke the method of ConverterUtil convert"
        Integer rt=ConverterUtil.convert(from)
        then:"the result shall be integer 123"
        rt==123


    }
}
