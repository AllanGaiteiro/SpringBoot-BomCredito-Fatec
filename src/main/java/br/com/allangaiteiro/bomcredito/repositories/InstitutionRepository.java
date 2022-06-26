package br.com.allangaiteiro.bomcredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.allangaiteiro.bomcredito.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
    @Query("SELECT COUNT(id) FROM Institution")
    long contAll();

    @Query("SELECT  SUM( CASE WHEN  MONTH(created_at) = MONTH(NOW()) THEN 1 ELSE 0 END ) from  Institution")
    long contMonth();

    @Query("SELECT  SUM( CASE WHEN  MONTH(created_at) = MONTH(NOW())-1 THEN 1 ELSE 0 END ) from  Institution")
    long contBeforeMonth();

    @Query("SELECT  SUM( CASE WHEN MONTH(created_at) = MONTH(NOW()) AND  DAY(created_at) = DAY(NOW()) THEN 1 ELSE 0 END ) from  Institution")
    long contDAY();

    @Query("SELECT  SUM( CASE WHEN MONTH(created_at) = MONTH(NOW()) AND  DAY(created_at) = DAY(NOW())-1 THEN 1 ELSE 0 END ) from  Institution")
    long contBeforeDAY();
}
