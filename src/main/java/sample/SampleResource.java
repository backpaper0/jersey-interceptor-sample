package sample;

import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;

@Transactional
@Path("sample")
public class SampleResource {

    /**
     * メソッドを抜けるとインターセプターによりコミットされる。
     * 
     * @return
     */
    @GET
    @Path("1")
    public String sayHello() {
        return "Hello, world!";
    }

    /**
     * 例外を投げてメソッドを抜けるとインターセプターによりロールバックされる。
     * 
     * @return
     */
    @GET
    @Path("2")
    public String throwException() {
        throw new InternalServerErrorException();
    }
}
