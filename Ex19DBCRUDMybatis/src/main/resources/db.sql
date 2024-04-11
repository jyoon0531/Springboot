USE mydb;

DESC MEMBER;

-- 회원가입 테이블 만들기
CREATE TABLE member (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        user_id VARCHAR(255) NOT NULL,
                        user_pw VARCHAR(255) NOT NULL,
                        user_name VARCHAR(255),
                        user_role VARCHAR(255) DEFAULT 'ROLE_USER',
                        join_date DATE DEFAULT (CURRENT_DATE)
);
-- DATE DEFALUT NOW() 버전호환성(5.X, 8.X 이슈)
-- 데이터 추가하기
INSERT INTO MEMBER VALUES (0, 'hong', '1234', '홍길동', 'ROLE_USER', '2024-01-01');
INSERT INTO MEMBER VALUES (0, 'tom', '1234', '톰아저씨', 'ROLE_USER', '2024-02-01');
INSERT INTO MEMBER VALUES (0, 'admin', '1234', '관리자', 'ROLE_ADMIN', '2024-03-01');

SELECT * FROM MEMBER;