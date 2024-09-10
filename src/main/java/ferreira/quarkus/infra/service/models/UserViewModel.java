package ferreira.quarkus.infra.service.models;

import java.util.UUID;

public class UserViewModel {
    public UserViewModel(UUID userId, String username)
    {
        this.userId = userId;
        this.username = username;
    }
    public UUID userId;
    public String username;
}
