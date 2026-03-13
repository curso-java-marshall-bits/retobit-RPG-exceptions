public class Mage extends Character {
    private int mana;


    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void castSpell(Character target) throws InsufficientManaException, InvalidTargetException {

        if(target == null) throw new InvalidTargetException("No se puede realizar una acción a un objetivo nulo");

        if (this.mana - 10 >= 0) {
            this.mana -= 10;
            target.receiveDamage(20);
            target.status = Status.POISONED;
        }else{
            throw new InsufficientManaException(this.name +  " no tiene maná suficiente");
        }
    }

    public void heal(Character target) throws InvalidTargetException, InsufficientManaException {

        if(target == null){
            throw new InvalidTargetException("No se puede realizar una acción a un objetivo nulo");
        }else{
            if(target.isAlive()){
                if(this.mana < 15 ) throw new InsufficientManaException(this.name +  " no tiene maná suficiente");

                this.mana -= 15;
                target.health += 20;
            }else{
                throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
            }
        }

    }

}
