import Classes.Enemy

open class SubBoss(name: String, lifePointsEnemy: Double) : Enemy(name, lifePointsEnemy) {
    var listOfSubBossAttacks: MutableMap<String, Int> = mutableMapOf(
        "Fire Chain from add" to (20..25).random(),
        "Fire Blast from add" to (25..30).random()
    )

    override fun enemyAttacks(championsList: MutableList<Hero>, enemyList: MutableList<Enemy>) {
        val selectedAttack = listOfSubBossAttacks.keys.random()
        val target = championsList.random()
        val damage = listOfSubBossAttacks[selectedAttack]
        println("$name attacks with $selectedAttack and Deals $damage Dmg to ${target.name}")
        damage?.let {                           //Let lets me execute nullables if its not null
            target.lifePoints -= it                  //Damage - only if its not null
        }
    }
}
