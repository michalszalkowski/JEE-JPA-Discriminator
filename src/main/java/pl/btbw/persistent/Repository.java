package pl.btbw.persistent;

import pl.btbw.persistent.entities.Article;
import pl.btbw.persistent.entities.Post;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class Repository {

	@PersistenceContext(unitName = "ExamplePgDS")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Object o) {
		em.persist(o);
	}

	public List<Post> allPost() {
		Query query = em.createNamedQuery("Post.all");
		return (List<Post>) query.getResultList();
	}

	public List<Article> allArticle() {
		Query query = em.createNamedQuery("Article.all");
		return (List<Article>) query.getResultList();
	}

}
