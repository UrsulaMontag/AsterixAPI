package u.m.asterixapi.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utilservice {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
