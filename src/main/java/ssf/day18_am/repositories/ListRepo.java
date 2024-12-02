package ssf.day18_am.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ssf.day18_am.constant.Constant;

@Repository
public class ListRepo {

    @Autowired @Qualifier(Constant.template01)
    private RedisTemplate<String, String> redisTemplate;

    public void leftPush(String redisKey, String value) {
        redisTemplate.opsForList().leftPush(redisKey, value);
    }

    public void rightPush(String redisKey, String value) {
        redisTemplate.opsForList().rightPush(redisKey, value);
    }
    
    public void leftPop(String redisKey) {
        redisTemplate.opsForList().leftPop(redisKey);
    }

    public void rightPop(String redisKey) {
        redisTemplate.opsForList().rightPop(redisKey);
    }

    public long size(String redisKey) {
        return redisTemplate.opsForList().size(redisKey);
    }

    public String get(String redisKey, int index) {
        return redisTemplate.opsForList().index(redisKey, index);
    }

    public List<String> getList(String redisKey) {
        return redisTemplate.opsForList().range(redisKey, 0, -1);
    }
}
