package peaksoft.bookapi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookSaveRequest {

    private String name;
    private String author;
    private int price;


}
