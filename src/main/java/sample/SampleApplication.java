package sample;

import org.glassfish.jersey.server.ResourceConfig;

public class SampleApplication extends ResourceConfig {

    public SampleApplication() {
        register(SampleResource.class);
        register(new TransactionInterceptorBinder());
    }
}
