package sample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 自動トランザクションを行うためのインターセプター、のシミュレート。
 *
 */
public class TransactionInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("begin transaction");
        try {

            //リソースメソッド実行
            Object returnValue = invocation.proceed();

            System.out.println("commit");
            return returnValue;

        } catch (Throwable t) {
            System.out.println("rollback");
            throw t;
        }
    }
}
