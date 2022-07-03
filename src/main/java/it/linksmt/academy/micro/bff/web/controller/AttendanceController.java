package it.linksmt.academy.micro.bff.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.linksmt.academy.micro.bff.web.model.AttendanceDTO;
import it.linksmt.academy.micro.bff.web.model.AttendanceSearchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/attendances")
@Tag(name = "Attendances", description = "Course Attendaces API")
public class AttendanceController {

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @PostMapping("/search")
    public ResponseEntity<AttendanceDTO> getAttendances(@RequestBody AttendanceSearchDTO attendanceSearchDTO ) throws JsonProcessingException {

        AttendanceDTO attendanceDTO = new AttendanceDTO();

        ObjectMapper objectMapper = new ObjectMapper();

        //chiamata allo studente
        ResponseEntity<String> forEntityStudent = restTemplate.getForEntity("http://localhost:8081/students/"+attendanceSearchDTO.getUserId(), String.class);
        JsonNode jsonNode = objectMapper.readTree(forEntityStudent.getBody());
        attendanceDTO.setNome(jsonNode.get("name").asText());


        //Chiamata Al corso
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8082/courses", String.class);
        jsonNode = objectMapper.readTree(forEntity.getBody());

        jsonNode.forEach( (node) -> {
            attendanceDTO.addCourse(node.get("description").asText());
        });

        return ResponseEntity.ok(attendanceDTO);

    }


}
