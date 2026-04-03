public class Warrior extends Character {
    int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    public void attack(Character target){
        if(target.health <= 0){
            throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
        }
        target.receiveDamage(this.strength);
        System.out.println(target.getName() + "recibio un golpe de " + this.strength + "ahora tiene " + target.getCurrentHealth() + " de vida");
    }

    public void performHeavyAttack(Character target) {
        if (target == null){
            throw new InvalidTargetException("No se puede realizar una acción a un objetivo nulo");
        }

        if(target.health <= 0){
            throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
        }

        if(this.health <= 60 && this.health > 30){
            target.receiveDamage(this.strength * 2);
            System.out.println("el guerrero hizo un ataque pesado");
        }
        else{
            target.receiveDamage(this.strength);
            System.out.println("fue un ataque simple");
        }


    }

    public void enterBerserkMode() {

        if (this.status == Status.FURIOUS  ){
            throw new BerserkAlreadyActiveException(this.getName() + " ya está en modo furioso");
        }

        this.status = Status.FURIOUS;
        this.strength += 10;



    }
}
