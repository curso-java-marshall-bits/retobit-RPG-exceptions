public class Warrior extends Character {
    int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    public void performHeavyAttack(Character target) {

        if(target == null) throw new InvalidTargetException("No se puede realizar una acción a un objetivo nulo");
        target.receiveDamage(this.strength);
    }

    public void enterBerserkMode() throws BerserkAlreadyActiveException {
        if(this.status != Status.FURIOUS){
            this.status = Status.FURIOUS;
        }else{
            throw new BerserkAlreadyActiveException( this.name + " ya está en modo furioso");
        }
    }
}
