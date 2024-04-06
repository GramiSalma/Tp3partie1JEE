package ma.emsi.tp_3partie1.web;


import lombok.AllArgsConstructor;
import ma.emsi.tp_3partie1.entities.Patient;
import ma.emsi.tp_3partie1.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


//creer un controleur avec une methode return une page html Patient.html ;
// la page existe dans le dossier templates
@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page",defaultValue = "0") int page,
                        @RequestParam(name="size",defaultValue = "4")  int size,
                        @RequestParam(name="keyword",defaultValue = "") String kw){
        //declarer une liste de patients
        //la pagination c'est ce qui est a l'interieur de findAll()
        Page<Patient> pagePatient=patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        //stoker le resultat dans le model
        model.addAttribute("ListPatients",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return"Patient";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    };
    @GetMapping("/")
    public String home(){

        return "redirect:/index";
    };
}
