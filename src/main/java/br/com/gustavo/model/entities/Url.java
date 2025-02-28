package br.com.gustavo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Url {

    @Id
    private String id;
    private String fullUrl;
    @Indexed(expireAfter = "0")
    private LocalDateTime expiresAt;

}
