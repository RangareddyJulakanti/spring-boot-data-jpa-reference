package com.ranga.service.impl.ride;

import com.ranga.app.App;
import config.DataConfig;
import config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * Created by RANGA on 2/26/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class, TestConfig.class})
@TestExecutionListeners(listeners = {
        DataConfig.class,
        OwnerTemplateTest.class
})
public class OwnerTemplateTest extends AbstractTestExecutionListener {

    @Test
    public void finish() throws Exception {

    }

    @Test
    public void changeDirection() throws Exception {

    }

    @Test
    public void invoice() throws Exception {

    }

}