package lab;

public class CenarioBonus extends Cenario {

	public int bonus;
	
	public CenarioBonus(String descricao, int bonus) {
		super(descricao);
		this.bonus = bonus;
	}
	
	public String toString() {
		return super.toString()+" - "+this.bonus;
	}
	
	
}
