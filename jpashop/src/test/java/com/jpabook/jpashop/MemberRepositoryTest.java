package com.jpabook.jpashop;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {

    /**
     * 참고
     * EntityManager를 이용한 모든 데이터 변경은 항상 트랜젝션 안에서 이루어져야 한다.
     */

    @Autowired
    MemberRepository memberRepository;
    @Test
    @Transactional
    @Rollback(value = false)
    void testMember() throws Exception {
        // given
        Member member = new Member();
        member.setUserName("memberA");

        // when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());

        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member :  " + (findMember == member));
    }

    @Test
    void find() {
    }
}