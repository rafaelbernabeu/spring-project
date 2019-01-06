package br.rafaelbernabeu.springProject.service.localidades;

import br.rafaelbernabeu.springProject.entity.localidades.Microrregiao;
import br.rafaelbernabeu.springProject.repository.localidades.MicrorregiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MicrorregiaoService {

    @Autowired
    private MicrorregiaoRepository repository;

    public Microrregiao salvar(Microrregiao microrregiao) {
        return repository.save(microrregiao);
    }
    public List<Microrregiao> salvar(Iterable<Microrregiao> microrregioes) {
        return repository.saveAll(microrregioes);
    }
}