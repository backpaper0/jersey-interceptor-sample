package sample;

import java.net.URI;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

public class SampleMain {

    public static void main(String[] args) {
        URI uri = URI.create("http://localhost:8080/api/");
        ResourceConfig config = new SampleApplication();
        HttpServer server = JdkHttpServerFactory.createHttpServer(uri, config);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.stop(0)));

        System.out.printf("%ssample/1 でコミットする%n", uri);
        System.out.printf("%ssample/2 でロールバックする%n", uri);
    }
}
