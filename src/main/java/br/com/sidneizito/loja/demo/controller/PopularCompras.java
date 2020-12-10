package br.com.sidneizito.loja.demo.controller;

import br.com.sidneizito.loja.demo.model.Compras;
import br.com.sidneizito.loja.demo.model.Produtos;
import br.com.sidneizito.loja.demo.repository.ComprasRepository;
import br.com.sidneizito.loja.demo.repository.ProdutosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@RestController
public class PopularCompras {

    private String url = "http://www.mocky.io/v2/5e960a2d2f0000f33b0257c4";


    @Autowired
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private ComprasRepository comprasRepository;

    @PostConstruct
    public void popularDatabase() {
        ResponseEntity<List<Compras>> response = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Compras>>() {
                });
        List<Compras> resultClientes = response.getBody();

        if (Objects.nonNull(resultClientes)) resultClientes.stream().filter(Objects::nonNull).forEach(
                element -> comprasRepository.saveAndFlush(element));
    }
    @GetMapping("/testeeee")
    public List<Produtos> listarProdutos(){
        ResponseEntity<List<Produtos>> response = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Produtos>>() {
                });
        List<Produtos> produtos = response.getBody();

        return produtos;
    }
}

