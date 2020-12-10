package br.com.sidneizito.loja.demo.controller;

import br.com.sidneizito.loja.demo.model.Clientes;
import br.com.sidneizito.loja.demo.repository.ClientesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import java.util.*;

@RestController
public class PopularClientes {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private ClientesRepository clientesRepository;

    private static String url = "http://www.mocky.io/v2/5de67e9f370000540009242b";

    @PostConstruct
    public void popularDatabase() {
        ResponseEntity<List<Clientes>> response = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Clientes>>() {
                });
        List<Clientes> resultClientes = response.getBody();

        if (Objects.nonNull(resultClientes)) resultClientes.stream().filter(Objects::nonNull).forEach(
                element -> clientesRepository.saveAndFlush(element));
    }
}