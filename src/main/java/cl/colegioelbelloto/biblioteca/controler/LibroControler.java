package cl.colegioelbelloto.biblioteca.controler;

import cl.colegioelbelloto.biblioteca.model.Libro;
import cl.colegioelbelloto.biblioteca.service.GoogleBooksService;
import cl.colegioelbelloto.biblioteca.service.ILibroService;
import cl.colegioelbelloto.biblioteca.service.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroControler {
    @Autowired
    LibroServiceImpl libroService;
    @Autowired
    GoogleBooksService googleBookService;

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro, Model model){
        try {

            googleBookService.buscarPorIsbn(libro.getIsbn());
            libroService.saveLibro(libro);
            model.addAttribute("mensaje","Libro guardado exitosamente");
            model.addAttribute("libro",new Libro());
            return "libro_form";
        }catch (Exception e){
            model.addAttribute("error", "Error al guardar"+e.getMessage());
            return "libro_form";
        }
    }
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("libro", new Libro());
        return "libro_form";
    }
    @GetMapping("/lista")
    public String listarLibros(Model model){
        List<Libro> libros = libroService.AllLibros();
        model.addAttribute("libros", libros);
        return "lista_libros";
    }
    @GetMapping("/buscar")
    public String buscarPorIsbn(@RequestParam String isbn, Model model){
        Libro libro = googleBookService.buscarPorIsbn(isbn);
        if(libro==null){
            model.addAttribute("error", "no se encontro informacion para el ISBN: "+ isbn);
            model.addAttribute(new Libro());
        }else{
            model.addAttribute("libro",libro);
        }
        return "libro_form";

    }
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id, Model model){
        libroService.deleteLibro(id);
        return "redirect:/libros/lista";
    }
    @GetMapping("editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model){
        Libro libro = libroService.findByIdLibro(id);
        model.addAttribute("libro", libro);
        return "libro_form";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute Libro libro){
        libroService.updateLibro(id, libro);
        return "redirect:/libros/lista";
    }

}
