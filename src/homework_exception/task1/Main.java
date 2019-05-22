package homework_exception.task1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            getArithmeticException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        try {
            getArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();

        }

        try {
            getClassNotFoundException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            getFileNotFoundException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            getIOException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            getNoSuchFieldException();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            getNoSuchMethodException();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            getNullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            getNumberFormatException();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            getRuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            getStringIndexOutOfBoundsException();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    public static void getArithmeticException() {
         ArithmeticException e = new ArithmeticException();
         throw e;
    }

    public static void getArrayIndexOutOfBoundsException() {
        ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException();
        throw e;
    }

    public static void getClassNotFoundException() throws ClassNotFoundException {
        ClassNotFoundException e = new ClassNotFoundException();
        throw e;
    }

    public static void getFileNotFoundException() throws FileNotFoundException {
        FileNotFoundException e = new FileNotFoundException();
        throw e;
    }

    public static void getIOException() throws IOException {
        IOException e = new IOException();
        throw e;
    }

    public static void getNoSuchFieldException() throws NoSuchFieldException {
        NoSuchFieldException e = new NoSuchFieldException();
        throw e;
    }

    public static void getNoSuchMethodException() throws NoSuchMethodException {
        NoSuchMethodException e = new NoSuchMethodException();
        throw e;
    }

    public static void getNullPointerException() {
        NullPointerException e = new NullPointerException();
        throw e;
    }

    public static void getNumberFormatException() {
        NumberFormatException e = new NumberFormatException();
        throw e;
    }

    public static void getRuntimeException() {
        RuntimeException e = new RuntimeException();
        throw e;
    }

    public static void getStringIndexOutOfBoundsException() {
        StringIndexOutOfBoundsException e = new StringIndexOutOfBoundsException();
        throw e;
    }

}
