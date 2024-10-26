package com.shopkoi.shopkoi;

import com.shopkoi.shopkoi.Staff.Staff;
import com.shopkoi.shopkoi.Staff.StaffRepository;
import com.shopkoi.shopkoi.User.User;
import com.shopkoi.shopkoi.User.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired private UserRepository repo;
    @Autowired private StaffRepository staffRepo;

    @Test
    public void TestAddUser() {
        User user = new User();
        user.setUsername("Hoanggg");
        user.setPassword("12341");
        user.setEmail("admin@shopkoi.com");
        user.setFirstname("Hoa22321");
        user.setLastname("Lee");

        repo.save(user);
    }

    @Test
    public void UpdateUser() {
        Integer id= 1;
        Optional<User> user = repo.findById(id);
        User u = user.get();
        u.setFirstname("Nguyen");
        u.setLastname("HoaNguyen@gmail.com");

        repo.findById(id).get().setFirstname("Nguyen");
    }

    @Test
    public void TestFindById() {
        Integer id = 7;

        // Tìm người dùng theo id
        Optional<User> user = repo.findById(id);

        // Kiểm tra rằng người dùng tồn tại và có id đúng
        Assertions.assertTrue(user.isPresent(), "User should exist");
        Assertions.assertEquals(id, user.get().getId());

        // In ra username của người dùng khi tìm thấy thành công
        if (user.isPresent()) {
            System.out.println("User found with username: " + user.get().getUsername());
        }
    }

    @Test
    public void TestFindAllUsers() {
        // Lấy danh sách tất cả người dùng từ cơ sở dữ liệu
        Iterable<User> users = repo.findAll();

        // Kiểm tra xem có người dùng nào trong cơ sở dữ liệu không
        Assertions.assertTrue(users.iterator().hasNext(), "No users found in the database");

        // In ra thông tin người dùng
        users.forEach(user -> {
            System.out.println("User ID: " + user.getId() + ", Username: " + user.getUsername());
        });
    }

    @Test
    public void TestAddStaff() {
        Staff staff = new Staff();
        staff.setStaffname("Hoa");
        staff.setStaffemail("staff@shopkoi.com");
        staff.setRole("Lao cong");

        staffRepo.save(staff);
    }
}
