package bm.project.core.model;

public class Numbering extends Thread {
    public int Num;
    public Numbering(int n){
        this.Num = n;
    }

    public Numbering(){}

    public void run(){
        try{
            Thread.sleep(10000);
            System.out.println(Num + "종료");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
