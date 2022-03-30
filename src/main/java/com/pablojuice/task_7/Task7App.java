package com.pablojuice.task_7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import com.pablojuice.task_7.entities.Student;
import com.pablojuice.task_7.entities.Subject;
import com.pablojuice.task_7.entities.SubjectMaterial;
import com.pablojuice.task_7.entities.Teacher;
import com.pablojuice.task_7.services.StudentService;
import com.pablojuice.task_7.services.SubjectService;
import com.pablojuice.task_7.services.TeacherService;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.Properties;

import static com.pablojuice.shared.SpringDataUtils.*;

@Configuration
@ComponentScan(basePackages = "com.pablojuice.task_7.*")
@EnableJpaRepositories(basePackages = "com.pablojuice.task_7.*")
public class Task7App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Task7App.class);

		StudentService studentService = context.getBean(StudentService.class);
		SubjectService subjectService = context.getBean(SubjectService.class);
		TeacherService teacherService = context.getBean(TeacherService.class);

		Student student1 = new Student("Pavlo", 11, new Date());
		Student student2 = new Student("Andrew", 2, new Date());

		studentService.addStudent(student1);
		studentService.addStudent(student2);

		System.err.println(studentService.getStudentRepository().findAll());

		Teacher teacher1 = new Teacher("Teacher", "One");
		Teacher teacher2 = new Teacher("Teacher", "Two");

		teacherService.addTeacher(teacher1);
		teacherService.addTeacher(teacher2);

		System.err.println(teacherService.getTeacherRepository().findAll());

		Subject subject1 = new Subject("Algebra");
		teacher1.addSubject(subject1);
		SubjectMaterial subjectMaterial1 = new SubjectMaterial("materail1", subject1);
		subject1.setMaterial(subjectMaterial1);
		subject1.addStudent(student1);
		subject1.setTeacher(teacher1);

		Subject subject2 = new Subject("English");
		teacher2.addSubject(subject2);
		SubjectMaterial subjectMaterial2 = new SubjectMaterial("materail2", subject2);
		subject2.setMaterial(subjectMaterial2);
		subject2.addStudent(student2);
		subject2.setTeacher(teacher2);

		subjectService.addSubject(subject1);
		subjectService.addSubject(subject2);
		subjectService.getSubjectMaterialRepository().save(subjectMaterial1);
		subjectService.getSubjectMaterialRepository().save(subjectMaterial2);

		System.err.println(subjectService.getSubjectRepository().findAll());
		System.err.println(subjectService.getSubjectMaterialRepository().findAll());
		System.err.println(teacherService.getTeacherRepository().findAll());
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		return generateEntityManagerFactory("com.pablojuice.task_7");
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
