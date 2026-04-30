package com.iweb.publisher;

import com.iweb.order.OrderMainApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OrderMainApplication.class)
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

   /* @Test
    void testSendMessage(){
        String exchangeName = "blog.topic";
        String routingKey = "weather.today";
        String weatherMessage = "今天天气挺不错，我的心情的挺好的";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, weatherMessage);
    }*/
}
