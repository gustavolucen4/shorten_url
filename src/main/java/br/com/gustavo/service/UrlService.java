package br.com.gustavo.service;

import br.com.gustavo.model.dto.request.ShortenUrlRequestDTO;
import br.com.gustavo.model.entities.Url;
import br.com.gustavo.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public String shortenUrl(ShortenUrlRequestDTO requestDTO){

        String id;
        do {
            id = generateRandomString(5,8);
        }while (urlRepository.existsById(id));

        urlRepository.save(new Url(id, requestDTO.url(), LocalDateTime.now().plusMinutes(5)));
        return id;
    }

    public String recoverUrl(String id){
        Optional<Url> url = urlRepository.findById(id);
        return url.map(Url::getFullUrl).orElse(null);
    }

    public static String generateRandomString(int minLength, int maxLength) {
        int length = ThreadLocalRandom.current().nextInt(minLength, maxLength + 1);
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit)
                .build();
        return generator.generate(length);
    }

}
