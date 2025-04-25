package CaioAlmeida.Av1.Repositories;

import CaioAlmeida.Av1.Models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
