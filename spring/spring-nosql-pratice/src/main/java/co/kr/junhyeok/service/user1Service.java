package co.kr.junhyeok.service;

import co.kr.junhyeok.document.user1Document;
import co.kr.junhyeok.repository.user1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class user1Service {

    private final user1Repository user1repository;


    public List<user1Document> findAllUser1s() {
        List<user1Document> user1List = user1repository.findAll();

        return user1List;

    }

    public user1Document findUser1(String uid) {
        Optional<user1Document> opt = user1repository.findByUid(uid);
        if (opt.isPresent()) {
            user1Document user1 = opt.get();
            return user1;
        }
        return null;
    }

    public user1Document insertUser1(user1Document user1) {

        return user1repository.save(user1);
    }

    public user1Document updateUser1(user1Document user1) {
        return user1repository.save(user1);
    }

    public boolean deleteUser1(String uid) {
        Optional<user1Document> opt = user1repository.deleteByUid(uid);
        if(opt.isPresent()) {
            return true;
        }
        return false;
    }

}
