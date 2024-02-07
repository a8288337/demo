package main.java;
public class Application {

    // flag�Ƿ������Ż݄�
    public float compute(Fruit... fruits) {
        float totalPrice = 0;
        for (Fruit fruit : fruits) {
            totalPrice += fruit.price * fruit.num * fruit.discount;
        }
        return totalPrice;
    }

    public float specialDiscount(float totalPrice, float totalDiscount) {
        float price = totalPrice;
        float discount = 0;
        // ÿ��100Ԫ��10Ԫ
        while (price >= 100) {
        	discount += totalDiscount;
            price -= 100; // ��ȥ�����Ľ��󣬼����ж�ʣ�����Ƿ�������������
        }
        return totalPrice - discount;
    }

    private static class Fruit {
        String name; // ����
        int num; // ����
        float price; // ����
        float discount; // �ۿ�

        public Fruit(String name, int num, float price, float discount) {
            this.name = name;
            this.num = num;
            this.price = price;
            this.discount = discount;
        }
    }

    public static void main(String[] args) {
        /* (1) ��һ�ҳ��У�����ƻ���Ͳ�ݮ������ƻ�� 8 Ԫ/���ݮ 13 Ԫ/�
        ���ڹ˿� A �ڳ��й��������ɽ�ƻ���Ͳ�ݮ����Ҫ����һ������Ǯ��
        ���д���������� A �����ˮ������ (ˮ������Ϊ���ڵ��� 0 ������)�����㲢������������Ʒ���ܼۡ�
        ��������8��ƻ����6���ݮ*/
        Application app = new Application();
        app.compute1("A");
        app.compute2("B");
        app.compute3("C");
        app.compute4("D");
    }

    /* (1) ��һ�ҳ��У�����ƻ���Ͳ�ݮ������ƻ�� 8 Ԫ/���ݮ 13 Ԫ/�
       ���ڹ˿� A �ڳ��й��������ɽ�ƻ���Ͳ�ݮ����Ҫ����һ������Ǯ��
       ���д���������� A �����ˮ������ (ˮ������Ϊ���ڵ��� 0 ������)�����㲢������������Ʒ���ܼۡ�
       ��������8��ƻ����6���ݮ*/
    public static float compute1(String customer) {
        Application app = new Application();
        Fruit apple = new Fruit("apple", 8, 8, 1);
        Fruit strawberry = new Fruit("strawberry", 6, 13, 1);
        float price = app.compute(apple, strawberry);
        System.out.println(customer + "�����ˮ���ܼۣ�" + price);
        return price;
    }

    /*
     * 2������������һ��ˮ��â�����䶨��Ϊ 20 Ԫ/� ���ڹ˿� B �ڳ��й��������ɽ�ƻ���� ��ݮ��â���������һ����Ҫ����Ǯ�� ���д���������� B
     * �����ˮ������ (ˮ������Ϊ���ڵ��� 0 ������)�����㲢������������Ʒ���ܼۡ� ��������8��ƻ����6���ݮ��6��â��
     */
    public static float compute2(String customer) {
        Application app = new Application();
        Fruit apple = new Fruit("apple", 8, 8, 1);
        Fruit strawberry = new Fruit("strawberry", 6, 13, 1);
        Fruit mango = new Fruit("mango", 6, 20, 1);
        float price = app.compute(apple, strawberry, mango);
        System.out.println(customer + "�����ˮ���ܼۣ�" + price);
        return price;
    }

    /*
     * 3�����������������ݮ��ʱ�� 8 �ۡ� ���ڹ˿� C �ڳ��й��������ɽ�ƻ���� ��ݮ��â���������һ����Ҫ����Ǯ�� ���д���������� C �����ˮ������
     * (ˮ������Ϊ���ڵ��� 0 ������)�����㲢������������Ʒ���ܼۡ���������8��ƻ����6���ݮ��6��â��
     */
    public static float compute3(String customer) {
        Application app = new Application();
        Fruit apple = new Fruit("apple", 8, 8, 0.8f);
        Fruit strawberry = new Fruit("strawberry", 6, 13, 0.8f);
        Fruit mango = new Fruit("mango", 6, 20, 0.8f);
        float price = app.compute(apple, strawberry, mango);
        System.out.println(customer + "�����ˮ���ܼۣ�" + price);
        return price;
    }

    /*
     * 4�������Ч�����ԣ����м����Ӵ�������ȣ������� 100 �� 10 �顣 ���ڹ˿� D �ڳ��й��������ɽ�ƻ���� ��ݮ��â���������һ����Ҫ����Ǯ��
     * ���д���������� D �����ˮ������ (ˮ������Ϊ���ڵ��� 0 ������)�����㲢������������Ʒ���ܼۡ���������8��ƻ����6���ݮ��6��â��
     */
    public static float compute4(String customer) {
        Application app = new Application();
        Fruit apple = new Fruit("apple", 8, 8, 0.8f);
        Fruit strawberry = new Fruit("strawberry", 6, 13, 0.8f);
        Fruit mango = new Fruit("mango", 6, 20, 0.8f);
        float price = app.specialDiscount(app.compute(apple, strawberry, mango), 10);
        System.out.println(customer + "�����ˮ���ܼۣ������󣩣�"  + price);
        return price;
    }
    
  
}