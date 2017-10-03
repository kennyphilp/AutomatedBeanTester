package com.kwp.automatedbeantester.values;

import com.kwp.automatedbeantester.beaninfo.BeanProcessingException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by Kenny on 30/09/2017.
 */
public class RandomValueGenerator extends AbstractValueGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomValueGenerator.class);

    private Random rand;

    private final int MAX_STRING_SIZE = 10;
    private final int MAX_ARRAY_SIZE = 10;
    private final int MIN_ARRAY_SIZE = 2;

    protected RandomValueGenerator() {
        this.rand = new Random();
    }

    @Override
    public Object generateIntObj(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = getArrayLength();
            Object[] array = new Integer[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = rand.nextInt();
            }
            logArray(array);

            return array;
        }
        return rand.nextInt();
    }

    @Override
    public Object generateIntPrim(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = getArrayLength();
            int[] array = new int[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = rand.nextInt();
            }
            logArray(array);

            return array;
        }
        return (int)rand.nextInt();
    }

    @Override
    public Object generateFloatObj(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = getArrayLength();
            Object[] array = new Float[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = rand.nextFloat();
            }
            return array;
        }
        return rand.nextFloat();
    }

    @Override
    public Object generateFloatPrim(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = getArrayLength();
            float[] array = new float[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = rand.nextFloat();
            }
            return array;
        }
        return (float)rand.nextFloat();
    }

    @Override
    public Object generateDoubleObj(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = getArrayLength();
            Object[] array = new Double[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = rand.nextDouble();
            }
            return array;
        }

        return rand.nextDouble();
    }

    @Override
    public Object generateDoublePrim(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = getArrayLength();
            double[] array = new double[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = rand.nextDouble();
            }
            return array;
        }

        return (double)rand.nextDouble();
    }

    @Override
    public Object generateBooleanObj(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = MIN_ARRAY_SIZE + rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE);
            Object[] array = new Boolean[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = rand.nextBoolean();
            }
            return array;
        }
        return rand.nextBoolean();
    }

    @Override
    public Object generateBooleanPrim(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = MIN_ARRAY_SIZE + rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE);
            boolean[] array = new boolean[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = (boolean)rand.nextBoolean();
            }
            return array;
        }
        return (boolean)rand.nextBoolean();
    }

    @Override
    public Object generateLongObj(int arrayDimensions) throws BeanProcessingException {
        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = getArrayLength();
            Object[] array = new Long[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = rand.nextLong();
            }
            return array;
        }

        return rand.nextLong();
    }

    @Override
    public Object generateCharObj(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = MIN_ARRAY_SIZE + rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE);
            Character[] array = new Character[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = new Character((char)(rand.nextInt(128) + 'a'));
            }
            return array;
        }

        return new Character((char)(rand.nextInt(128) + 'a'));
    }

    @Override
    public Object generateCharPrim(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);
        if (arrayDimensions > 0) {
            int arryLength = MIN_ARRAY_SIZE + rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE);
            char[] array = new char[arryLength];

            for (int i = 0; i < arryLength; i++) {
                array[i] = (char)(rand.nextInt(128) + 'a');
            }
            return array;
        }

        return (Object)(char)(rand.nextInt(128) + 'a');
    }

    @Override
    public Object generateByteObj(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = MIN_ARRAY_SIZE + rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE);
            Byte[] array = new Byte[arryLength];

            byte data[] = new byte[arryLength];
            rand.nextBytes(data);

            for (int i = 0; i < arryLength; i++) {
                array[i] = data[i];
            }
            return array;
        }
        byte data[] = new byte[1];
        rand.nextBytes(data);
        return data[0];
    }

    @Override
    public Object generateBytePrim(int arrayDimensions) throws BeanProcessingException {

        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {

            int arryLength = MIN_ARRAY_SIZE + rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE);
            byte[] array = new byte[arryLength];

            rand.nextBytes(array);

            return array;
        }

        byte data[] = new byte[1];
        rand.nextBytes(data);
        return (byte)data[0];
    }


    @Override
    public Object generateString(int arrayDimensions, int size) throws BeanProcessingException {
        validateArrayDimensions(arrayDimensions);

        byte data[] = new byte[size];
        rand.nextBytes(data);
        return data.toString();
    }

    @Override
    public Object generateString(int arrayDimensions) throws BeanProcessingException {
        validateArrayDimensions(arrayDimensions);

        if (arrayDimensions > 0) {
            int arryLength = MIN_ARRAY_SIZE + rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE);
            Object[] array = new String[arryLength];

            for (int i = 0; i < arryLength; i++) {

                int length = 1+rand.nextInt(MAX_STRING_SIZE);
                array[i] = RandomStringUtils.random(length, true, true);
            }
            return array;
        }

        int length = 1+rand.nextInt(MAX_STRING_SIZE);
        return RandomStringUtils.random(length, true, true);
    }

    private void validateArrayDimensions(int arrayDimensions) throws BeanProcessingException {
        if (arrayDimensions > 1 || arrayDimensions < 0)
            throw new BeanProcessingException("Unsupported array dimension size specified.");
    }

    private int getArrayLength() {
        return MIN_ARRAY_SIZE + rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE);
    }

    private void logArray(Object[] array) {
        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            strB.append("ArrayValue" + i + ":" + array[i] + ", ");
        }

        LOGGER.info(strB.toString().substring(0, strB.toString().length() - 2));
    }

    private void logArray(int[] array) {
        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            strB.append("ArrayValue" + i + ":" + array[i] + ", ");
        }

        LOGGER.info(strB.toString().substring(0, strB.toString().length() - 2));
    }


}
