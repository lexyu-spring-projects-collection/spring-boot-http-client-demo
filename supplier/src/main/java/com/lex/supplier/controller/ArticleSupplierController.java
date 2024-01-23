package com.lex.supplier.controller;

import com.lex.supplier.model.Article;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author : Lex Yu
 */
@RestController
@RequestMapping("/api/articles")
public class ArticleSupplierController {

	private final List<Article> articles = new ArrayList<>();

	@GetMapping
	public List<Article> findAll() throws InterruptedException {
		Thread.sleep(3000);
		return articles;
	}

	@GetMapping("/{id}")
	public Optional<Article> findById(@PathVariable String id) {
		return articles.stream().filter(article -> article.id().equals(id)).findFirst();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Article article) {
		Article a = new Article(UUID.randomUUID().toString(), article.title(), article.body());
		this.articles.add(a);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Article article, @PathVariable String id) {
		var currentArticle = articles.stream().filter(a -> a.id().equals(id)).findFirst();
		currentArticle.ifPresent(value -> {
			Article updated_a = new Article(value.id(), article.title(), article.body());
			this.articles.set(articles.indexOf(value), updated_a);
		});
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		this.articles.removeIf(a -> a.id().equals(id));
	}

	@PostConstruct
	private void init() {
		Article a1 = new Article("1", "Hello, World!", "This is my first post");
		Article a2 = new Article("2", "NodeJS, Java, Python, Go!", "This is my second post");
		Article a3 = new Article("3", "System Design, Design Pattern!", "This is my third post");
		this.articles.add(a1);
		this.articles.add(a2);
		this.articles.add(a3);
	}

}
