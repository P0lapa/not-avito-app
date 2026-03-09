package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
    @Value("${some.dude.phrase}")
    private String testPhrase;
    public void metod(){
        System.out.println(testPhrase);
    }
}
