package ec.edu.espe.sincronizacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoraServidorDTO {
    private long horaServidor; // Hora ajustada del servidor
    private Map<String, Long> diferencias; // Diferencias de tiempo por cliente
}