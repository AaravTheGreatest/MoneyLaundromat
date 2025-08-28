public class machine {
    double containedMoney = 0;
    public machine(double money) { containedMoney = money; }
    public double getMoney() { return containedMoney; }
    public void useMachine(double money) { containedMoney += money; } // Instead of a setter, using an adder
}
