package com.annamaple.web;

import com.annamaple.dto.AppointExecution;
import com.annamaple.dto.Result;
import com.annamaple.entity.Book;
import com.annamaple.enums.AppointStateEnum;
import com.annamaple.exception.NoNumberException;
import com.annamaple.exception.RepeatAppointException;
import com.annamaple.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
// url:/模块/资源/{id}/细分 /seckill/list
@RequestMapping("/book") 
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelAndView model) {
        List<Book> list = bookService.getList();
        model.addObject("list", list);
        // list.jsp + model = ModelAndView
        model.addObject("msg", "annamaple");
        return "list";// WEB-INF/jsp/"list".jsp
    }
    
    @ResponseBody
    @RequestMapping(value = "/list-json")
    public Result<List<Book>> listWithJson() {
        return new Result<>(true, bookService.getList());
    }
    

    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("bookId") Long bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    // ajax json
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
        if (studentId == null || studentId.equals("")) {
            return new Result<>(false, "学号不能为空");
        }
        AppointExecution execution = null;
        try {
            execution = bookService.appoint(bookId, studentId);
        } catch (NoNumberException e1) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<>(true, execution);
    }

}
