package br.com.gustavo.repository;

import br.com.gustavo.model.entities.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
}
