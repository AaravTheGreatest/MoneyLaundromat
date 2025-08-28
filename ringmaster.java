public class ringmaster extends person {
	int worry = 0; // How worried is the ringmaster?
  int vault = 0; // value in vault
  int maxVault; // vault capacity
	public ringmaster(String name, double money, int worry, int maxVault) { super(name, money); this.worry = worry; this.maxVault = maxVault; }
	public void setWorry (int worry) { this.worry = worry; }
	public int getWorry() { return worry; }
	public void addWorry (int worry) { this.worry += worry; }
	public void subWorry (int worry) { this.worry -= worry; }
  public String toString() { return super.getName() + " has $" + super.getMoney() + " and a worry level of " + worry + "."; }
  public void hideMoney (double money) { 
    if ((vault + money) > maxVault) System.out.println("Your ringmaster's vault can't fit that much money! It can fit $" + (maxVault - vault) + ".\n"); 
    else {
      vault += money; 
      super.subMoney(money);
    }
  }
  public void takeFromVault(double money) {
    if ((vault - super.getMoney()) < 0) System.out.println("There's only $" + super.getMoney() + " in your ringmaster's vault!");
    else {
      vault -= money;
      super.addMoney(money);
    }
  }
  public String getType() { return "ringmaster"; }
}
