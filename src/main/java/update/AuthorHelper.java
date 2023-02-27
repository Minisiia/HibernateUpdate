package update;


import org.hibernate.Criteria;
import update.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class AuthorHelper {

    private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );
    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Author.class);
        List<Author> list = criteria.list();
        session.close();
        return list;
    }

    public void updateNameWhereLastNameMoreThen7(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Author> authorList = getAll();
        for (Author tempAuthor : authorList) {
            if (tempAuthor.getLastName().length() > 7)
            {
                tempAuthor.setName("1");
                session.update(tempAuthor);
            }
        }
        session.getTransaction().commit();
        session.close();
    }

}
