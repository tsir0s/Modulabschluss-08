import Classes.Enemy

open class Hero(var name: String, var lifePoints: Double) {
    var counter = 2

    open fun debuff() {
        lifePoints *= 0.9                   // The 10% debuff
    }

    open fun attacks(enemy: Enemy) {
        val listOfAttacks: MutableMap<String, Int> = mutableMapOf()
    }

    var inventoryList: MutableList<String> = mutableListOf("Heal Potion", "Attack Potion")

    open fun useInventory(enemyList: MutableList<Enemy>) {
    }
}
