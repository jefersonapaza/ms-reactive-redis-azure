package nttdata.bootcamp.redis;


import io.smallrye.mutiny.Uni;
import nttdata.bootcamp.redis.entity.WalletRedis;
import nttdata.bootcamp.redis.repository.WalletRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/redis/wallet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RedisWalletResource {

    @Inject
    WalletRepository walletRepository;

    @POST
    @Path("/save")
    public WalletRedis save(WalletRedis walletRedis) {
        walletRepository.save(walletRedis.getIdWallet(),walletRedis);
        return walletRedis;
    }


    @GET
    @Path("/{key}")
    public WalletRedis get(String key) {
        return walletRepository.get(key);
    }

}
