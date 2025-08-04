package publicaciones.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import publicaciones.Services.RelojProducer;

@Configuration
@EnableScheduling

public class SchedulingConfig {

    @Autowired
    private RelojProducer relojProducer;

    @Scheduled(fixedRate = 10000) // Ejecuta cada 10 segundos
    public void reportarHora() {
        try {
            relojProducer.enviarHora();
            System.out.println("Nodo ms-publicaciones: Hora enviada correctamente.");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
