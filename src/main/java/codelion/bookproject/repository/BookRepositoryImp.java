package codelion.bookproject.repository;

import codelion.bookproject.domain.entity.Books;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BookRepositoryImp implements BookRepository {
    private final EntityManager em;

    /*------ author + book join -------*/
    @Override
    public List<Books> getJoinList() {
        String query = "select b from Books b, Author a where b.author.id = a.id";
        List<Books> result = em.createQuery(query, Books.class)
                .getResultList();

        log.info("result: {}", result);
        return result;
    }

    /*------ publisher + author + book join -------*/
    @Override
    public List<Books> getPublisherAndAuthorJoin() {
        String query = "select b from Books b, Author a, Publisher p " +
                        "where b.author.id = a.id " +
                        "and b.publisher.id = p.id";
        List<Books> result = em.createQuery(query, Books.class)
                .getResultList();

        return result;
    }

}
