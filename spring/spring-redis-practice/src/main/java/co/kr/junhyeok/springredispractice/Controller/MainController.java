package co.kr.junhyeok.springredispractice.Controller;

import co.kr.junhyeok.springredispractice.Service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;

    @PostMapping("/redis/string")
    public void setValue(String key, String value) {
        mainService.setValue(key, value);
    }
    @GetMapping("/redis/string/{key}")
    public void getValue(@PathVariable("key") String key) {
        mainService.getValue(key);
    }

    @PostMapping("/redis/list-right")
    public void addToListFromRight(String key, String value) {}
    @PostMapping("/redis/list-left")
    public void addToListFromLeft(String key, String value){}

    @GetMapping("/redis/list/{key}/{index}")
    public ResponseEntity<String> getFromList(@PathVariable("key") String key, @PathVariable("index") int index) {
        return ResponseEntity.ok(mainService.getFromList(key, index));
    }
    @GetMapping("/redis/list/{key}/{start}/{end}")
    public ResponseEntity<List<String>> getRangeFromList(@PathVariable("key") String key,
                                 @PathVariable("start") int start,
                                 @PathVariable("end") int end){
        List<String> values = mainService.getRangeFromList(key, start, end);

        return ResponseEntity.ok(values);
    }

    @PostMapping("/redis/set")
    public void addToSet(String key, String[] value) {}
    @GetMapping("/redis/set/{key}")
    public void getFromSet(@PathVariable("key") String key) {}


    @PostMapping("/redis/hash")
    public void addToHash(String key, String hashKey, String value) {}

    @PostMapping("/redis/hash/{key}/{hashKey}")
    public void getFromHash(@PathVariable("key") String key,@PathVariable("hashKey") String hashKey) {}


}
