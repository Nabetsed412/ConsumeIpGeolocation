package org.example.consumeipgeolocation.manager;
import org.h2.tools.Server;
import org.springframework.stereotype.Component;
import java.sql.SQLException;

@Component
public class H2ServerManager {

    private Server h2Server;
    private Server webServer;

    // Método para iniciar el servidor H2 en modo TCP y la consola web
    public void startH2Server() {
        try {
            // Inicia el servidor H2 en el puerto 9093 si no está ya corriendo
            if (h2Server == null || !h2Server.isRunning(false)) {
                h2Server = Server.createTcpServer("-tcpAllowOthers", "-tcpPort", "9093", "-ifNotExists").start();
                webServer = Server.createWebServer("-webAllowOthers", "-webPort", "8082").start();

                System.out.println("Servidor H2 iniciado en el puerto 9093.");
                System.out.println("Consola web disponible en: http://localhost:8082/h2-console");
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar el servidor H2.");
            e.printStackTrace();
        }
    }

    // Método para detener el servidor H2 (si lo necesitas en otro momento)
    public void stopH2Server() {
        if (h2Server != null) {
            h2Server.stop();
            System.out.println("Servidor H2 detenido.");
        }
        if (webServer != null) {
            webServer.stop();
            System.out.println("Consola H2 detenida.");
        }
    }

    // Verificar si el servidor está en ejecución
    public boolean isH2Running() {
        return h2Server != null && h2Server.isRunning(false);
    }
}
