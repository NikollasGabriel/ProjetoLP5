package Model;


public class Disciplina {
    
    private Integer idDisciplina;
    private String nomeDisciplina;
    private Integer numeroCreditos;
    private Integer numeroVagas;
    private Prova p1;

    public Disciplina(Integer idDisciplina, String nomeDisciplina, Integer numeroCreditos, Integer numeroVagas, Prova p1) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.numeroCreditos = numeroCreditos;
        this.numeroVagas = numeroVagas;
        this.p1 = p1;
    }
    
    public Disciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
    
    public Disciplina(){
        
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

    /**
     * @return the p1
     */
    public Prova getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(Prova p1) {
        this.p1 = p1;
    }
        
}
