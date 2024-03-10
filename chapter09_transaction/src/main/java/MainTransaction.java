import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.jta.JtaTransactionManager;

public class MainTransaction {

    public static void main(String[] args) {

        // 글로벌 트랜잭션 == 분산 트랜잭션
        // 1. 컨테이너가 트랜잭션 관리.
        // 2. 여러 트랜잭션 자원에 걸쳐 있을 수 있다.
        // JTA, JTS
        // 트랜잭션 매니저는 각 분산 자원에 설치된 리소스 매니저를 활용해 다중 트랜잭션 리소스에 접근
        // 각 리소스 매니저와 통신은 XA 프로토콜을 활용
        // 2단계 커밋 매커니즘 활용하여 모든 백엔드 데이터 소스가 모두 업데이트 혹은 모두 롤백되도록 보장
        // JEE 사양에 포함

        // 로컬 트랜잭션
        // 1. 단일 트랜잭션 자원에 한정 (JDBC 연결 등)

        // 각각 JDBC, ORM, JTA 지원
//        PlatformTransactionManager transactionManager01 = new DataSourceTransactionManager();
//        PlatformTransactionManager transactionManager02 = new HibernateTransactionManager();
//        PlatformTransactionManager transactionManager03 = new JtaTransactionManager();

        // 활용
        // TransactionStatus abcd = platformTransactionManager.getTransaction(new TransactionDefinition definition);
        //
    }
}
