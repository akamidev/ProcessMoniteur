import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessFiltering;
import oshi.software.os.OperatingSystem.ProcessSorting;
import java.util.List;

public class ProcessMonitor {

    private static final long MEMORY_THRESHOLD = 100 * 1024 * 1024; // 100 MB

    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem os = systemInfo.getOperatingSystem();

        // Récupère les processus
        List<OSProcess> processes = os.getProcesses(ProcessFiltering.ALL_PROCESSES, ProcessSorting.RSS_DESC, 10);

        // Vérifie chaque processus
        for (OSProcess process : processes) {
            long memoryUsed = process.getResidentSetSize();
            System.out.printf("Processus: %s, PID: %d, Mémoire utilisée: %d MB%n",
                    process.getName(), process.getProcessID(), memoryUsed / (1024 * 1024));

            // Alerte si la mémoire utilisée dépasse le seuil
            if (memoryUsed > MEMORY_THRESHOLD) {
                System.out.printf("Alerte: Le processus %s (PID %d) utilise plus de %d MB de mémoire.%n",
                        process.getName(), process.getProcessID(), MEMORY_THRESHOLD / (1024 * 1024));
                // Appel à la fonction d'envoi d'email
                EmailAlert.sendEmail(process.getName(), memoryUsed);
            }
        }
    }
}
