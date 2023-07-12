package Classes

import Hero
import SubBoss

open class Boss(name: String, lifePointsEnemy: Double) : Enemy(name, lifePointsEnemy) {
    var listOfBossAttacks: MutableMap<String, Int> = mutableMapOf(
        "Tail Swipe" to (30..35).random(),
        "Head Butt" to (40..45).random(),
        "Earth Quake" to (50..55).random(),
        "Flying Tackle" to (60..80).random(),
        "Spawn Add" to 0,
        "Fire Breath(Aoe)" to 0,
        "Fire Burn(Debuff)" to 0
    )

    override fun enemyAttacks(championsList: MutableList<Hero>, enemyList: MutableList<Enemy>) {
        val selectedAttack = listOfBossAttacks.keys.random()
        when (selectedAttack) {
            "Spawn Add" -> {
                enemyList.add(spawnAdd())
                listOfBossAttacks.remove("Spawn Add", 0)
            }

            "Fire Breath(Aoe)" -> fireAoe(championsList)
            "Fire Burn(Debuff)" -> enemyDebuff(championsList)
            else -> {
                val damage = listOfBossAttacks[selectedAttack]
                val target = championsList.random()
                println("$name attacks with $selectedAttack and Deals $damage Dmg to ${target.name}")
                damage?.let {
                    target.lifePoints -= it
                }
            }
        }
    }

    override fun spawnAdd(): SubBoss {
        val newBossAdd = SubBoss("Fire Elemental", 200.0)
        println("$newBossAdd is spawned with ${newBossAdd.lifePointsEnemy} LP")
        return newBossAdd
    }

    override fun enemyDebuff(championsList: MutableList<Hero>) {
        val target = championsList.random()
        target.debuff()
        target.counter = 3
        println("$name attacks with Fire Burn and deals 10% damage to ${target.name}")
        println("${target.name} has ${target.lifePoints} LP remaining")
    }

    override fun fireAoe(championsList: MutableList<Hero>) {
        val fireAoeDmg = (10..20).random()
        println("$name attacks with Fire Breath and deals $fireAoeDmg damage to ${championsList.size} targets")
        for (target in championsList) {
            target.lifePoints -= fireAoeDmg
            println("${target.name} has ${target.lifePoints} HP remaining")
        }
    }
}
