package com.pkg.sample.controllers;

import java.util.Collection;
import java.util.HashMap;
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

import com.pkg.sample.beans.Teacher;


@RestController
@RequestMapping("/teacher")
public class TeacherController 
{
	 Map<String, Teacher> hs1=new HashMap<String, Teacher>();
     @GetMapping("/all")
	public ResponseEntity<Collection<Teacher>> getAllteachers()
	{
		return ResponseEntity.ok(hs1.values());
		
	}
     @PostMapping("/one")
     public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher bean)
     {
    	 hs1.put(bean.getTeacherName(), bean);
    	 return ResponseEntity.ok(bean);
     }
     @PutMapping("/{teacherName}")
     public ResponseEntity<Teacher> updateTeacher(@PathVariable String teacherName,@RequestBody Teacher bean)
     {
    	 hs1.put(bean.getTeacherName(), bean);
    	 return ResponseEntity.ok(bean);
     }
     @DeleteMapping("/{teacherName}")
     public ResponseEntity<Teacher> deleteTeacher(@PathVariable String teacherName)
     {
    	  hs1.remove(teacherName);
		return ResponseEntity.ok(hs1.get(teacherName));
    	 
     }
}
