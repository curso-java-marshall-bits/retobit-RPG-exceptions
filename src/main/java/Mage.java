public class Mage extends Character {
    private int mana;


    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void castSpell(Character target) throws InvalidTargetException, InsufficientManaException, CharacterAlreadyDeadException {
        if (target ==  null) {
            throw new InvalidTargetException("No se puede realizar una acción a un objetivo nulo");
        }

        if (!target.isAlive()){
            throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
        }

        if (this.mana -10 < 0){
            throw new InsufficientManaException(this.name + " no tiene maná suficiente");
        }

        this.mana -= 10;
        target.receiveDamage(20);
        target.status = Status.POISONED;
        }

    public void heal(Character target) {
        if (target ==  null) {
            throw new InvalidTargetException("No se puede realizar una acción a un objetivo nulo");
        }

        if (!target.isAlive()){
            throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
        }

        if (this.mana -15 < 0){
            throw new InsufficientManaException(this.name + " no tiene maná suficiente");
        }

        this.mana -= 15;
        target.health += 20;
    }
}
