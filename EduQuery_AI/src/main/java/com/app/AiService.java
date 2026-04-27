package com.app;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.Student;
import com.app.Service.StudentService;

import java.util.List;

@Service
public class AiService {

    @Autowired
    private ChatClient.Builder builder;

    @Autowired
    private StudentService studentService;

    public void chat(String userMessage) {

        // Step 1: Fetch all students from DB
        List<Student> students = studentService.findAll();
        // Step 2: Build a prompt with student data as context
        String prompt = """
                You are a helpful student database assistant.
                Here is the current student data:
                %s
                
                User question: %s
                
                Answer based only on the data above.
                """.formatted(students.toString(), userMessage);

        // Step 3: Send to Ollama and print response
        String response = builder.build()
                .prompt(prompt)
                .call()
                .content();
        System.out.println("\nAI: " + response);
    }
}
