package CaioAlmeida.Av1.Services;

import CaioAlmeida.Av1.Models.Colaborador;
import CaioAlmeida.Av1.Repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> lista(){
        return colaboradorRepository.findAll();
    }

    public Colaborador criar(Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }

    public void delete(Colaborador colaborador){
        colaboradorRepository.delete(colaborador);
    }

    public boolean existe(Long id) {
        return colaboradorRepository.existsById(id);
    }

    public Colaborador atualizar(Long id, Colaborador colaboradorAtualizado) {
        Optional<Colaborador> colaboradorExistente = colaboradorRepository.findById(id);

        if (colaboradorExistente.isPresent()) {
            Colaborador colaborador = colaboradorExistente.get();
            colaborador.setNome(colaboradorAtualizado.getNome());
            colaborador.setIdade(colaboradorAtualizado.getIdade());
            colaborador.setCargo(colaboradorAtualizado.getCargo());
            colaborador.setEmpresa(colaboradorAtualizado.getEmpresa());

            return colaboradorRepository.save(colaborador);
        } else {
            throw new RuntimeException("Colaborador não encontrado com o ID: " + id);
        }
    }
}
