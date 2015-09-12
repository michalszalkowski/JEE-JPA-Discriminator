package pl.btbw.persistent.entities;

import pl.btbw.web.dto.PostDto;

import javax.persistence.*;

@Entity
@Table(name = "post")
@DiscriminatorColumn(name = "distype", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("POST")
@NamedQueries({
		@NamedQuery(name = "Post.all", query = "SELECT p FROM Post p WHERE distype = 'POST'")
})
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;

	@Column(name = "name")
	protected String name;

	public Post() {
	}

	public Post(String name) {
		this.name = name;
	}

	public PostDto asDto() {
		return new PostDto(id, name);
	}
}
