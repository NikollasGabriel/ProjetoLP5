package Model;


public class Disciplina {
    
    private int idDisciplina;
    private String nomeDisciplina;
    private int numeroCreditos;
    private int numeroVagas;
    private Prova p1;

    public Disciplina(int idDisciplina, String nomeDisciplina, int numeroCreditos, int numeroVagas, Prova p1) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.numeroCreditos = numeroCreditos;
        this.numeroVagas = numeroVagas;
        this.p1 = p1;
    }
    
    public Disciplina(String nomeDisciplina, int numeroCreditos, int numeroVagas, Prova p1) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.numeroCreditos = numeroCreditos;
        this.numeroVagas = numeroVagas;
        this.p1 = p1;
    }
    
    public Disciplina(int idDisciplina) {
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

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
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
