package com.example.DND;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DndApplication {

	public static void main(String[] args) {
		SpringApplication.run(DndApplication.class, args);
                getDNDMonsters();
                getAboleth();
	}
        
        public static void getDNDMonsters() {
        try {
            String url = "https://www.dnd5eapi.co/api/monsters";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonMonster = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonMonster);

            String monsters = root.findValue("count").asText();
            

            System.out.println("**********DND Monsters********");
            System.out.println("Number of Monsters: " + monsters);
            

        } catch (JsonProcessingException ex) {
           
            System.out.println("error in DND Mosnters");

        }
    }

        
        public static void getAboleth() {
        try {
            String url = "https://www.dnd5eapi.co/api/monsters/aboleth";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonMonster = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonMonster);

            String monsters = root.findValue("name").asText();
            String alignment = root.findValue("alignment").asText();
            String type = root.findValue("type").asText();
            

            System.out.println("**********DND Monsters********");
            System.out.println("Monster name: " + monsters);
            System.out.println("Monster alignment: "+ alignment);
            System.out.println("Monster type: " + type);
            

        } catch (JsonProcessingException ex) {
           
            System.out.println("error in DND Mosnters");

        }
    }
        
}

