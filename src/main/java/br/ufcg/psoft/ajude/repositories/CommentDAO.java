package br.ufcg.psoft.ajude.repositories;

import br.ufcg.psoft.ajude.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Long> {

    @Query(value = ("SELECT c FROM Comment c WHERE c.campaign = :dis ORDER BY c.date DESC"))
    List<Comment> findAllCommentByOrderByDateByDesc();

}
