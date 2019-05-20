package homework_exception.task2;

import homework_exception.task2.myException.ExceptionForDao;

public class Dao {

    public static void doSomething() throws ExceptionForDao, RuntimeException{
        throw new ExceptionForDao("Произошла ошибка ExceptionForDao которая должна быть обработана в классе Service");
    }
}
