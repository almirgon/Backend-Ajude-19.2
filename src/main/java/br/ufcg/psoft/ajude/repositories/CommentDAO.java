package br.ufcg.psoft.ajude.repositories;

import br.ufcg.psoft.ajude.models.Campaign;
import br.ufcg.psoft.ajude.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Long> {

    Comment save(Comment comment);

    Comment findById(long idComment);

}
