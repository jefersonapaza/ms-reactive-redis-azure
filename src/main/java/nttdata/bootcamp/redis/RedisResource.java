package nttdata.bootcamp.redis;

import io.smallrye.mutiny.Uni;
import nttdata.bootcamp.redis.entity.WalletRedis;
import nttdata.bootcamp.redis.repository.WalletRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RedisResource {



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive REDIS";
    }






}