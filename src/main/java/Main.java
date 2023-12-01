import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Componente;
import model.Mesa;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// , insertable = false, updatable = false lo que s ha de ficar al joinColumns, mirar q ue no hi haguin 2 en una sola linia

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
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();

            Query query = em.createQuery("SELECT c FROM Componente c");
            List<Componente> list = query.getResultList();
            String dni = "12345670";
            String nombre = "José Manuel Castilla Gil";
            String f_nacimiento = "2012-07-13";
            String cargo = "PR";
            String mesa_letra = "A";
            int mesa_colegio_idcolegio = 1;

            boolean componenteExistente = false;

            for (Componente nuevoComponente : list) {
                if (dni.equals(nuevoComponente.getDni()) && nombre.equals(nuevoComponente.getNombre()) && f_nacimiento.equals(nuevoComponente.getfNacimiento().toString()) && !cargo.equals("PR") && !cargo.equals("V1") && !cargo.equals("V2") && !mesa_letra.equals(nuevoComponente.getMesaLetra()) && mesa_colegio_idcolegio != nuevoComponente.getMesaColegioIdcolegio()) {
                    componenteExistente = true;
                    break;
                }
            }

            if (componenteExistente) {
                System.out.println("El componente ya existe");
            } else {
                em.getTransaction().begin();
                Componente nuevoComponente = new Componente();
                nuevoComponente.setDni(dni);
                nuevoComponente.setNombre(nombre);
                nuevoComponente.setfNacimiento(Date.valueOf(f_nacimiento));
                nuevoComponente.setCargo(cargo);
                nuevoComponente.setMesaLetra(mesa_letra);
                nuevoComponente.setMesaColegioIdcolegio(mesa_colegio_idcolegio);

                em.persist(nuevoComponente);
                em.getTransaction().commit();
                System.out.println("El componente se ha introducido correctamente");
            }

        } else if (option == 2) {

            System.out.println("No esta fet");

        } else if (option == 3) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT * FROM componente", Componente.class);
            List<Componente> componentes = query.getResultList();

            for (Componente c : componentes) {
                if (c.getMesaColegioIdcolegio() == 0 && c.getMesaLetra().isEmpty()) {
                    em.remove(c);
                }
            }

            em.getTransaction().commit();
            em.close();
            factory.close();

        } else if (option == 4) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM Componente c order by c.mesaColegioIdcolegio, c.mesaLetra, c.cargo", Componente.class);
            List<Componente> componentes = query.getResultList();

            for (Componente c : componentes) {
                System.out.println(c.getNombre() + " te el carrec " + c.getCargo());
            }

            em.getTransaction().commit();
            em.close();
            factory.close();

        } else if (option == 5) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT * FROM componente", Componente.class);
            List<Componente> componentes = query.getResultList();
            LocalDate currentDate = LocalDate.now(); // agafem la data de ara
            for (Componente c : componentes) {
                Date birthDate = c.getfNacimiento();
                LocalDate birthLocalDate = birthDate.toLocalDate();

                int edat = currentDate.getYear() - birthLocalDate.getYear();

                if (edat < 18) {
                    System.out.println(c.getNombre() + " te " + edat + " anys");
                }
            }
            em.getTransaction().commit();
            em.close();
            factory.close();

        } else if (option == 6) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT * FROM componente", Componente.class);
            List<Componente> componentes = query.getResultList();

            for (Componente c : componentes) {
                Date birthDate = c.getfNacimiento();
                if (birthDate.getYear() != 1980) {
                    System.out.println(c.getNombre() + " es de l' any: " + birthDate.getYear());
                }
            }

            em.getTransaction().commit();
            em.close();
            factory.close();

        } else if (option == 7) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT * FROM componente", Componente.class);
            List<Componente> componentes = query.getResultList();
            List<Componente> presidents = new ArrayList<>();
            int contador = 0;
            for (Componente c : componentes) {

                if (c.getCargo().equalsIgnoreCase("pr")) {
                    if (contador != 3) {
                        contador++;
                        presidents.add(c);
                    }else{
                        break;
                    }
                }
            }

            for (Componente c : presidents) {
                System.out.println(c.getDni() + " tiene de nombre: " + c.getNombre());
            }

            em.getTransaction().commit();
            em.close();
            factory.close();

        } else if (option == 8) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM Componente c order by c.dni", Componente.class);
            List<Componente> componentes = query.getResultList();

            for (Componente c : componentes) {
                if (c.getfNacimiento().getMonth() == 6 || c.getfNacimiento().getMonth() == 7 || c.getfNacimiento().getMonth() == 8){
                    System.out.println(c.getDni() + " i te el nom: " + c.getNombre());
                }
            }

            em.getTransaction().commit();
            em.close();
            factory.close();

        } else if (option == 9) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("SELECT * FROM componente", Componente.class);
            List<Componente> componentes = query.getResultList();
            List<Componente> presidents = new ArrayList<>();
            int contador = 0;
            for (Componente c : componentes) {

                if (c.getCargo().equalsIgnoreCase("pr")) {

                    if (c.getNombre().equalsIgnoreCase("Pascual Collado")){
                        Query totalVotosQuery = em.createNativeQuery("SELECT SUM(votos) FROM recuento WHERE partido_siglas =  "); // massa porro
                    }

                }
            }

            em.getTransaction().commit();
            em.close();
            factory.close();

        } else if (option == 10) {

            System.out.println("No l he fet");
            
        } else if (option == 11) {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();

            Query query = em.createNativeQuery("SELECT c.direccion, COUNT(m.letra) as taules " +
                    "FROM colegio c " +
                    "LEFT JOIN mesa m ON c.idcolegio = m.colegio_idcolegio " +
                    "GROUP BY c.direccion " +
                    "ORDER BY c.direccion");

            List<Object[]> results = query.getResultList();

            for (Object[] result : results) {
                String direccion = (String) result[0];
                Long numTaules = (Long) result[1];

                System.out.println("Col·legi a " + direccion + " amb " + numTaules + " taules.");
            }

            em.getTransaction().commit();
            em.close();
            factory.close();

        }
    }
}
