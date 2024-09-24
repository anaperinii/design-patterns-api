package com.devperini.patterns.service;

import com.devperini.patterns.model.Client;

public interface ClientService {
    Iterable<Client> buscarTodos();
    Client buscarPorId(Long id);
    void inserirCliente(Client cliente);
    void atualizarCliente(Long id, Client cliente);
    void deletarCliente(Long id);
}
