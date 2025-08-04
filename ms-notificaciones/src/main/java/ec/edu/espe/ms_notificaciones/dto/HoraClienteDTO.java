package ec.edu.espe.ms_notificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoraClienteDTO {
    // Atributos
    private String nombreNodo; // Nombre del nodo que envía la hora
    private long horaEnviada; // Hora enviada por el nodo
}
