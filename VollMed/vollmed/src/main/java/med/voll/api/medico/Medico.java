package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    
    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public void atualizarInformacoes(DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        if(dadosAtualizacaoMedico.nome() != null) {
            this.nome = dadosAtualizacaoMedico.nome();
        }

        if (dadosAtualizacaoMedico.telefone() != null) {
            this.telefone = dadosAtualizacaoMedico.telefone();
        }

        if (dadosAtualizacaoMedico.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizacaoMedico.endereco());
        }
        
    }

    public void excluir() {
        this.ativo = false;
    }

}
