package br.rafaelbernabeu.springProject.service.localidades;

import br.rafaelbernabeu.springProject.entity.localidades.Municipio;
import br.rafaelbernabeu.springProject.repository.localidades.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository repository;

    public Municipio salvar(Municipio municipio) {
        return repository.save(municipio);
    }
    public List<Municipio> salvar(Iterable<Municipio> municipios) {
        return repository.saveAll(municipios);
    }
}