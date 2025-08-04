package ec.edu.espe.ms_notificaciones.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import ec.edu.espe.ms_notificaciones.services.RelojProducer;

@Configuration
@EnableScheduling

public class SchedulingConfig {

    @Autowired
    private RelojProducer relojProducer;

    @Scheduled(fixedRate = 10000) // Ejecuta cada 10 segundos
    public void reportarHora() {
        try {
            relojProducer.enviarHora();
            System.out.println("Nodo ms-notificaciones: Hora enviada correctamente.");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
