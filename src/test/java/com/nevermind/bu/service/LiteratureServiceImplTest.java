package com.nevermind.bu.service;

import com.nevermind.bu.config.AppConfigTest;
import com.nevermind.bu.dao.LiteratureDao;
import com.nevermind.bu.entity.Literature;
import com.nevermind.bu.service.interfaces.LiteratureService;
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
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
public class LiteratureServiceImplTest {

    @Mock
    @Autowired
    LiteratureService literatureService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById() throws Exception {
        Literature literature = new Literature();
        literature.setName("testLiterature");
        when(literatureService.getById(anyInt())).thenReturn(literature);

        Literature byId = literatureService.getById(5);
        assertEquals("testLiterature", byId.getName());

        verify(literatureService).getById(5);
    }

    @Test
    public void getByName() throws Exception {
        Literature literature = new Literature();
        literature.setName("HelloLiterature");
        when(literatureService.getByName(anyString())).thenReturn(literature);

        Literature byName = literatureService.getByName("HelloLiterature");
        assertEquals("HelloLiterature", byName.getName());

        verify(literatureService).getByName("HelloLiterature");
    }

    @Test
    public void getAll() throws Exception {
        List<Literature> all = new ArrayList<>();
        all.add(new Literature("litTest1"));
        all.add(new Literature("litTest2"));
        when(literatureService.getAll()).thenReturn(all);

        List<Literature> result = literatureService.getAll();
        verify(literatureService).getAll();
    }

    @Test
    public void save() throws Exception {
        Literature literature = new Literature();
        literature.setName("New Literature");
        literatureService.save(literature);
        verify(literatureService).save(literature);
    }

    @Test
    public void delete() throws Exception {
        literatureService.delete(5);
        verify(literatureService).delete(5);
    }

    @Test
    public void update() throws Exception {
        Literature literature = new Literature();
        when(literatureService.getById(anyInt())).thenReturn(literature);
        literature = literatureService.getById(3);
        literature.setName("New Name");

        literatureService.update(literature);
        verify(literatureService).update(literature);
    }

    @Test
    public void testServiceCalledOnlyOnce() {
        List all = new ArrayList();

        when(literatureService.getAll()).thenReturn(all);

        literatureService.getAll();

        verify(literatureService,times(1)).getAll();
        verify(literatureService,atMost(1)).getAll();
        verify(literatureService,atLeast(1)).getAll();
    }
}
