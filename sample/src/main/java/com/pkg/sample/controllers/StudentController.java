package com.pkg.sample.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.sample.beans.Student;

@RestController
@RequestMapping("/student")
public class StudentController 
{
     Map<String, Student> hs=new HashMap<String, Student>();
     @GetMapping("/all")
	public ResponseEntity<Collection<Student>> getAllstudents()
	{
		return ResponseEntity.ok(hs.values());
		
	}
     @PostMapping("/one")
     public ResponseEntity<Student> addStudent(@RequestBody Student bean)
     {
    	 hs.put(bean.getStudentName(), bean);
    	 return ResponseEntity.ok(bean);
     }
     @PutMapping("/{studentName}")
     public ResponseEntity<Student> updateStudent(@PathVariable String studentName,@RequestBody Student bean)
     {
    	 hs.put(bean.getStudentName(), bean);
    	 return ResponseEntity.ok(bean);
     }
     @DeleteMapping("/{studentName}")
     public ResponseEntity<Student> deleteStudent(@PathVariable String studentName)
     {
    	  hs.remove(studentName);
		return ResponseEntity.ok(hs.get(studentName));
    	 
     }
     @PostMapping("/bulk")
     public ResponseEntity<List<Student>> addBulkstudents(@RequestBody List<Student> bean)
     {
    	 for (Student student : bean)
    	 {
			hs.put(student.getStudentName(), student);
		}
    	 return ResponseEntity.ok(bean);
     }
	
}
