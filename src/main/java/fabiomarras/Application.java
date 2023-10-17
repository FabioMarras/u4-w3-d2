package fabiomarras;

import fabiomarras.entities.Evento;
import fabiomarras.entities.EventoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
        EventoDAO sd = new EventoDAO(em);

        // SAVE per salvare un nuovo evento
        /*Evento festaFabio = new Evento("festa", "12/10/10", "il miglior party", "Anni90", 50);
        sd.save(festaFabio);*/

        //FIND per cercare tramite id
        Evento findById = sd.findById(UUID.fromString("77d43ada-af37-4190-80e1-4de7f99a0209"));
        if (findById != null) {
            System.out.println(findById);
        } else {
            System.out.println("non ho trovato niente");
        }

        //DELETE per carncellare tramite id
        //sd.findByIdAndDelete(UUID.fromString("6834b710-1165-486f-9bd5-6b51b7b650d3"));

        //REFRESH per ricarica il contenuto
        Evento refresh1 = sd.findById(UUID.fromString("77d43ada-af37-4190-80e1-4de7f99a0209"));
        if (refresh1 != null) {
            refresh1.setTitolo("Nuovo Titolo dell'evento");
            System.out.println(refresh1);
            em.refresh(refresh1);
            System.out.println(refresh1);
        }

        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
        em.close();
        emf.close();
        }
    }
}
