package com.company;

public class StopDemo01 {

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo("hahaha",1000);
        new Thread(demo).start();
        //demo.run();
        //Thread.sleep(1000);

       /* if (demo.getStep()%1000 ==0){
            demo.stop();
        }*/

        for (int i = 0; i <100 ; i++) {
            if (i==50){
                demo.stop();
            }
            System.out.println("main...");
        }
    }



    public static class Demo implements Runnable{
        private String name;
        private long timeValue;
        private boolean flag = true;
        private int step = 0;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getTimeValue() {
            return timeValue;
        }

        public void setTimeValue(long timeValue) {
            this.timeValue = timeValue;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public Demo(String name, long timeValue) {
            this.name = name;
            this.timeValue = timeValue;
        }

        @Override
        public void run() {


            while (flag){
                System.out.println("明天是个好天气"+step++);
            }

        }

        public void stop(){
            this.setFlag(false);
        }
    }
}
