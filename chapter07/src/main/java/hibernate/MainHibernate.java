package hibernate;

import hibernate.configs.HibernateConfig;
import hibernate.dao.SingerDao;
import hibernate.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class MainHibernate {

    private static final Logger logger = LoggerFactory.getLogger(MainHibernate.class);

    public static void main(String[] args) {

        GenericApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SingerDao singerDao = context.getBean(SingerDao.class);
        listSingers(singerDao.findAll());

        context.close();
    }

    private static void listSingers(List<Singer> singers) {
        logger.info(" ------ 가수 목록: ");
        singers.forEach(singer -> logger.info(singer.toString()));
    }
}
