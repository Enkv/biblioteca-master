package cl.colegioelbelloto.biblioteca.service;

import cl.colegioelbelloto.biblioteca.model.Libro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;




    @Service
    public class GoogleBooksService {
        private static final String GOOGLE_BOOKS_API = "https://www.googleapis.com/books/v1/volumes?q=isbn:";

        public Libro buscarPorIsbn(String isbn) {
            RestTemplate restTemplate = new RestTemplate();
            String url = GOOGLE_BOOKS_API + isbn;

            Map response = restTemplate.getForObject(url, Map.class);

            if (response == null || !response.containsKey("items")) {
                return null;
            }

            Map volumeInfo = (Map) ((Map) ((List) response.get("items")).get(0)).get("volumeInfo");

            Libro libro = new Libro();
            libro.setIsbn(isbn);
            libro.setTitulo((String) volumeInfo.get("title"));
            if (volumeInfo.get("authors") != null) {
                libro.setAutor(((List<String>) volumeInfo.get("authors")).get(0));
            }
            if (volumeInfo.get("publishedDate") != null) {
                libro.setAnioPublicacion(Integer.valueOf(((String) volumeInfo.get("publishedDate")).substring(0,4)));
            }

            return libro;
        }
    }

