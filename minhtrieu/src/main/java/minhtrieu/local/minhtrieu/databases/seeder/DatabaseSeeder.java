package minhtrieu.local.minhtrieu.databases.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional // Bắt buộc cần để entityManager hoạt động trong context giao dịch
    public void run(String... args) throws Exception {
        if (isTableEmpty()) {
            String passwordEncode = passwordEncoder.encode("password");

            entityManager.createNativeQuery("""
                    INSERT INTO users (name, email, password, user_catalogue_id, phone)
                    VALUES (?, ?, ?, ?, ?)
                """)
                .setParameter(1, "Trieu Binh Minh")
                .setParameter(2, "trieuminh2109@gmail.com")
                .setParameter(3, passwordEncode)
                .setParameter(4, 1L) // user_catalogue_id là Long
                .setParameter(5, "0123456789")
                .executeUpdate();

            System.out.println("✅ Seeded default user.");
        }
    }

    private boolean isTableEmpty() {
        Long count = (Long) entityManager
                .createQuery("SELECT COUNT(u.id) FROM User u")
                .getSingleResult();
        return count == 0;
    }
}
