package ma.emsi.tp_3partie1;

import ma.emsi.tp_3partie1.entities.Patient;
import ma.emsi.tp_3partie1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Tp3partie1Application implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp3partie1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //methode1:un constructeur sans parametres +setters


//methode2 :constructeur avec parametres   ces 3 methodes de lombok


        //methode 3:utiliser builder


        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,34));
        patientRepository.save(new Patient(null,"Hanane",new Date(),false,4321));
        patientRepository.save(new Patient(null,"Imane",new Date(),true,34));
    }
}

