package br.com.allangaiteiro.bomcredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.allangaiteiro.bomcredito.model.Opportunity;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    @Query("SELECT COUNT(id) FROM Opportunity")
    long contAll();

    @Query("SELECT  SUM( CASE WHEN  MONTH(created_at) = MONTH(NOW()) THEN 1 ELSE 0 END ) from  Opportunity")
    long contMonth();

    @Query("SELECT  SUM( CASE WHEN  MONTH(created_at) = MONTH(NOW())-1 THEN 1 ELSE 0 END ) from  Opportunity")
    long contBeforeMonth();

    @Query("SELECT  SUM( CASE WHEN MONTH(created_at) = MONTH(NOW()) AND  DAY(created_at) = DAY(NOW()) THEN 1 ELSE 0 END ) from  Opportunity")
    long contDAY();

    @Query("SELECT  SUM( CASE WHEN MONTH(created_at) = MONTH(NOW()) AND  DAY(created_at) = DAY(NOW())-1 THEN 1 ELSE 0 END ) from  Opportunity")
    long contBeforeDAY();
}
