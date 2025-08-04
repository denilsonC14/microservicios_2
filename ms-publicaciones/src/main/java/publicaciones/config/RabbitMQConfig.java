package publicaciones.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue relojQueue() {
        return QueueBuilder.durable("reloj.solicitud").build();
    }
    @Bean
    public Queue ajusteRelojQueue() {
        return QueueBuilder.durable("reloj.ajuste").build();
    }
}
