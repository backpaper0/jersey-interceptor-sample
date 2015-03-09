package sample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.aopalliance.intercept.ConstructorInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.glassfish.hk2.api.Filter;
import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.internal.StarFilter;

/**
 * インターセプターを適用するためのクラス。
 *
 */
public class TransactionInterceptionService implements InterceptionService {

    @Override
    public Filter getDescriptorFilter() {
        //HK2が管理してるオブジェクトをフィルタリングする。
        //でも今回はしょぼいサンプルなので全部対象にしておく。
        return StarFilter.getDescriptorFilter();
    }

    @Override
    public List<MethodInterceptor> getMethodInterceptors(Method method) {
        return Stream
                //メソッド、またはメソッドが定義されたクラスに
                .of(method, method.getDeclaringClass())
                //@Transactionalが付いていれば
                .filter(a -> a.isAnnotationPresent(Transactional.class))
                .findAny()
                //TransactionInterceptorを適用する
                .map(a -> Arrays
                        .<MethodInterceptor> asList(new TransactionInterceptor()))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<ConstructorInterceptor> getConstructorInterceptors(
            Constructor<?> constructor) {
        //今回はコンストラクタはインターセプトしないので空のリストを返す
        return Collections.emptyList();
    }
}
