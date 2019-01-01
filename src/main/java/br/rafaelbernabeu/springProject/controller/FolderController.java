package br.rafaelbernabeu.springProject.controller;

import br.rafaelbernabeu.springProject.entity.Folder;
import br.rafaelbernabeu.springProject.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("folder")
public class FolderController {

    @Autowired
    private FolderRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    public List<Folder> getFolder(){
        return repository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Folder setFolder(@RequestBody Folder folder){
        return repository.save(folder);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Folder updateFolder(@RequestBody Folder folder){
        return repository.save(folder);
    }


    @RequestMapping(value = "/{folderId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteFolder(@PathVariable Long folderId){
        repository.deleteById(folderId);
    }

}