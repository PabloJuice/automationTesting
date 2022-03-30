package task_6;

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
import task_6.entities.Student;
import task_6.entities.Subject;
import task_6.services.StudentService;
import task_6.services.SubjectService;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "task_6")
@EnableJpaRepositories(basePackages = "task_6")
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
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("task_6");
		factory.setPersistenceUnitName("jpaData");
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");//update
		factory.setJpaProperties(properties);
		factory.setDataSource(dataSource());
		return factory;
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/automationTesting");
		return dataSource;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
