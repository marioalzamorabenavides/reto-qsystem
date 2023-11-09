package com.example.reto.domain.mapper;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseMapper {
    public static ResponseEntity<HashMap<String, Object>> buildCustomResponse(int status, String msg) {
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("status", status);
        resp.put("msg", msg);
        return ResponseEntity.status(status).body(resp);
    }

    public static ResponseEntity<HashMap<String, Object>> buildCustomResponse(int status, String msg, Object data) {
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("status", status);
        resp.put("msg", msg);
        resp.put("data", data);
        return ResponseEntity.status(status).body(resp);
    }
}
