package dataObject;

import com.github.javafaker.Faker;

public interface RegistrationPageData {

    Faker faker = new Faker();

    String

            email = "marozom98@gmail.com",
            username = faker.name().username(),
            mobileNumber = "598112233",
            password = "A123456@",
            repeatPassword = "A123456@",
            repeatPasswordIncorrect = "mmmmmm";


}
