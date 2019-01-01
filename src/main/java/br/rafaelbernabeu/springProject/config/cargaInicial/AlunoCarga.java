package br.rafaelbernabeu.springProject.config.cargaInicial;

import br.rafaelbernabeu.springProject.entity.Aluno;
import br.rafaelbernabeu.springProject.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

@Service
public class AlunoCarga implements Callable<Boolean> {

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

    @Override
    public Boolean call() throws Exception {
        try {
            setup();
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
