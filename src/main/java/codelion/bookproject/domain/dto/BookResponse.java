package codelion.bookproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookResponse {
    //저자 이름 포함
    private Long id;
    private String bookName;
    private String author;
}
