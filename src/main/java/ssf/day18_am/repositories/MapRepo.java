package ssf.day18_am.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ssf.day18_am.constant.Constant;

@Repository
public class MapRepo {
    
    @Autowired @Qualifier(Constant.template01)
    private RedisTemplate<String, String> redisTemplate;

    public void setMap(String redisKey, String hashKey, String value) {
        redisTemplate.opsForHash().put(redisKey, hashKey, value);
    }

    public String getMap(String redisKey, String hashKey) {
        return redisTemplate.opsForHash().get(redisKey, hashKey).toString();
    }
}
