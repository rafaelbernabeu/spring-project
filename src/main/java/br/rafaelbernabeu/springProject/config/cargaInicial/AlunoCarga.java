package br.rafaelbernabeu.springProject.config.cargaInicial;

import br.rafaelbernabeu.springProject.entity.Aluno;
import br.rafaelbernabeu.springProject.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoCarga {

    @Autowired
    private AlunoService alunoService;

    private void salvarAluno() {
        Aluno aluno = new Aluno();
        aluno.setName("Rafael2");
        aluno.setOld(27);

        alunoService.salvar(aluno);
    }

    public void setup() {
        salvarAluno();
    }
}
