package ex2;

public class Main {
    public static void main(String[]args){
        OS os = new OS();
        Job job1 = new Job(1);
        Job job2 = new Job(2);
        Job job3 = new Job(3);
        Job job4 = new Job(4);

        job1.sleep(4);
        job2.sleep(1);
        job3.sleep(2);
        job4.sleep(3);
//        job3.sleep(2);

        OS.awake();
        OS.awake();
        OS.awake();
        OS.awake();
        job4.sleep(2);
        job3.sleep(2);
        OS.awake();
        OS.awake();





    }
}
