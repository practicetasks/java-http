package postman.example_2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    long id;
    // users/999 404 NOT FOUND
    // Логин не может быть пустым, логин не может содержать пробелов
    // Если логин не прошел проверку выдаем статус 400 BAD REQUEST
    String login;
    List<Post> posts;
}
