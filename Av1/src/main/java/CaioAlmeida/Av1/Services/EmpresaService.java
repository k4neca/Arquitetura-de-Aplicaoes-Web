package CaioAlmeida.Av1.Services;

import CaioAlmeida.Av1.Models.Empresa;
import CaioAlmeida.Av1.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> lista() {
        return empresaRepository.findAll();
    }

    public Empresa criar(Empresa empresa) {
        if (empresa.getColaboradores() != null) {
            empresa.getColaboradores().forEach(colaborador -> colaborador.setEmpresa(empresa));
        }
        return empresaRepository.save(empresa);
    }


    public Empresa atualizar(Long id, Empresa empresaAtualizada) {
        Optional<Empresa> empresaExistente = empresaRepository.findById(id);

        if (empresaExistente.isPresent()) {
            Empresa empresa = empresaExistente.get();
            empresa.setNome(empresaAtualizada.getNome());
            empresa.setColaboradores(empresaAtualizada.getColaboradores());
            return empresaRepository.save(empresa);
        } else {
            throw new RuntimeException("Empresa não encontrada com o ID: " + id);
        }
    }

    public void delete(Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Empresa não encontrada com o ID: " + id);
        }
    }
}

