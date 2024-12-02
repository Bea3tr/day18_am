package ssf.day18_am.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ssf.day18_am.constant.Constant;

@Repository
public class ValueRepo {

    @Autowired @Qualifier(Constant.template01)
    private RedisTemplate<String, String> redisTemplate;

    public void setValue(String redisKey, String value) {
        redisTemplate.opsForValue().set(redisKey, value);
    }

    public String getValue(String redisKey) {
        return redisTemplate.opsForValue().get(redisKey);
    }

    public void incrementValue(String redisKey) {
        redisTemplate.opsForValue().increment(redisKey);
    }

    public void decrementValue(String redisKey) {
        redisTemplate.opsForValue().decrement(redisKey);
    }

    public void incrementByValue(String redisKey, int valueToIncrement) {
        redisTemplate.opsForValue().increment(redisKey, valueToIncrement);
    }

    public void decrementByValue(String redisKey, int valueTodecrement) {
        redisTemplate.opsForValue().decrement(redisKey, valueTodecrement);
    }

    public void deleteKey(String redisKey) {
        redisTemplate.delete(redisKey);
    }

    public boolean keyExists(String redisKey) {
        return redisTemplate.hasKey(redisKey);
    }
    
}
