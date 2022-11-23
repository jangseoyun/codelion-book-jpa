package codelion.bookproject.controller;

import codelion.bookproject.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    /*-------- 책 저자 포함 리스트 -----------*/
    @GetMapping("")
    public ResponseEntity getBookList() {
        log.info("책 목록 요청 controller");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.findBookList());
    }

    /*-------- 책 저자 + 출판사 포함 리스트 -----------*/
    @GetMapping("/all")
    public ResponseEntity getAllBookList() {
        log.info("책 출판사, 작가, 책  목록 요청 controller");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.findBookAllList());
    }

}
