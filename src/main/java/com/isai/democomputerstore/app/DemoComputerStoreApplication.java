package com.isai.democomputerstore.app;

import com.isai.democomputerstore.app.models.entitys.Permission;
import com.isai.democomputerstore.app.models.entitys.Role;
import com.isai.democomputerstore.app.models.entitys.RoleEnum;
import com.isai.democomputerstore.app.models.entitys.User;
import com.isai.democomputerstore.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoComputerStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoComputerStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository repository) {
        return args -> {
            Permission create = Permission.builder()
                    .namePermission("CREATED")
                    .build();
            Permission read = Permission.builder()
                    .namePermission("READ")
                    .build();
            Permission update = Permission.builder()
                    .namePermission("UPDATE")
                    .build();
            Permission delete = Permission.builder()
                    .namePermission("DELETE")
                    .build();
            Permission refactor = Permission.builder()
                    .namePermission("REFACTOR")
                    .build();

            Role admin = Role.builder()
                    .roleName(RoleEnum.ADMIN)
                    .permissions(Set.of(create, read, update, delete))
                    .build();
            Role user = Role.builder()
                    .roleName(RoleEnum.USER)
                    .permissions(Set.of(create, read))
                    .build();
            Role invited = Role.builder()
                    .roleName(RoleEnum.INVITED)
                    .permissions(Set.of(read))
                    .build();
            Role developer = Role.builder()
                    .roleName(RoleEnum.DEVELOPER)
                    .permissions(Set.of(create, read, update, delete, refactor))
                    .build();

            //password 'hola'
            User jhonatan = User.builder()
                    .userName("jhona")
                    .userPasswor("$2a$10$c.l16KsFTgc7.XjgVzdfF.ulyHmRZuVbhvBr5L71wXPeaEMnzuswq")
                    .isEnabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(admin))
                    .build();

            //password 'korgpa'
            User eli = User.builder()
                    .userName("eli")
                    .userPasswor("$2a$10$4C2oEuRg.dtHnlFismxAt.MEpSpV1./6YWKNyEbba2VU/C6XNjCjK")
                    .isEnabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(user))
                    .build();

            //password 'fruta'
            User dani = User.builder()
                    .userName("dani")
                    .userPasswor("$2a$10$dGpxUmHb6SQ2LGCpCDZ0IuUNisQb2.jWNxDEoYufwgn6Xuu1FEzWu")
                    .isEnabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(invited))
                    .build();

            //password 'cp1'
            User isai = User.builder()
                    .userName("isai")
                    .userPasswor("$2a$10$05bcm7WxsveWICmtEfS2fe4fo.QNDEmfrzsK9h2Uh6AX8b.o3A5OC")
                    .isEnabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(developer))
                    .build();

            //repository.saveAll(List.of(eli, dani, isai, jhonatan));

        };
    }
}
