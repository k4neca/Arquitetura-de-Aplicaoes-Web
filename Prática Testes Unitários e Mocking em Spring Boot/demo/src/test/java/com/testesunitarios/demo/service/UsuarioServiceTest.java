package com.testesunitarios.demo.service;

import com.testesunitarios.demo.model.Usuario;
import com.testesunitarios.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    private UsuarioRepository repository;
    private UsuarioService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);
    }

    @Test
    void deveRetornarListaDeUsuarios() {
        Usuario u1 = new Usuario();
        u1.setNome("João");

        when(repository.findAll()).thenReturn(List.of(u1));

        List<Usuario> usuarios = service.listarTodos();
        assertEquals(1, usuarios.size());
        assertEquals("João", usuarios.get(0).getNome());
    }

    @Test
    void deveSalvarUsuario() {
        Usuario u = new Usuario();
        u.setNome("Maria");

        when(repository.save(any())).thenReturn(u);

        Usuario salvo = service.salvar(u);
        assertEquals("Maria", salvo.getNome());
    }
}

