package publicaciones.Services;
import org.springframework.amqp.core.AmqpTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publicaciones.dto.HoraClienteDTO;

import java.time.Instant;

@Service
public class RelojProducer {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private ObjectMapper Mapper;

    private static  final String nombreNodo = "ms-publicaciones";

    public void enviarHora() {
        try {
            HoraClienteDTO dto = new HoraClienteDTO(nombreNodo, Instant.now().toEpochMilli());
            String json = Mapper.writeValueAsString(dto);
            template.convertAndSend("reloj.solicitud", json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
