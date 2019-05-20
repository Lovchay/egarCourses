package homework_exception.task2;

import homework_exception.task2.myException.ExceptionForClose;
import homework_exception.task2.myException.ExceptionForDao;
import homework_exception.task2.myException.ExceptionForService;

public class Service {
    public static void doSomething()throws ExceptionForService{
        try {
            Dao.doSomething();
        }catch (ExceptionForDao e){
            e.printStackTrace();
            throw new ExceptionForService("Получена ошибка ExceptionForService т.к. была отловлена ошибка ExceptionForDao");
        }
    }

    public static void close()throws ExceptionForClose{
        throw new ExceptionForClose("Получена ошибка ExceptionForClose финализирующая обработку");
    }
}
