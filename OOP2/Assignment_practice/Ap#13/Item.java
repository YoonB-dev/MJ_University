class Item{
    String name;
    int price,currInv;
    Item(String name,int price,int currInv){
        this.name = name;
        this.price = price;
        this.currInv = currInv;
    }
    String getName(){
        return name;
    }
    String getPrice(){
        return ""+price;
    }
    String getCurrInv(){
        return ""+currInv;
    }
    String getAll(){
        return name + " " + price + " " + currInv;
    }
    void changeName(String name){
        this.name = name;
    }
    void changePrice(int price){
        this.price = price;
    }
    void changeCurrInv(int currInv){
        this.currInv = currInv;
    }
    void addCurrInv(int add){
        this.currInv+=add;
    }
    void removeCurrInv(int re){
        this.currInv -= re;
    }
}

class Member{
    String Id,name;
    int totalAmount;
    Member(String Id,String name,int totalAmount){
        this.Id = Id;
        this.name = name;
        this.totalAmount = totalAmount;
    }
    String getId(){
        return this.Id;
    }
    String getName(){
        return this.name;
    }
    String getTotalAmount(){
        return "" + this.totalAmount;
    }
    String getAll(){
        return Id + " " + name + " " + totalAmount;
    }
    void changeId(String Id){
        this.Id = Id;
    }
    void changeName(String name){
        this.name = name;
    }
    void changeTotal(int total){
        this.totalAmount = total;
    }
}

class Order{
    Member member;
    Item item;
    int orderAmount;
    int num=0;
    Order(Member member,Item item, int amount){
        this.member = member;
        this.item = item;
        this.orderAmount = amount;
        if(item.currInv>=amount){
            item.currInv-=amount;
            member.totalAmount+=amount*item.price;
            num++;
        }
        else{
            System.out.println("재고가 부족하여 주문을 처리할 수 없다.");
        }
    }
    String getAll(){
        return member.name + " " + item.name + " " + orderAmount;
    }

    int getOrderNum(){
        return num;
    }

}

class Driver{
    public static void main(String args[]){
        Item it1 = new Item("노트북", 200000, 100);
        Item it2 = new Item("컴퓨터",500000,50);
        System.out.println("주문 전\n\n상품명   가격    현 재고\n"+it1.getAll()+"\n"+it2.getAll()+"\n");
        Member mem1 = new Member("2101", "선남", 0);
        Member mem2 = new Member("2102", "선녀", 0);
        Member mem3 = new Member("2103", "길동", 0);
        System.out.println("번호    이름    총 구매금액\n"+mem1.getAll()+"\n"+mem2.getAll()+"\n"+mem3.getAll()+"\n");
        Order ord1 = new Order(mem1, it1, 10);
        Order ord2 = new Order(mem2,it1,20);
        Order ord3 = new Order(mem2, it2, 30);
        Order ord4 = new Order(mem3, it1, 5);
        Order ord5 = new Order(mem3, it2, 15);
        System.out.println("\n"+ord1.getAll()+"\n"+ord2.getAll()+"\n"+
        ord3.getAll()+"\n"+ord4.getAll()+"\n"+ord5.getAll()+"\n주문 후\n상품명  가격    현 재고\n"+it1.getAll()+"\n"+it2.getAll());
        it1.addCurrInv(20);
        it2.addCurrInv(30);
        System.out.println("재고 추가후\n상품명 가격    현 재고\n"+it1.getAll()+"\n"
        +it2.getAll()+"\n번호 이름    총 구매금액\n"+mem1.getAll()+"\n"+mem2.getAll()+"\n"+mem3.getAll());
    }
}
