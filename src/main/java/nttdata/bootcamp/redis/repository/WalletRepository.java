package nttdata.bootcamp.redis.repository;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.string.StringCommands;
import io.smallrye.mutiny.Uni;
import nttdata.bootcamp.redis.entity.WalletRedis;

import javax.inject.Singleton;
import java.util.Date;
import java.util.List;

@Singleton
public class WalletRepository {


    private ReactiveKeyCommands<String> keys;
    private StringCommands<String, WalletRedis> redisTemplate;

    public WalletRepository(RedisDataSource redisDS, ReactiveRedisDataSource reactiveRedisDS) {
        keys = reactiveRedisDS.key();
        redisTemplate = redisDS.string(WalletRedis.class);
    }


    Uni<Void> del(String key) {
        return keys.del(key)
                .replaceWithVoid();

    }

    public WalletRedis get(String key) {
        return redisTemplate.get(key);
    }

    public void set(String key, WalletRedis value) {
        redisTemplate.set(key, value);
    }

    public WalletRedis save(String key ,WalletRedis walletRedis) {
        walletRedis.setExpirationDate(new Date());
        redisTemplate.set(key,walletRedis);
        return walletRedis;
    }

    void increment(String key, int incrementBy) {
        redisTemplate.incrby(key, incrementBy);
    }

    public Uni<List<String>> keys() {
        return keys
                .keys("*");
    }




}
