package task_5;

public class MavenTask {
	//write a maven command for executing one of your tasks with arguments.

	//mvn clean install exec:java -D"exec.mainClass"="task_5.MavenTask" -D"exec.args"="0 1 2 3 4 5"

	public static void main(String[] args) {
		for (String s: args) {
			System.out.println("Maven " + s);
		}
	}
}
