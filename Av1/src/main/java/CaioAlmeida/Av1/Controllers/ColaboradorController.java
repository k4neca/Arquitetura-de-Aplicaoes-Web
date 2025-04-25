package CaioAlmeida.Av1.Controllers;

import CaioAlmeida.Av1.Models.Colaborador;
import CaioAlmeida.Av1.Services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> listar() {
        List<Colaborador> colaboradores = colaboradorService.lista();
        return ResponseEntity.ok(colaboradores);
    }

    @PostMapping
    public ResponseEntity<Colaborador> criar(@RequestBody Colaborador colaborador) {
        Colaborador novoColaborador = colaboradorService.criar(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoColaborador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizar(@PathVariable Long id, @RequestBody Colaborador colaboradorAtualizado) {
        try {
            Colaborador colaborador = colaboradorService.atualizar(id, colaboradorAtualizado);
            return ResponseEntity.ok(colaborador);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            Colaborador colaborador = new Colaborador();
            colaborador.setId(id);
            colaboradorService.delete(colaborador);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
