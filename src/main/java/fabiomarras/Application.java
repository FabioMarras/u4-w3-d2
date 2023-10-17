package fabiomarras;

import fabiomarras.entities.Evento;
import fabiomarras.entities.EventoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
        EventoDAO sd = new EventoDAO(em);

        // SAVE per salvare un nuovo evento
        Evento festaFabio = new Evento("festa", "12/10/10", "il miglior party", "Anni90", 50);
        sd.save(festaFabio);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
        em.close();
        emf.close();
        }
    }
}
