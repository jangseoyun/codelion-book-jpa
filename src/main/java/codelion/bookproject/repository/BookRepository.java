package codelion.bookproject.repository;

import codelion.bookproject.domain.entity.Books;

import java.util.List;

public interface BookRepository {

    List<Books> getJoinList();
}
