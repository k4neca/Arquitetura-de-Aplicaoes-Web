package com.testesunitarios.demo.repository;

import com.testesunitarios.demo.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Test
    void deveSalvarERecuperarUsuario() {
        Usuario u = new Usuario();
        u.setNome("Ana");
        u.setEmail("ana@email.com");

        Usuario salvo = repository.save(u);

        assertNotNull(salvo.getId());
        assertEquals("Ana", salvo.getNome());
    }
}

