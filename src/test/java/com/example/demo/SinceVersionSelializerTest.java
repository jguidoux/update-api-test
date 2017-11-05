package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@JsonTest
public class SinceVersionSelializerTest {

    @Autowired
    private JacksonTester<Car> json;


    @Test
    public void serialize() throws Exception {


        Car details = new Car.CarBuilder().createCar();
        // Assert against a `.json` file in the same package as the test
        // Or use JSON path based assertions
        JsonContent<Car> response = this.json.write(details);
        assertThat(response).hasJsonPathStringValue("@.length");
        assertThat(response).extractingJsonPathStringValue("@.length")
                .isEqualTo("12");
    }


    @Test
    public void serialize2() throws Exception {

        ObjectMapper oMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Integer.class, new SinceVersionSelializer());
        oMapper.registerModule(module);

        Car details = new Car.CarBuilder().createCar();
        // Assert against a `.json` file in the same package as the test
        // Or use JSON path based assertions
        String response = oMapper.writeValueAsString(details);
//        JsonContent<Car> response = this.json.write(details);
//        assertThat(response).hasJsonPathStringValue("@.lentgh");
//        assertThat(response).extractingJsonPathStringValue("@.length")
//                .isEqualTo("12");
    }

}