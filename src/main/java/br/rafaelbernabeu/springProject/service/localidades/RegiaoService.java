package br.rafaelbernabeu.springProject.service.localidades;

import br.rafaelbernabeu.springProject.entity.localidades.Regiao;
import br.rafaelbernabeu.springProject.repository.localidades.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository repository;

    public Regiao salvar(Regiao regiao) {
        return repository.save(regiao);
    }
    public List<Regiao> salvar(Iterable<Regiao> regioes) {
        return repository.saveAll(regioes);
    }
}