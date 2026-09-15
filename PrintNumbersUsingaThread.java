class PrintNumbersUsingaThread extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(i+"  "+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args){
        PrintNumbersUsingaThread t1 = new PrintNumbersUsingaThread();
        PrintNumbersUsingaThread t2 = new PrintNumbersUsingaThread();
        t1.start();
        t2.start();
    }
}