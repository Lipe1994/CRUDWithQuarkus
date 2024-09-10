package ferreira.quarkus.infra.service;

import ferreira.quarkus.infra.service.models.CreateUserCommand;
import ferreira.quarkus.infra.service.models.UpdateUserCommand;
import ferreira.quarkus.infra.service.models.UserViewModel;
import ferreira.quarkus.core.entity.UserEntity;
import ferreira.quarkus.core.exception.BusinnessEmptyException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public List<UserViewModel> findAll(Integer page, Integer pageSize)
    {
        return UserEntity.findAll()
            .page(page, pageSize)
                .stream()
                .map(u -> {
                    var user = (UserEntity) u;
                    return new UserViewModel(user.userId, user.username);
                })
                .toList();
    }

    public UserViewModel find(UUID userId)
    {
        return (UserViewModel) UserEntity
                    .findByIdOptional(userId)
                .map(u -> {
                    var user = (UserEntity) u;
                    return new UserViewModel(user.userId, user.username);
                }).orElseThrow(() -> new BusinnessEmptyException("Usuário não encontrado!"));
    }

    @Transactional
    public UserViewModel createUser(CreateUserCommand user)
    {
        var userEntity = new UserEntity();
        userEntity.username = user.username;

        UserEntity.persist(userEntity);
        return new UserViewModel(userEntity.userId, userEntity.username);
    }

    @Transactional
    public UserViewModel UpdateUser(UUID userId, UpdateUserCommand updateUser)
    {
        var dbUser = (UserEntity) UserEntity
            .findByIdOptional(userId)
            .orElseThrow(() -> new BusinnessEmptyException("Usuário não encontrado!"));


        dbUser.username = updateUser.username;
        UserEntity.persist(dbUser);

        return new UserViewModel(dbUser.userId, dbUser.username);
    }

    @Transactional
    public void DeleteUser(UUID userId)
    {
        var dbUser = (UserEntity) UserEntity
                .findByIdOptional(userId)
                .orElseThrow(() -> new BusinnessEmptyException("Usuário não encontrado!"));

        UserEntity.deleteById(dbUser.userId);
    }
}
