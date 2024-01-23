package com.lex.caller.controller;

import com.lex.caller.model.Article;
import com.lex.caller.service.ArticleClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * @author : Lex Yu
 */
@RestController
@RequestMapping("/api/content")
public class ArticleCallerController {
	public final ArticleClient articleClient;

	public ArticleCallerController(ArticleClient articleClient) {
		this.articleClient = articleClient;
	}

	@GetMapping("/articles")
	public ResponseEntity<List<Article>> findAllArticles() {
		return articleClient.findAll();
	}

	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> findById(@PathVariable String id) {
		Article article = articleClient.findOne(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article " + id + " Not Found"));
		return ResponseEntity.ok(article);
	}

	@PostMapping("/articles")
	public void create(@RequestBody Article article) {
		articleClient.create(article);
	}

	@PutMapping("/articles/{id}")
	public void update(@RequestBody Article article, @PathVariable String id) {
		articleClient.update(article, id);
	}

	@DeleteMapping("/articles/{id}")
	public void delete(@PathVariable String id) {
		articleClient.delete(id);
	}
}
