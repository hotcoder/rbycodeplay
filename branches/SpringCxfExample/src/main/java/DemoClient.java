import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.ramesh.cxf.sei.BookService;
import com.ramesh.cxf.vo.Book;

public class DemoClient {
	public static void main(String[] args) {
		String serviceUrl = "http://localhost:8080/SpringCxfExample-0.0.1-SNAPSHOT/bookWebService";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(BookService.class);
		factory.setAddress(serviceUrl);
		BookService bookService = (BookService) factory.create();

		// insert book
		Book bookVO = new Book();
		bookVO.setId(1);
		bookVO.setName("ramesh");

		Integer result = bookService.storeBook(bookVO);

		System.out.println("result : " + result);

		bookVO = bookService.getBook(1);

		System.out.println("book name : " + bookVO.getName());
		System.out.println("book author : " + bookVO.getId());

	}
}