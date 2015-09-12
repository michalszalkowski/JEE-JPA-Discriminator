package pl.btbw.web.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArticleDto extends PostDto {

	@XmlElement
	private String category;

	public ArticleDto(int id, String name, String category) {
		super(id, name);
		this.category = category;
	}
}
