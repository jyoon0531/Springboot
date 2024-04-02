package com.study.Ex12H2DB;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MemberRepositoryTest extends Ex12H2DbApplicationTests {
    // Test에서는 생성자 주입이 안됨.
    // 필드 주입
    @Autowired
    MemberRepository memberRepository;

    @BeforeAll  // static 메소드
    static void setup() {
        System.out.println("@BeforeAll - 클래스 초기화시 한번 수행");
    }

    @BeforeEach
        // non-static 메소드
    void init() {
        System.out.println("@BeforeEach - @Test 메소드 호출시마다 한번 수행");
        save();
    }

    @Test   // 테스트할 메소드에 사용
    @DisplayName("save 테스트")    // 콘솔에 출력되는 메소드 이름
    public void save() {
        //memberRepository.save(new MemberEntity(1L, "hong", "1234", "홍길동", "ROlE_USER", LocalDate.now()));
        //memberRepository.save(new MemberEntity(2L, "tom", "1234", "톰아저씨", "ROlE_USER", LocalDate.now()));
        //memberRepository.save(new MemberEntity(3L, "admin", "1234", "관리자", "ROlE_ADMIN", LocalDate.now()));

        memberRepository.save(new MemberEntity(1L,
                "hong", "1234", "홍길동", "ROLE_USER", LocalDate.parse("2023-01-01")
        ));
        memberRepository.save(new MemberEntity(2L,
                "tom", "1234", "톰아저씨", "ROLE_USER", LocalDate.parse("2023-02-01")
        ));
        memberRepository.save(new MemberEntity(3L,
                "admin", "1234", "관리자", "ROLE_ADMIN", LocalDate.parse("2023-03-01")
        ));


        List<MemberEntity> list = memberRepository.findAll();
        for (MemberEntity m : list) {
            System.out.println(m.getUserName());
        }

        // Assert Function
//        assertEquals(3, list.size());
//        assertEquals(4, list.size());
    }

    @Test
    @DisplayName("findById 테스트")
    public void findById() {
        // Optional 클래스 : JDK 9부터 제공. null safety
        Optional<MemberEntity> member = memberRepository.findById(1L);

        member.ifPresentOrElse((unwrappedMemberEntity) -> {
            // null이 아닐 때 수행되는 람다식
            System.out.println(unwrappedMemberEntity.getUserName());
            assertEquals("홍길동", unwrappedMemberEntity.getUserName());
        }, () -> fail("member 값 가져오기 실패"));

    }

    @Test
    @DisplayName("count 테스트")
    public void count() {
        // SQL : SELECT COUNT(*) FROM MEMBER
        Long count = memberRepository.count();
        System.out.println("count: " + count);
        assertEquals(3, count);

    }

    @Test
    @DisplayName("쿼리메소드 테스트")
    public void query() {
        // 패턴 : find + By + 필드명 + And + 필드명
        List<MemberEntity> list = memberRepository.findByUserId("tom");
        assertEquals(1, list.size());
        assertEquals("tom", list.get(0).getUserId());

        // SQL : SELECT * FROM MEMBER
        //       WHERE user_id = :userId AND user_name = :userName
        //       ORDER BY id DESC
        //       LIMIT 5
        List<MemberEntity> list2 = memberRepository.findFirst5ByUserIdAndUserNameOrderByIdDesc("hong", "홍길동");
        assertEquals(1, list2.size());

        Boolean isExist = memberRepository.existsByJoindateLessThanEqual(LocalDate.now());
        System.out.println("isExist = " + isExist);

        long count = memberRepository.countByUserNameIgnoreCaseLike("길");
        System.out.println("count = " + count);

    }

    @Test
    @DisplayName("JPQL 테스트")
    public void jpqlQuery() {
        List<MemberEntity> list = memberRepository.findByUserId_JPQL_Query("tom");
        assertEquals(1, list.size());
        assertEquals("톰아저씨", list.get(0).getUserName());
    }

    @Test
    @DisplayName("Native Query 테스트")
    public void nativeQuery() {
        List<MemberEntity> list = memberRepository.findByUserId_nativeQuery("admin");
        assertEquals(1, list.size());
        assertEquals("관리자", list.get(0).getUserName());
    }

    @Test
    @DisplayName("update 테스트")
    public void update() {
        Optional<MemberEntity> member = memberRepository.findById(1L);
        member.ifPresentOrElse((newMember) -> {
            assertEquals("hong", newMember.getUserId());
            newMember.update("hong2", newMember.getUserName(), newMember.getUserPw(), newMember.getUserRole());
            memberRepository.save(newMember);

            findById();
        }, () -> {
            fail("member 엔티티가 null입니다");
        });

    }

    @Test
    @DisplayName("update native SQL 테스트")
    public void update_nativeSql(){
        int result = memberRepository.updateById_nativeQuery(1L, "hong3");
        assertEquals(1, result);

        Optional<MemberEntity> member =
                memberRepository.findById(1L);
        assertEquals("hong3", member.get().getUserId() );
    }

    @Test
    @DisplayName("delete 테스트")
    public void delete() {
        Optional<MemberEntity> member = memberRepository.findById(1L);
        member.ifPresent(unwrapMember ->{
            memberRepository.delete(unwrapMember);
            System.out.println("삭제 성공");
        });

        Optional<MemberEntity> oldMember = memberRepository.findById(1L);
        assertEquals(false, oldMember.isPresent());
    }

    // member 테이블 안에 암호가 "1234"인 회원이 있는지 테스트 하시오.
    // findByUserPw
    // 23년도 3월에 가입한 회원의 수가 1인지 테스트하시오.
    // findByJoindate
    // "lee"라는 아이디로 회원가입하고자 할때, 아이디 중복인지 테스트하시오.
    // "tom"이라는 아이디의 회원정보를 수정하고, 잘 수정되었는지 테스트하시오.
    // 톰아저씨 -> 마이클, 암호 -> 3456
    // 쿼리 메소드 또는 Native SQL, JPQL 방법 중 하나를 사용하시오.

    @Test
    @DisplayName("암호 테스트")
    public void findByUserPw() {
//        List<MemberEntity> list = memberRepository.findByUserPw("1234");
//        assertEquals(3, list.size());

        Boolean b = memberRepository.existsByUserPw("1234");
        assertEquals(true, b);
    }

    @Test
    @DisplayName("joindate")
    public void findByJoindate() {
        int count = memberRepository.findByJoindate_nativeSQL(LocalDate.parse("2023-03-01"), LocalDate.parse("2023-03-31"));
        assertEquals(1, count);
    }

    @Test
    @DisplayName("중복체크")
    public void checkDuplicate() {
//        List<MemberEntity> list = memberRepository.findAll();
//        for (MemberEntity member : list) {
//            assertNotEquals("lee", member.getUserId());
//        }
        List<MemberEntity> list = memberRepository.findByUserId("lee");
        assertEquals(0, list.size());
//        org.assertj.core.api.Assertions.assertThat(list.size()).isLessThan(1);
    }

    @Test
    @DisplayName("회원정보 수정 테스트")
    public void updateMemberInfo() {
        int result = memberRepository.updateByUserId_nativeQuery("마이클", "3456", "tom");
        assertEquals(1, result);

        List<MemberEntity> tom = memberRepository.findByUserId("tom");
        assertEquals("마이클", tom.get(0).getUserName());
        assertEquals("3456", tom.get(0).getUserPw());

    }
}
