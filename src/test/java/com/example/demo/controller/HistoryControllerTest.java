package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.util.TimeFactory;

@SpringBootTest
@AutoConfigureMockMvc
public class HistoryControllerTest {

    @Autowired private MockMvc mockMvc;

    private final Date startDate = Date.from(Instant.parse("2022-01-03T00:00:00.00Z"));
    
    @MockBean
    private TimeFactory clock;

    @Test
	public void testGetMonthWithinHalfYearAsStringYYYYMM() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		HistoryController hc = new HistoryController();
        List<String> expected = new ArrayList<>(Arrays.asList("2023/01", "2022/12", "2022/11", "2022/10", "2022/09", "2022/08"));
        Collections.reverse(expected);

        Method method = HistoryController.class.getDeclaredMethod("getMonthWithinHalfYearAsStringYYYYMM");
        method.setAccessible(true);

        List<String> actual = (List<String>) method.invoke(hc);

        System.out.println(actual.toString());
        assertEquals(actual,expected);
	}



    // public static class MockCalendar {
	// 	private static Calendar instance;
		
	// 	public static void setInstance(Calendar desired) {
	// 		instance = (Calendar)desired.clone();
	// 	}
		
	// 	@Mock
	// 	public static Calendar getInstance() {
	// 		return (Calendar)instance.clone();
	// 	}
	// }
}
