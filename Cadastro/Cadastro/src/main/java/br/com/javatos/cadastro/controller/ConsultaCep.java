package br.com.javatos.cadastro.controller;

import br.com.javatos.cadastro.model.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cep")
public class ConsultaCep {

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep (@PathVariable String cep){
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        ResponseEntity<Endereco> responseEntity = new RestTemplate().getForEntity(url, Endereco.class);
        Endereco responseObject = new RestTemplate().getForObject(url, Endereco.class);

        return responseEntity;
    }
}
