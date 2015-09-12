package pl.btbw.web;

import pl.btbw.persistent.entities.Article;
import pl.btbw.persistent.entities.Post;
import pl.btbw.persistent.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@Path("/")
public class MainController {

	@Inject
	private Repository repository;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> doAll(@DefaultValue("POST") @QueryParam("type") String type) {

		List<Object> dtos = new ArrayList<>();

		if (type.equals("ARTICLE")) {
			List<Article> articles = repository.allArticle();
			for (Article article : articles) {
				dtos.add(article.asDto());
			}
			return dtos;
		}

		List<Post> posts = repository.allPost();
		for (Post post : posts) {
			dtos.add(post.asDto());
		}
		return dtos;
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> doPostAdd(@PathParam("name") String name) {

		repository.save(new Post(name));

		return new HashMap<String, String>() {{
			put("message", "ok");
		}};
	}

	@GET
	@Path("/{category}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> doArtAdd(@PathParam("category") String category, @PathParam("name") String name) {

		repository.save(new Article(name, category));

		return new HashMap<String, String>() {{
			put("message", "ok");
		}};
	}
}
