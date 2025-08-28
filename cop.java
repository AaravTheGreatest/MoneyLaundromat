public class cop extends person {
	private int sus = 0; // suspicion is a value 1 - 10
	public cop (String name, double money, int sus) { super(name, money); this.sus = sus; }
    public void setSus (int sus) { this.sus = sus; }
    public void addSus (int sus) { this.sus += sus; }
    public void removeSus (int sus) { this.sus -= sus; }
    public int getSus() { return sus; }
    public String toString() { return this.getName() + " is a cop, has $" + this.getName() + ", and has a suspiscion level of " + sus + "."; }
    public String getType() { return "cop"; }
    public double search(person p) { return p.getMoney(); }
}
