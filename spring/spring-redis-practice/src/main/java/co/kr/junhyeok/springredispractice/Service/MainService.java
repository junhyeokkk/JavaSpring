package co.kr.junhyeok.springredispractice.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class MainService {

    private final StringRedisTemplate stringRedisTemplate;

    public void setValue(String key, String value) {
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        valueOps.set(key, value);
    }
    public String getValue(String key){
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        String value = valueOps.get(key);
        return value;
    }

    public void addToListFromRight(String key, String value) {
        ListOperations<String, String> listOps = stringRedisTemplate.opsForList();
        listOps.rightPush(key, value);
    }
    public void addToListFromLeft(String key, String value){
        ListOperations<String, String> listOps = stringRedisTemplate.opsForList();
        listOps.leftPush(key, value);
    }

    public String getFromList(String key, int index){
        ListOperations<String, String> listOps = stringRedisTemplate.opsForList();
        return listOps.index(key, index);
    }
    public List<String> getRangeFromList(String key, int start, int end){
        ListOperations<String, String> listOps = stringRedisTemplate.opsForList();
        return listOps.range(key, start, end);
    }


    public void addToSet(String key, String... values) {
        SetOperations<String, String> setOps = stringRedisTemplate.opsForSet();
        setOps.add(key, values);
    }
    public Set<String> getFromSet(String key){
        SetOperations<String, String> setOps = stringRedisTemplate.opsForSet();
        return setOps.members(key);
    }

    public void addToHash(String key, String hashKey, String value) {
        HashOperations<String, String, String> hashOps = stringRedisTemplate.opsForHash();
        hashOps.put(key, hashKey, value);
    }
    public String getFromHash(String key, String hashKey){
        HashOperations<String, String, String> hashOps = stringRedisTemplate.opsForHash();
        return hashOps.get(key, hashKey);
    }
}
