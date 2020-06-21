package com.saida.sample.firstapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class AbstractController<T> {

    public URI toUri(String path, Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path(path)
                .buildAndExpand(id).toUri();
    }

    public ResponseEntity<T> created(URI uri, T body) {
        return ResponseEntity.created(uri).body(body);
    }

    public ResponseEntity<Void> noContent(URI uri) {
        return ResponseEntity.noContent().location(uri).build();
    }

    public ResponseEntity<List<T>> ok(List<T> body) {
        return ResponseEntity.ok().body(body);
    }
}
