package com.nevermind.bu.service;

import com.nevermind.bu.config.AppConfigTest;
import com.nevermind.bu.entity.Author;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;
import com.nevermind.bu.service.interfaces.BookService;
import org.dom4j.tree.BackedList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
public class BookServiceImplTest {

    @Mock
    @Autowired
    BookService bookService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById() throws Exception {
        Book book = new Book();
        book.setName("Test Book");
        book.setGenre("Some genre");
        book.setPages(55);
        book.setId(22);
        book.setAuthor(new Author("test Author", new Literature("test Literature")));

        when(bookService.getById(anyInt())).thenReturn(book);

        Book byId = bookService.getById(22);
        assertEquals(22, byId.getId());

        verify(bookService,atLeastOnce()).getById(anyInt());
    }

    @Test
    public void getByName() throws Exception {
        Book book = new Book();
        book.setName("HelloBook");
        book.setGenre("Some genre");
        book.setPages(55);
        book.setAuthor(new Author("test Author", new Literature("test Literature")));
        when(bookService.getByName(anyString())).thenReturn(book);

        Book byName = bookService.getByName("HelloBook");
        assertEquals("HelloBook", byName.getName());

        verify(bookService).getByName("HelloBook");
    }

    @Test
    public void getByGenre() throws Exception {
        List<Book> oneGenreBooks = new ArrayList<>();

        Book book = new Book();
        book.setName("HelloBook");
        book.setGenre("Some genre");
        book.setPages(55);
        book.setAuthor(new Author("test Author", new Literature("test Literature")));
        oneGenreBooks.add(book);

        Book book2 = new Book();
        book.setName("HelloBook2");
        book.setGenre("Some genre");
        book.setPages(55);
        book.setAuthor(new Author("test Author2", new Literature("test Literature2")));
        oneGenreBooks.add(book2);

        when(bookService.getByGenre(anyString())).thenReturn(oneGenreBooks);

        List<Book> byGenre = bookService.getByGenre("Some genre");
        assertEquals("Some genre", byGenre.get(0).getGenre());

        verify(bookService).getByGenre("Some genre");
    }

    @Test
    public void getByAuthor() throws Exception {
        List<Book> oneAuthorBooks = new ArrayList<>();

        Book book = new Book();
        book.setName("HelloBook");
        book.setGenre("Some genre");
        book.setPages(55);
        book.setAuthor(new Author("test Author", new Literature("test Literature")));
        oneAuthorBooks.add(book);

        Book book2 = new Book();
        book.setName("HelloBook2");
        book.setGenre("Some genre");
        book.setPages(55);
        book.setAuthor(new Author("test Author", new Literature("test Literature2")));
        oneAuthorBooks.add(book2);

        when(bookService.getByAuthor(anyString())).thenReturn(oneAuthorBooks);
        List<Book> byAuthor = bookService.getByAuthor("test Author");
        assertEquals("test Author", byAuthor.get(0).getAuthor().getName());
    }

    @Test
    public void getByPages() throws Exception {
        int firstpage = 20;
        int lastpage = 60;

        List<Book> onePagesRangeBooks = new ArrayList<>();
        Book book = new Book();
        book.setName("HelloBook");
        book.setGenre("Some genre");
        book.setPages(22);
        book.setAuthor(new Author("test Author", new Literature("test Literature")));
        onePagesRangeBooks.add(book);

        Book book2 = new Book();
        book.setName("HelloBook2");
        book.setGenre("Some genre");
        book.setPages(55);
        book.setAuthor(new Author("test Author", new Literature("test Literature2")));
        onePagesRangeBooks.add(book2);

        when(bookService.getByPages(firstpage, lastpage)).thenReturn(onePagesRangeBooks);
        List<Book> byPages = bookService.getByPages(firstpage, lastpage);
        assertEquals(55, byPages.get(0).getPages());
    }

    @Test
    public void getAll() throws Exception {
        List<Book> all = new ArrayList<>();
        all.add(new Book("First book", new Author("some author", new Literature("some literature")),
                22, "some genre"));
        all.add(new Book("Second book", new Author("some author", new Literature("some literature")),
                22, "some genre"));
        when(bookService.getAll()).thenReturn(all);

        List<Book> result = bookService.getAll();
        verify(bookService).getAll();
    }

    @Test
    public void save() throws Exception {
        Book book = new Book();
        book.setName("HelloBook");
        book.setGenre("Some genre");
        book.setPages(55);
        book.setAuthor(new Author("test Author", new Literature("test Literature")));
        bookService.save(book);
        verify(bookService).save(book);
    }

    @Test
    public void delete() throws Exception {
        bookService.delete(25);
        verify(bookService).delete(25);
    }

    @Test
    public void update() throws Exception {
        Book book = new Book();
        when(bookService.getById(anyInt())).thenReturn(book);
        book = bookService.getById(256);
        book.setName("new book name");

        bookService.update(book);
        verify(bookService).update(book);
    }

    @Test
    public void testServiceCalledOnlyOnce() {
        List all = new ArrayList();

        when(bookService.getAll()).thenReturn(all);

        bookService.getAll();

        verify(bookService, times(1)).getAll();
        verify(bookService, atMost(1)).getAll();
        verify(bookService, atLeast(1)).getAll();
    }
}
