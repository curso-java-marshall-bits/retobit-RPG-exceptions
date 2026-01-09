public abstract class Character implements Combatant {
    // 🗒️ PROPIEDADES
    protected String name;
    protected int health;
    protected Status status;

    // 🏗️ CONSTRUCTOR
    protected Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.status = Status.REGULAR;
    }

    @Override
    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) { // si es menor o igual a 0 está muerto
            this.health = 0; // nos aseguramos de que no es negativo
            this.status = Status.DEAD;
        }
    }

    @Override
    public boolean isAlive() throws CharacterAlreadyDeadException {
        if (this.status == Status.DEAD) {
            throw new CharacterAlreadyDeadException(this.name + " ya está muerto");
        }
        return this.health > 0;
    }

    @Override
    public int getCurrentHealth() throws CharacterAlreadyDeadException {
        if (this.status == Status.DEAD) {
            throw new CharacterAlreadyDeadException(this.name + " ya está muerto");
        }

        return this.health;
    }

    @Override
    public String getName() throws CharacterAlreadyDeadException {
        if (this.status == Status.DEAD) {
            throw new CharacterAlreadyDeadException(this.name + " ya está muerto");
        }
        return this.name;
    }

    @Override
    public String getStatus() throws CharacterAlreadyDeadException {
        if (this.status == Status.DEAD) {
            throw new CharacterAlreadyDeadException(this.name + " ya está muerto");
        }
        return this.status.toString();
    }
}