package sample;

import javax.inject.Singleton;

import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * HK2にオブジェクトを登録するためのクラス。
 *
 */
public class TransactionInterceptorBinder extends AbstractBinder {

    @Override
    protected void configure() {
        //InterceptionService実装クラスはSingletonスコープでなければならない
        bind(TransactionInterceptionService.class)
                .to(InterceptionService.class).in(Singleton.class);
    }
}
