package update;

import update.entity.Author;
import org.jboss.logging.Logger;

import java.util.List;

/**
 * Обновить поле name для всех записей, у которых длина значения поля last_name больше 7 В поле name записать значение «1»
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        System.out.println((char) 27 + "[34m" + "Authors list:" + (char) 27 + "[38m");
        List<Author> authorList = ah.getAll();
        for (Author author : authorList)
            LOG.info(author.getName() + " " + author.getLastName());
        ah.updateNameWhereLastNameMoreThen7();
        authorList = ah.getAll();
        System.out.println((char) 27 + "[34m" + "Update authors list:" + (char) 27 + "[38m");
        for (Author author : authorList)
            LOG.info(author.getName() + " " + author.getLastName());
    }
}
