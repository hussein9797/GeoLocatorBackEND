package Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class GeneralListResponse {

    private int code;
    private String message;
    private Long total;
    private Object data;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;


    public ResponseEntity<GeneralListResponse> response(Page page_list) {
        this.code = 1;
        this.message = "Operation Success";
        this.data = page_list.getContent();
        this.pageNumber = page_list.getNumber();
        this.pageSize = page_list.getSize();
        this.totalPages = page_list.getTotalPages();

        this.total = page_list.getTotalElements();

        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }

    public ResponseEntity<GeneralListResponse> response(Page page_list,Object data) {
        this.code = 1;
        this.message = "Operation Success";
        this.total = page_list.getTotalElements();
        this.pageNumber = page_list.getNumber();
        this.pageSize = page_list.getSize();
        this.totalPages = page_list.getTotalPages();

        this.data = data;


        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }


    public ResponseEntity<GeneralListResponse> response(Long total,Integer page_number,Integer page_size, Integer total_pages,Object data) {
        this.code = 1;
        this.message = "Operation Success";
        this.total = total;
        this.pageNumber = page_number;
        this.pageSize = page_size;
        this.totalPages = total_pages;

        this.data = data;


        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }


    public ResponseEntity<GeneralListResponse> response(Page page_list,String action) {
        this.code = 1;
        this.message = "Operation Success";
        this.data = page_list.getContent();
        this.pageNumber = page_list.getNumber();
        this.pageSize = page_list.getSize();
        this.totalPages = page_list.getTotalPages();
        this.total = page_list.getTotalElements();

        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }

    public ResponseEntity<GeneralListResponse> response(Page page_list, Object data,String action) {
        this.code = 1;
        this.message = "Operation Success";
        this.total = page_list.getTotalElements();
        this.pageNumber = page_list.getNumber();
        this.pageSize = page_list.getSize();
        this.totalPages = page_list.getTotalPages();
        this.data = data;


        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }


    public ResponseEntity<GeneralListResponse> response(Integer code,String message,Integer total,Integer totalPages,Integer pageNumber,Integer pageSize, Object data) {
        this.code = code;
        this.message = message;
        this.total = total.longValue();
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.data = data;
        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }

    public ResponseEntity<GeneralListResponse> response(Integer total,Integer totalPages,Integer pageNumber,Integer pageSize, Object data,String action) {
        this.code = 1;
        this.message = "Operation Success";
        this.total = total.longValue();
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.data = data;


        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }


    public ResponseEntity<GeneralListResponse> response(Integer total,Integer totalPages,Integer pageNumber,Integer pageSize, Object data, HttpServletRequest httpServletRequest) {
        this.code = 1;
        this.message = "Operation Success";
        this.total = total.longValue();
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.data = data;


        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }

    public ResponseEntity<GeneralListResponse> response(Page page_list, Object data, HttpServletRequest httpServletRequest) {
        this.code = 1;
        this.message = "Operation Success";
        this.total = page_list.getTotalElements();
        this.pageNumber = page_list.getNumber();
        this.pageSize = page_list.getSize();
        this.totalPages = page_list.getTotalPages();
        this.data = data;

        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }


    public ResponseEntity<GeneralListResponse> response(Long total, Integer page_number, Integer page_size, Integer total_pages, Object data,String action) {
        this.code = 1;
        this.message = "Operation Success";
        this.total = total;
        this.pageNumber = page_number;
        this.pageSize = page_size;
        this.totalPages = total_pages;
        this.data = data;


        return new ResponseEntity<GeneralListResponse>(this,HttpStatus.OK);
    }
}
