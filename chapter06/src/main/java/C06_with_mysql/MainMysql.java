package C06_with_mysql;

import C06_with_mysql.dao.PlainSingerDao;
import C06_with_mysql.dao.SingerDao;
import C06_with_mysql.entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class MainMysql {

    private static SingerDao singerDao = new PlainSingerDao();
    private static Logger logger = LoggerFactory.getLogger(MainMysql.class);

    public static void main(String[] args) {

        // TEST
        logger.info("초기 가수 목록");
        selectAllSingers();
        logger.info("------------");

        logger.info("가수 등록");
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(Date.valueOf(LocalDate.of(1991, Month.DECEMBER, 26)));
        singerDao.insert(singer);
        logger.info("------------");

        logger.info("신규 가수 등록 후 가수 목록 확인");
        selectAllSingers();
        logger.info("------------");

        logger.info("신규등록된 가수 삭제 후 가수 목록 확인");
        singerDao.delete(singer.getId());
        selectAllSingers();
        logger.info("------------");

    }

    private static void selectAllSingers() {
        List<Singer> singers = singerDao.findAll();

        for (Singer singer : singers) {
            logger.info(singer.toString());
        }
    }
}
