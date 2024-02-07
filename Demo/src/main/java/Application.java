package main.java;
public class Application {

    // flag是否满减优惠劵
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
        // 每满100元减10元
        while (price >= 100) {
        	discount += totalDiscount;
            price -= 100; // 减去满减的金额后，继续判断剩余金额是否满足满减条件
        }
        return totalPrice - discount;
    }

    private static class Fruit {
        String name; // 名称
        int num; // 数量
        float price; // 单价
        float discount; // 折扣

        public Fruit(String name, int num, float price, float discount) {
            this.name = name;
            this.num = num;
            this.price = price;
            this.discount = discount;
        }
    }

    public static void main(String[] args) {
        /* (1) 有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
        现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
        请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        假设买了8斤苹果，6斤草莓*/
        Application app = new Application();
        app.compute1("A");
        app.compute2("B");
        app.compute3("C");
        app.compute4("D");
    }

    /* (1) 有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
       现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
       请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
       假设买了8斤苹果，6斤草莓*/
    public static float compute1(String customer) {
        Application app = new Application();
        Fruit apple = new Fruit("apple", 8, 8, 1);
        Fruit strawberry = new Fruit("strawberry", 6, 13, 1);
        float price = app.compute(apple, strawberry);
        System.out.println(customer + "购买的水果总价：" + price);
        return price;
    }

    /*
     * 2、超市增加了一种水果芒果，其定价为 20 元/斤。 现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？ 请编写函数，对于 B
     * 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。 假设买了8斤苹果，6斤草莓，6斤芒果
     */
    public static float compute2(String customer) {
        Application app = new Application();
        Fruit apple = new Fruit("apple", 8, 8, 1);
        Fruit strawberry = new Fruit("strawberry", 6, 13, 1);
        Fruit mango = new Fruit("mango", 6, 20, 1);
        float price = app.compute(apple, strawberry, mango);
        System.out.println(customer + "购买的水果总价：" + price);
        return price;
    }

    /*
     * 3、超市做促销活动，草莓限时打 8 折。 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？ 请编写函数，对于 C 购买的水果斤数
     * (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。假设买了8斤苹果，6斤草莓，6斤芒果
     */
    public static float compute3(String customer) {
        Application app = new Application();
        Fruit apple = new Fruit("apple", 8, 8, 0.8f);
        Fruit strawberry = new Fruit("strawberry", 6, 13, 0.8f);
        Fruit mango = new Fruit("mango", 6, 20, 0.8f);
        float price = app.compute(apple, strawberry, mango);
        System.out.println(customer + "购买的水果总价：" + price);
        return price;
    }

    /*
     * 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。 现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。假设买了8斤苹果，6斤草莓，6斤芒果
     */
    public static float compute4(String customer) {
        Application app = new Application();
        Fruit apple = new Fruit("apple", 8, 8, 0.8f);
        Fruit strawberry = new Fruit("strawberry", 6, 13, 0.8f);
        Fruit mango = new Fruit("mango", 6, 20, 0.8f);
        float price = app.specialDiscount(app.compute(apple, strawberry, mango), 10);
        System.out.println(customer + "购买的水果总价（满减后）："  + price);
        return price;
    }
    
  
}