package com.nevermind.bu.service;

import com.nevermind.bu.config.AppConfigTest;
import com.nevermind.bu.entity.Author;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;
import com.nevermind.bu.service.interfaces.AuthorService;
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
public class AuthorServiceImplTest {

    @Mock
    @Autowired
    AuthorService authorService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById() throws Exception {
        Author author = new Author();
        author.setName("Name");
        author.setLiterature(new Literature("some literature"));

        when(authorService.getById(anyInt())).thenReturn(author);

        Author byId = authorService.getById(555);
        assertEquals("Name", byId.getName());

        verify(authorService).getById(555);
    }

    @Test
    public void getByName() throws Exception {
        Author author = new Author();
        author.setName("Name");
        author.setLiterature(new Literature("some literature"));

        when(authorService.getByName(anyString())).thenReturn(author);

        Author byName = authorService.getByName("Name");
        assertEquals("Name", byName.getName());

        verify(authorService).getByName("Name");
    }

    @Test
    public void getAll() throws Exception {
        List<Author> all = new ArrayList<>();
        all.add(new Author("Name", new Literature("some Literature")));
        all.add(new Author("Name2", new Literature("some Literature2")));

        when(authorService.getAll()).thenReturn(all);

        List<Author> result = authorService.getAll();
        verify(authorService).getAll();
    }

    @Test
    public void save() throws Exception {
        Author author = new Author();
        author.setName("Name");
        author.setLiterature(new Literature("some literature"));
        authorService.save(author);
        verify(authorService).save(author);
    }

    @Test
    public void delete() throws Exception {
        authorService.delete(25);
        verify(authorService).delete(25);
    }

    @Test
    public void update() throws Exception {
        Author author = new Author();
        when(authorService.getById(anyInt())).thenReturn(author);
        author = authorService.getById(22);
        author.setName("Name");
        author.setLiterature(new Literature("some literature"));

        authorService.update(author);
        verify(authorService).update(author);

    }

    @Test
    public void testServiceCalledOnlyOnce() {
        List all = new ArrayList();

        when(authorService.getAll()).thenReturn(all);

        authorService.getAll();

        verify(authorService, times(1)).getAll();
        verify(authorService, atMost(1)).getAll();
        verify(authorService, atLeast(1)).getAll();
    }
}
