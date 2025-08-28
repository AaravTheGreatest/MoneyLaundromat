public class person {
	private String name;
	private double money = 0.00;
	public person(String name, double money) { this.name = name; this.money = money; }
	public void setName (String name) { this.name = name; }
	public void setMoney (double money) { this.money = money; }
	public void addMoney (double money) { this.money += money; }
	public void subMoney (double money) { this.money -= money; }
	public String getName() { return name; }
	public double getMoney() { return money; }
	public String toString() { return name + " has $" + money + "."; }
  public String getType() { return "person"; }
}
