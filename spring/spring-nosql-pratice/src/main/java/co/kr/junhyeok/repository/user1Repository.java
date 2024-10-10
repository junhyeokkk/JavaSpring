package co.kr.junhyeok.repository;

import co.kr.junhyeok.document.user1Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface user1Repository extends MongoRepository<user1Document, String> {

    public Optional<user1Document> findByUid(String uid);
    public Optional<user1Document> deleteByUid(String uid);

}
