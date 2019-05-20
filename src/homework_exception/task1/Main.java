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
        throw new ArithmeticException();
    }

    public static void getArrayIndexOutOfBoundsException() {
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void getClassNotFoundException() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    public static void getFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void getIOException() throws IOException {
        throw new IOException();
    }

    public static void getNoSuchFieldException() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public static void getNoSuchMethodException() throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    public static void getNullPointerException() {
        throw new NullPointerException();
    }

    public static void getNumberFormatException() {
        throw new NumberFormatException();
    }

    public static void getRuntimeException() {
        throw new RuntimeException();
    }

    public static void getStringIndexOutOfBoundsException() {
        throw new StringIndexOutOfBoundsException();
    }

}
