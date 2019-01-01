package br.rafaelbernabeu.springProject.service.localidades;

import br.rafaelbernabeu.springProject.entity.localidades.Estado;
import br.rafaelbernabeu.springProject.repository.localidades.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public Estado salvar(Estado estado) {
        return repository.save(estado);
    }
    public List<Estado> salvar(Iterable<Estado> estados) {
        return repository.saveAll(estados);
    }
}