package br.rafaelbernabeu.springProject.service.localidades;

import br.rafaelbernabeu.springProject.entity.localidades.Mesorregiao;
import br.rafaelbernabeu.springProject.repository.localidades.MesorregiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesorregiaoService {

    @Autowired
    private MesorregiaoRepository repository;

    public Mesorregiao salvar(Mesorregiao mesorregiao) {
        return repository.save(mesorregiao);
    }
    public List<Mesorregiao> salvar(Iterable<Mesorregiao> mesorregioes) {
        return repository.saveAll(mesorregioes);
    }
}