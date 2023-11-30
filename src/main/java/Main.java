import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Componente;
import model.Mesa;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("1: Inserir el registre corresponent al component José Manuel Castilla Gil amb DNI 31222333, de Jimena, president(“PR”) de la taula A del col·legi 1.\n" +
                "2: Modificar el registre corresponent al component Cristóbal Quirós Sánchez de Medina indicant que va néixer 1980-10-22.\n" +
                "3: Eliminar tots els registres de la taula component que no estiguin a cap mesa.\n" +
                "4: Consultar els noms i el càrrec de tots els components indicant col·legi i taula, ordenats per col·legi, taula i càrrec.\n" +
                "5: Consulteu el nom i l'edat del component de menor edat.\n" +
                "6: Consulteu els noms dels components que no hagin nascut l’any 1980.\n" +
                "7: Consulteu el dni i el nom dels 3 primers components que siguin presidents.\n" +
                "8: Consulteu el nom dels components que hagin nascut a l'estiu, ordenats per dni.\n" +
                "9: Consultar el total de vots obtingut pel partit el líder del qual és Pascual Collado.\n" +
                "10: Consulteu el nom i la data de naixement (de la forma dia/mes/any) dels components que van néixer després de 1990 i siguin vocals.\n" +
                "11: Consultar els col·legis i el nombre de taules que el componen, ordenats per adreça.\n" +
                "12: Indicar el partit i el líder del partit del qual tingui més vots totals.\n" +
                "13: Extreure les dades d'un dels components elegits a l'atzar de la manera que es mostra a l'exemple: “José Manuel Castilla Gil és President i va néixer 1963-06-17”.\n");
        System.out.println("Que vols fer? ");
        int option = scan.nextInt();

        if (option == 1) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            Componente JoseManuel = new Componente();
            JoseManuel.setDni(" 31222337");
            JoseManuel.setNombre("José Manuel Castilla Gil");
            Mesa mesaJose = new Mesa();
            mesaJose.setColegioIdcolegio(1);
            mesaJose.setLetra("a");
            mesaJose.setBlancos(10);
            mesaJose.setNulos(10);
            mesaJose.setColegioIdcolegio(mesaJose.getColegioIdcolegio());
            JoseManuel.setCargo("PR");

            entityManager.persist(JoseManuel);
            entityManager.getTransaction().commit();
            entityManager.close();
            emf.close();

        } else if (option == 2) {



        } else if (option == 3) {



        } else if (option == 4) {



        } else if (option == 5) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT * FROM componente", Componente.class);
            List<Componente> componentes = query.getResultList();
            for (Componente c : componentes) {
                System.out.println(c.toString());
            }
            em.getTransaction().commit();
            em.close();
            factory.close();
        }
    }
}
