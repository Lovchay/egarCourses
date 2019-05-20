package homework_exception.task2;

import homework_exception.task2.myException.ExceptionForApplication;
import homework_exception.task2.myException.ExceptionForClose;
import homework_exception.task2.myException.ExceptionForService;

public class Controller {

    public static void doSomething()throws ExceptionForApplication{
        try{
            Service.doSomething();
        }catch (ExceptionForService e){
            e.printStackTrace();
            throw new ExceptionForApplication("Произошла проброска ошибки ExceptionForApplication");
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            try{
                Service.close();
            }catch (ExceptionForClose e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try{
            Controller.doSomething();
        }catch (ExceptionForApplication e){
            e.printStackTrace();
        }
    }

}
