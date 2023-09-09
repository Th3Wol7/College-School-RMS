package factories;

import model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*The purpose of this class is class to define a session factory builder class
for the Hibernate ORM framework that manages the database sessions.*/
//NTS: Completed
public class SessionFactoryBuilder {
    private static final Logger logger = LogManager.getLogger(DBConnectorFactory.class);
    private static final Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                configuration.configure("xml/hibernate.cfg.xml")
                        .addAnnotatedClass(Address.class)
                        .addAnnotatedClass(Course.class)
                        .addAnnotatedClass(Programme.class)
                        .addAnnotatedClass(Staff.class)
                        .addAnnotatedClass(Student.class)
                        .addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();
            }
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        try {
            if (getSessionFactory() != null) {
                getSessionFactory().close();
            }
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
