package com.mmn.mail.impl;

import com.google.gson.Gson;
import com.mmn.mail.api.dto.Email;
import com.mmn.mail.impl.config.MailConfiguration;
import lombok.val;
import net.kemitix.wiser.assertions.WiserAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.subethamail.wiser.Wiser;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@Disabled
class MailServiceApplicationTests {

    private static Wiser wiser;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setUp() throws Exception {
        wiser = new Wiser();
        wiser.start();
    }

    @AfterAll
    public static void tearDown() throws Exception {
        wiser.stop();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void send() throws Exception {
        // act
        final Email email = Email.builder()
                .to("jhordeym@gmail.com")
                .subject("test email")
                .text("Lorem ipsum")
                .build();

        final Gson gson = new Gson();
        final String json = gson.toJson(email);

        final val result = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/send")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        // assert
        /*
        WiserAssertions.assertReceivedMessage(wiser)
                .from("noreply@travined.com")
                .to("jhordeym@gmail.com")
                .withSubject("test email")
                .withContent("Lorem ipsum");
         */
    }

}
