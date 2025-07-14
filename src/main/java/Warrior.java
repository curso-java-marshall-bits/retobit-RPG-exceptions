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
        if(target == null){
            throw new InvalidTargetException();
        }

        if (!target.isAlive()) {
            throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
        }

        target.receiveDamage(this.strength);
    }

    public void enterBerserkMode() {
        if(this.status == Status.FURIOUS){
            throw new BerserkAlreadyActiveException(this.name + " ya está en modo furioso");
        }

        this.status = Status.FURIOUS;
    }
}
