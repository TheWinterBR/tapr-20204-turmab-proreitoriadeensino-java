package br.univille.microservproreitoriadeensino.criacao_cursos.entity;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "curso", autoCreateContainer = true)
public class Curso {
    @Id
    @PartitionKey
    @GeneratedValue
    private String idCurso;
    private String nomeCurso;
    private String periodo;
    private Disciplina disciplina;

    public Curso(String idCurso, String nomeCurso, String periodo, Disciplina disciplina) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.periodo = periodo;
        this.disciplina = disciplina;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
}
