package org.example.consumeipgeolocation;
import org.h2.tools.Server;

public class H2ServerStarter {
    public static void main(String[] args) {
        try {
            // Iniciar el servidor H2 en el puerto 9093
            Server h2Server = Server.createTcpServer("-tcpAllowOthers", "-tcpPort", "9093", "-ifNotExists").start();
            Server webServer = Server.createWebServer("-webAllowOthers", "-webPort", "8082").start();

            if (h2Server.isRunning(true) && webServer.isRunning(true)) {
                System.out.println("Servidor H2 iniciado en el puerto 9093.");
                System.out.println("Consola web disponible en: http://localhost:8082/h2-console");
            }

            // Mantener el servidor corriendo
            System.out.println("Presiona Ctrl+C para detener el servidor.");
            while (true) {
                // Mantener el servidor H2 activo
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
