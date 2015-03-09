package sample;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Applicationサブクラス。
 * Jerseyに依存すること前提なのでJerseyに用意されているResourceConfigをextendsしちゃう。
 *
 */
public class SampleApplication extends ResourceConfig {

    public SampleApplication() {
        //リソースクラスを登録する。
        register(SampleResource.class);

        //TransactionInterceptorを適用するためのBinderを登録する。
        //BinderはClassではなくインスタンスを登録する必要がある。
        register(new TransactionInterceptorBinder());
    }
}
