package ec.edu.espe.ms_notificaciones.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue notificacionesQueue() {
        return QueueBuilder.durable("notificaciones_cola")
                .build();
    }
    @Bean
    public Queue rejorQueue() {
        return QueueBuilder.durable("reloj.solicitud").build();
    }
    @Bean
    public Queue ajusteRelojQueue() {
        return QueueBuilder.durable("reloj.ajuste").build();
    }
}
