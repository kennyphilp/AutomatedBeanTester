package com.kwp.automatedbeantester.values;

import com.kwp.automatedbeantester.beaninfo.BeanInformation;
import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;
import com.kwp.automatedbeantester.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kenny on 01/10/2017.
 */
public abstract class AbstractValueGenerator implements ValueGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractValueGenerator.class);

    protected AbstractValueGenerator() {
    }

    @Override
    public Map<String, Object> generateBeanValues(BeanInformation beanInfo) throws BeanProcessingException {

        Map<String, Object> beanProperties = new HashMap();

        LOGGER.info("Generating BeanProperties for class:" + beanInfo.getClassName());

        for (Map.Entry<String, Field> entry : beanInfo.getFields().entrySet()) {

            LOGGER.info("Generating values for property" + entry.getKey() + entry.getValue().getType());
            String fieldName = entry.getKey();
            String memberType = entry.getValue().getType().getName();


            int arrayDimensions = 0;
            if (memberType.startsWith("[")) {
                arrayDimensions = StringUtils.numRepeatCharStartStr(memberType);

                if (arrayDimensions > 1)
                    throw new BeanProcessingException("Multi dimensional arrays not supported.");

                if (memberType.equals("[Z")) {
                          memberType="boolean";
                }
                else if (memberType.equals("[I")) {
                    memberType="int";
                }
                else if (memberType.equals("[F")) {
                    memberType="float";
                }
                else if (memberType.equals("[D")) {
                    memberType="double";
                }
                else if (memberType.equals("[C")) {
                    memberType="char";
                }
                else if (memberType.equals("[B")) {
                    memberType="byte";
                }
                else {
                    memberType = memberType.substring(arrayDimensions + 1);
                    memberType = memberType.replace(";", "");
                }
            }

            generatePropertyValue(memberType, fieldName, arrayDimensions, beanProperties);
        }

        return beanProperties;
    }

    private void generatePropertyValue(String memberType, String fieldName, int arrayDimensions, Map<String, Object> beanProperties) throws BeanProcessingException {
        switch (memberType) {

            case "boolean":
                beanProperties.put(fieldName, this.generateBooleanPrim(arrayDimensions));
                break;
            case "java.lang.Boolean":
                beanProperties.put(fieldName, this.generateBooleanObj(arrayDimensions));
                break;

            case "int":
                beanProperties.put(fieldName, this.generateIntPrim(arrayDimensions));
                break;
            case "java.lang.Integer":
                beanProperties.put(fieldName, this.generateIntObj(arrayDimensions));
                break;

            case "float":
                beanProperties.put(fieldName, this.generateFloatPrim(arrayDimensions));
                break;
            case "java.lang.Float":
                beanProperties.put(fieldName, this.generateFloatObj(arrayDimensions));
                break;

            case "double":
                beanProperties.put(fieldName, this.generateDoublePrim(arrayDimensions));
                break;
            case "java.lang.Double":
                beanProperties.put(fieldName, this.generateDoubleObj(arrayDimensions));
                break;

            case "java.lang.String":
                beanProperties.put(fieldName, this.generateString(arrayDimensions));
                break;

            case "char":
                beanProperties.put(fieldName, this.generateCharPrim(arrayDimensions));
                break;
            case "java.lang.Character":
                beanProperties.put(fieldName, this.generateCharObj(arrayDimensions));
                break;

            case "byte":
                beanProperties.put(fieldName, this.generateBytePrim(arrayDimensions));
                break;
            case "java.lang.Byte":
                beanProperties.put(fieldName, this.generateByteObj(arrayDimensions));
                break;


            default:
                LOGGER.error("Unhandled member type:{}", memberType);
        }

    }

}
