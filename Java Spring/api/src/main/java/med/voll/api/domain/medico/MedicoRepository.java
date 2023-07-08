package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query(value = """
            SELECT * 
              FROM MEDICOS M
             WHERE M.ATIVO
               AND M.ESPECIALIDADE = :especialidadeValue
               AND M.ID NOT IN(SELECT C.MEDICO_ID
            				     FROM CONSULTAS C
            				    WHERE C.DATA = :data)
            ORDER BY RANDOM()
            LIMIT 1
            """, nativeQuery = true)
    Medico escolhaMedicoAleatorioLivreNaDataPorEspecialidade(String especialidadeValue, LocalDateTime data);

    @Query ("""
    select m.ativo
    from Medico m
    where
    m.id = :id
    """)
    Boolean findAtivoById(Long id);
}
