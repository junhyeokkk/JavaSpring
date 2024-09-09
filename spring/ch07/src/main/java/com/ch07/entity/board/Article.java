package com.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Entity                 // 엔티티 객체 정의 어노테이션
@Table(name ="board_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private String title;
    private String content;

    @CreationTimestamp
    private LocalDateTime rdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article") // OneToMany는 mappedBy 꼭 써주기
    private List<File> file;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> comment;


}
