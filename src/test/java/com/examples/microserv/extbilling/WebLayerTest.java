package com.examples.microserv.extbilling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest()
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class WebLayerTest {
       
    @Test
    public void joe() {
    	assertEquals(true, true);
    }
}
