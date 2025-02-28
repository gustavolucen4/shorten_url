package br.com.gustavo.controller;

import br.com.gustavo.model.dto.request.ShortenUrlRequestDTO;
import br.com.gustavo.model.dto.response.ShortenUrlResponseDTO;
import br.com.gustavo.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("urls")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<ShortenUrlResponseDTO> shortenUrl(@RequestBody ShortenUrlRequestDTO requestDTO, HttpServletRequest servletRequest){

        var id = urlService.shortenUrl(requestDTO);
        var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten", id);

        return ResponseEntity.ok(new ShortenUrlResponseDTO(redirectUrl));
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id){
        var url = urlService.recoverUrl(id);

        if (url == null)
            return ResponseEntity.notFound().build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}
