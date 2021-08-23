package spring.mvcpractice.Post.domain;

import lombok.*;
import spring.mvcpractice.Post.BaseTimeEntity;

import javax.persistence.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false , unique = true)
    private String emailId;

    private String userName;

    private Long password;

}
