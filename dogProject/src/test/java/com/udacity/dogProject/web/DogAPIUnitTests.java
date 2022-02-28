package com.udacity.dogProject.web;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;


@ExtendWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogAPIUnitTests {

}
