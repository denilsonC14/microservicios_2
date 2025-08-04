package ec.edu.espe.sincronizacion.services;

import ec.edu.espe.sincronizacion.dto.HoraClienteDTO;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;




@Service
public class SincronizacionService {

    private final Map<String, Long> tiempoClientes = new ConcurrentHashMap<>();

    private static int INTERVALO_SEGUNDOS = 10;

    public void registrarTiempoCliente(HoraClienteDTO dto){
        tiempoClientes.put(dto.getNombreNodo(), Long.valueOf(dto.getHoraEnviada()));
    }

    public void sincronizarRelojes(){
        if(tiempoClientes.size() >= 2) {
            long shora = Instant.now().toEpochMilli();
            long promedio = (shora + tiempoClientes.values().stream().mapToLong(Long::longValue).sum()) / (tiempoClientes.size() + 1);
            System.out.println("🕐 Sincronización calculada:");
            System.out.println("  - Hora del servidor: " + Instant.ofEpochMilli(shora));
            System.out.println("  - Tiempo Promedio: " + Instant.ofEpochMilli(promedio));
            System.out.println("  - Clientes participantes: " + tiempoClientes.size());
            tiempoClientes.clear();// limpiar para evitar duplicados
            enviarAjusteReloj(promedio);
        }
    }
    @Autowired
    private AmqpTemplate template;
    public void enviarAjusteReloj(Long horaServidor){
        //fomato de horaServidor: 2023-10-01T12:00:00Z
        String mensaje = horaServidor.toString();
        template.convertAndSend("reloj.ajuste", mensaje);
        System.out.println("✅ Ajustando relojes a: " + Instant.ofEpochMilli(horaServidor));
    }
}

//