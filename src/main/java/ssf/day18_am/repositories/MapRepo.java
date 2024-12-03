package ssf.day18_am.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ssf.day18_am.constant.Constant;

@Repository
public class MapRepo {
    
    @Autowired @Qualifier(Constant.template02)
    private RedisTemplate<String, String> redisTemplate;

    public void createHash(String redisKey, String hashKey, String value) {
        redisTemplate.opsForHash().put(redisKey, hashKey, value);
    }

    public String getMap(String redisKey, String hashKey) {
        return redisTemplate.opsForHash().get(redisKey, hashKey).toString();
    }

    public void deleteKey(String redisKey, String hashKey) {
        redisTemplate.opsForHash().delete(redisKey, hashKey);
    }

    public boolean hashKeyExists(String redisKey, String hashKey) {
        return redisTemplate.opsForHash().hasKey(redisKey, hashKey);
    }

    public Set<Object> getAllKeys(String redisKey) {
        return redisTemplate.opsForHash().keys(redisKey);
    }

    public List<Object> getAllValues(String redisKey) {
        return redisTemplate.opsForHash().values(redisKey);
    }

    public long size(String redisKey) {
        return redisTemplate.opsForHash().size(redisKey);
    }

    public void increment(String redisKey, String hashKey, int count) {
        redisTemplate.opsForHash().increment(redisKey, hashKey, count);
    }

    
}
