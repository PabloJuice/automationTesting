package com.pablojuice.task_6;

import com.pablojuice.task_6.entities.Student;
import com.pablojuice.task_6.entities.Subject;
import com.pablojuice.task_6.services.StudentService;
import com.pablojuice.task_6.services.SubjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.util.Date;

import static com.pablojuice.shared.SpringDataUtils.*;

@Configuration
@ComponentScan(basePackages = "com.pablojuice.task_6.*")
@EnableJpaRepositories(basePackages = "com.pablojuice.task_6.*")
public class Task6App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Task6App.class);

		StudentService studentService = context.getBean(StudentService.class);

		Student student1 = new Student("Pavlo", 11, new Date());
		Student student2 = new Student("Andrew", 2, new Date());

		studentService.addStudent(student1);
		studentService.addStudent(student2);

		System.err.println(studentService.getStudentById(student1.getId()));
		System.err.println(studentService.getStudentById(student2.getId()));

		student1.setForm(22);
		studentService.updateStudent(student1);
		studentService.deleteStudent(student2);

		System.err.println(studentService.getStudentById(student1.getId()));
		System.err.println(studentService.getStudentById(student2.getId()));

		SubjectService subjectService = context.getBean(SubjectService.class);

		Subject subject1 = new Subject("Algebra");
		Subject subject2 = new Subject("Geometry");
		Subject subject3 = new Subject("English");

		System.err.println(subjectService.getSubjectRepository().findAll());
		subjectService.addSubject(subject1);
		subjectService.addSubject(subject2);
		subjectService.addSubject(subject3);
		System.err.println(subjectService.getSubjectRepository().findAll());
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		return generateEntityManagerFactory("com.pablojuice.task_6");
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		return generateDataSource();
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return generateTransactionManager(entityManagerFactory);
	}
}
