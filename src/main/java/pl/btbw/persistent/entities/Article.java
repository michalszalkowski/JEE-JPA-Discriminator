package pl.btbw.persistent.entities;

import pl.btbw.web.dto.ArticleDto;

import javax.persistence.*;

@Entity
@Table(name = "article")
@DiscriminatorValue("ARTICLE")
@NamedQueries({
		@NamedQuery(name = "Article.all", query = "SELECT p FROM Article p WHERE distype = 'ARTICLE'")
})
public class Article extends Post {

	@Column(name = "category")
	private String category;

	public Article() {
	}

	public Article(String name, String category) {
		this.name = name;
		this.category = category;
	}

	public ArticleDto asDto() {
		return new ArticleDto(id, name, category);
	}
}