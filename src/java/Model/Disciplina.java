package Model;


public class Disciplina {
    
    private int idDisciplina;
    private String nomeDisciplina;
    private int numeroCreditos;
    private int numeroVagas;

    public Disciplina(int idDisciplina, String nomeDisciplina, int numeroCreditos, int numeroVagas) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.numeroCreditos = numeroCreditos;
        this.numeroVagas = numeroVagas;
    }
    
    public Disciplina(String nomeDisciplina, int numeroCreditos, int numeroVagas) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.numeroCreditos = numeroCreditos;
        this.numeroVagas = numeroVagas;
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
}
