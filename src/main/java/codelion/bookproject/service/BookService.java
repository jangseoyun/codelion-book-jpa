package codelion.bookproject.service;

import codelion.bookproject.domain.dto.BookFactory;
import codelion.bookproject.domain.dto.BookResponse;
import codelion.bookproject.domain.entity.Books;
import codelion.bookproject.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    /*-------- 책 저자 포함 리스트 -----------*/
    public List<BookResponse> findBookList() {
        List<Books> joinList = bookRepository.getJoinList();
        log.info("joinList service: {}", joinList);
        return joinList.stream()
                .map(books -> BookFactory.toBookResponse(books))
                .collect(Collectors.toList());
    }

    /*-------- 책 저자 + 출판사 포함 리스트 -----------*/
    public List<BookResponse> findBookAllList() {
        List<Books> publisherAndAuthorJoin = bookRepository.getPublisherAndAuthorJoin();
        log.info("publisherAndAuthorJoin service: {}", publisherAndAuthorJoin);
        return publisherAndAuthorJoin.stream()
                .map(books -> BookFactory.toAllBookResponse(books))
                .collect(Collectors.toList());
    }

}
