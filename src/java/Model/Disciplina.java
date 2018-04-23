package Model;


public class Disciplina {
    
    private Integer idDisciplina;
    private String nomeDisciplina;
    private Integer numeroCreditos;
    private Integer numeroVagas;
    
    public Disciplina(){
        
    }

    public Disciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
        
    public Disciplina(Integer idDisciplina, String nomeDisciplina, Integer numeroCreditos, Integer numeroVagas) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.numeroCreditos = numeroCreditos;
        this.numeroVagas = numeroVagas;
    }
       
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(Integer numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
        
}
