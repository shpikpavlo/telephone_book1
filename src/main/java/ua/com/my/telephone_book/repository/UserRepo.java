package ua.com.my.telephone_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.my.telephone_book.models.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
