public interface Combatant {
    void receiveDamage(int damage)throws CharacterAlreadyDeadException;;        // recibir daño
    boolean isAlive();                     // Verificar si el combatiente está vivo
    int getCurrentHealth();                // Obtener la salud actual
    String getName();                      // Obtener el nombre
    String getStatus();// Obtener el estado (Vivo, Muerto, etc.)
}