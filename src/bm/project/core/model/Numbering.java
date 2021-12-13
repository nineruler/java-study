package bm.project.core.model;

public class Numbering extends Thread{
    public void run(int num){
        try{
            Thread.sleep(10000);
            System.out.println(num + " 종료");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
