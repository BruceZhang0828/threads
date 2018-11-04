package com.company;

public class StaticProxTest {

    public static void main(String[] args) {
        You you = new You();
        MarryCompany marryCompany = new MarryCompany(you);
        marryCompany.marry();
    }




    public interface Marry{
        void marry();
    }
    public static class You implements Marry{
        @Override
        public void marry() {
            System.out.println("今天你结婚");
        }
    }
    public static class MarryCompany implements Marry{
        private You you;

        public MarryCompany(You you) {
            this.you = you;
        }

        @Override
        public void marry() {
            before();
            you.marry();
            behind();
        }

        private void behind() {
            System.out.println("闹洞房");
        }

        private void before() {
            System.out.println("布置结婚现场");
        }

    }
}

