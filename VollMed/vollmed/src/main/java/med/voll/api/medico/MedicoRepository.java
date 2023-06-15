package med.voll.api.medico;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

// entre o <>, vai o tipo da entidade "Medico" e o tipo do atributo a chave primária dessa entidade "Long" respectivamente
public interface MedicoRepository extends JpaRepository<Medico, Long>{

    Page<Medico> findAllByAtivoTrue(org.springframework.data.domain.Pageable paginacao);
    
}
