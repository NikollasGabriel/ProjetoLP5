package State;

import Model.Aluno;

public interface AlunoEstado {
    
    public String getEstado();
    
    public String aprovadoNota(Aluno a);
    
    public String aprovadoFrequencia(Aluno a);
    
    public String reprovadoNota(Aluno a);
    
    public String reprovadoFrequencia(Aluno a);
    
    public String naoAvaliado(Aluno a);
    
}
