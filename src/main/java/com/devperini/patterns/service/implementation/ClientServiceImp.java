package com.devperini.patterns.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devperini.patterns.model.Address;
import com.devperini.patterns.model.Client;
import com.devperini.patterns.repository.AddressRepository;
import com.devperini.patterns.repository.ClientRepository;
import com.devperini.patterns.service.ClientService;
import com.devperini.patterns.service.ViaCepService;

@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Client> buscarTodos() {
        return clientRepository.findAll();
    }

    @Override
    public Client buscarPorId(Long id) {
        Optional<Client> cliente = clientRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserirCliente(Client cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizarCliente(Long id, Client cliente) {
        Optional<Client> dataCliente = clientRepository.findById(id);
        if (dataCliente.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletarCliente(Long id) {
        clientRepository.deleteById(id);
    }

    private void salvarClienteComCep(Client cliente) {
        String cep = cliente.getEndereco().getCep();
        Address endereco = addressRepository.findById(cep).orElseGet(() -> {
            Address novoEndereco = viaCepService.consultarCep(cep);
            addressRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clientRepository.save(cliente);
    }
    
}