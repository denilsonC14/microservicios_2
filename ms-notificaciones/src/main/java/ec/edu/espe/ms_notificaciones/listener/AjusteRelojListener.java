package ec.edu.espe.ms_notificaciones.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AjusteRelojListener {

    @Value("${spring.application.name:ms-notificaciones}")
    private String nombreNodo;

    @RabbitListener(queues = "reloj.ajuste")
    public void recibirAjuste(String horaPromedioStr) {
        try {
            long horaPromedio = Long.parseLong(horaPromedioStr);
            long horaLocal = Instant.now().toEpochMilli();
            long diferencia = horaPromedio - horaLocal;

            System.out.println("🕓 [" + nombreNodo + "] Hora local: " + Instant.ofEpochMilli(horaLocal)
                    + " | Hora sincronizada: " + Instant.ofEpochMilli(horaPromedio)
                    + " | Diferencia: " + diferencia + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
