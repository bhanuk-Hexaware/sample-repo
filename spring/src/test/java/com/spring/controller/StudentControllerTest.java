package com.spring.controller

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.controller.StudentController;
import com.spring.entity.Student;
import com.spring.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
	@Mock
	private StudentService service;

	@InjectMocks
	private StudentController controller;
	
	private List<Student> prepareStudentRecords(){
		List<Student> studentstudents = new ArrayList<Student>();
		Student studentstudent1 = new Student(1L, "Sabari", "sabari@fff.com", "Nathan", "H23423443", 21, false, 232342345345f);
		Student studentstudent2 = new Student(1L, "Kishore", "kishore@fff.com", "kumar", "H26563463", 27, true, 345677345345f);
		studentstudents.add(studentstudent1);
		studentstudents.add(studentstudent2);
		return studentstudents;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareStudentRecords());
		List<Student> studentstudents = prepareStudentRecords();
		List<Student> studentstudentsFromController =  controller.fetchAll();
		for(int i=0; i<studentstudents.size();i++) {
			Assertions.assertEquals(studentstudents.get(i).getId(), studentstudentsFromController.get(i).getId());
			Assertions.assertEquals(studentstudents.get(i).getAge(), studentstudentsFromController.get(i).getAge());
			Assertions.assertEquals(studentstudents.get(i).getPlateletsCount(), studentstudentsFromController.get(i).getPlateletsCount());
			Assertions.assertEquals(studentstudents.get(i).getEmailId(), studentstudentsFromController.get(i).getEmailId());
			Assertions.assertEquals(studentstudents.get(i).getFirstName(), studentstudentsFromController.get(i).getFirstName());
			Assertions.assertEquals(studentstudents.get(i).getLastName(), studentstudentsFromController.get(i).getLastName());
			Assertions.assertEquals(studentstudents.get(i).getPassportNumber(), studentstudentsFromController.get(i).getPassportNumber());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareStudentRecords());
		List<Student> studentstudents = null; //Intentionally made null to fail the test.
		List<Student> studentstudentsFromController =  controller.fetchAll();
		Assertions.assertNotEquals(studentstudents, studentstudentsFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareStudentRecords().get(0));
			Student studentById = prepareStudentRecords().get(0);
			Student studentByIdFromController = controller.fetchById(1L);
			
			Assertions.assertEquals(studentById.getId(), studentByIdFromController.getId());
			Assertions.assertEquals(studentById.getAge(), studentByIdFromController.getAge());
			Assertions.assertEquals(studentById.getPlateletsCount(), studentByIdFromController.getPlateletsCount());
			Assertions.assertEquals(studentById.getEmailId(), studentByIdFromController.getEmailId());
			Assertions.assertEquals(studentById.getFirstName(), studentByIdFromController.getFirstName());
			Assertions.assertEquals(studentById.getLastName(), studentByIdFromController.getLastName());
			Assertions.assertEquals(studentById.getPassportNumber(), studentByIdFromController.getPassportNumber());
		     
			Assertions.assertEquals(studentById.getName(), studentByIdFromController.getName());
			Assertions.assertEquals(studentById.getRollno(), studentByIdFromController.getRollno());
	 }

	 @Test public void fetchByIdFailure() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareStudentRecords().get(0));
			Student studentById = prepareStudentRecords().get(1);
			Student studentByIdFromController = controller.fetchById(1L);
			
			Assertions.assertNotEquals(studentById.getId(), studentByIdFromController.getId());
			Assertions.assertNotEquals(studentById.getAge(), studentByIdFromController.getAge());
			Assertions.assertNotEquals(studentById.getPlateletsCount(), studentByIdFromController.getPlateletsCount());
			Assertions.assertNotEquals(studentById.getEmailId(), studentByIdFromController.getEmailId());
			Assertions.assertNotEquals(studentById.getFirstName(), studentByIdFromController.getFirstName());
			Assertions.assertNotEquals(studentById.getLastName(), studentByIdFromController.getLastName());
			Assertions.assertNotEquals(studentById.getPassportNumber(), studentByIdFromController.getPassportNumber());

        Assertions.assertNotEquals(studentById.getName(), studentByIdFromController.getName());
        Assertions.assertNotEquals(studentById.getRollno(), studentByIdFromController.getRollno());
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(1L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Student studentToBeCreated = prepareStudentRecords().get(0);
		Student studentReturned = prepareStudentRecords().get(0);
		studentReturned.setId(1L); //Changed the ID.
		
		Mockito
			.when(controller.create(studentToBeCreated)).thenReturn(studentReturned);
		
		Student studentFromController  = controller.create(studentToBeCreated);
		Assertions.assertNotEquals(studentToBeCreated.getId(), studentFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal. 
		Assertions.assertEquals(studentToBeCreated.getAge(), studentFromController.getAge());
		Assertions.assertEquals(studentToBeCreated.getPlateletsCount(),studentFromController.getPlateletsCount());
		Assertions.assertEquals(studentToBeCreated.getEmailId(), studentFromController.getEmailId());
		Assertions.assertEquals(studentToBeCreated.getFirstName(), studentFromController.getFirstName());
		Assertions.assertEquals(studentToBeCreated.getLastName(), studentFromController.getLastName());
		Assertions.assertEquals(studentToBeCreated.getPassportNumber(),studentFromController.getPassportNumber());
        Assertions.assertEquals(studentToBeCreated.getName(), studentFromController.getName());
        Assertions.assertEquals(studentToBeCreated.getRollno(), studentFromController.getRollno());
	}
	
	@Test
	public void createFailure() {
		Student studentToBeCreated = prepareStudentRecords().get(0);
		Student studentReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(studentToBeCreated)).thenReturn(studentReturned);
		
			Student studentFromController  = controller.create(studentToBeCreated);
		Assertions.assertNull(studentFromController);
	}
	
	/*
	 * @Test public void update() { ResponseEntity<Object> responseObject = null;
	 * 
	 * Mockito.when(controller.update(studentToBeUpdated,
	 * "")).thenReturn(responseObject); }
	 */	
}