package com.shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="cart")
public class Cart extends BaseEntity {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY) //회원 엔티티와 일대일로 매핑
    @JoinColumn(name = "member_id") //매핑할 외래키를 지정
    private Member member;
}
