import Classes.Enemy

class Mage(name: String, lifePoints: Double) : Hero(name, lifePoints) {
    var listOfMageAttacks: MutableMap<String, Int> = mutableMapOf(
        "Fireball" to (25..35).random(),
        "Frost Nova" to (30..40).random(),
        "Arcane Missile" to (35..45).random(),
        "Frost Bolt" to (45..55).random()
    )

    override fun attacks(enemy: Enemy) {
        while (true) {
            try {
                println("Choose an Attack 1-4")
                var index = 1
                for (attack in listOfMageAttacks.keys) {
                    println("$index. $attack")
                    index++
                }
                val choice = readLine()
                val selectedAttack = when (choice) {
                    "1" -> "Fireball"
                    "2" -> "Frost Nova"
                    "3" -> "Arcane Missile"
                    "4" -> "Frost Bolt"
                    else -> throw IllegalArgumentException("Wrong Choice")
                }
                val damage = listOfMageAttacks[selectedAttack]
                println("$name attacks with $selectedAttack and Deals $damage Dmg to ${enemy.name}")
                if (damage != null) {
                    enemy.lifePointsEnemy -= damage
                    println("${enemy.name} has ${enemy.lifePointsEnemy} LP remaining")
                }
                break
            } catch (e: IllegalArgumentException) {
                println("Wrong Choice")
            }
        }
    }

    override fun useInventory(enemyList: MutableList<Enemy>) {
        while (inventoryList.size > 0) {
            try {
                println("1: Heal Potion 2: Destruction Potion")
                val choice = readLine()
                when (choice) {
                    "1" -> {
                        if (inventoryList.contains("Heal Potion")) {
                            lifePoints *= 1.5
                            println("$name used a Heal Potion and healed for half of their LP.")
                            println("Remaining HP: $lifePoints")
                            inventoryList.remove("Heal Potion")
                            if (!inventoryList.contains("Heal Potion")) {
                                println("You don't have any Heal Potions left.")
                            }
                            break
                        } else {
                            println("Wrong Choice")
                        }
                    }

                    "2" -> {
                        if (inventoryList.contains("Destruction Potion")) {
                            println("All your attacks deal 100% more damage for once.")
                            for (attacks in listOfMageAttacks.keys) {
                                listOfMageAttacks[attacks] = listOfMageAttacks[attacks]!! * 2
                            }
                            val target = enemyChoice(enemyList)
                            attacks(target)
                            inventoryList.remove("Attack Potion")
                            if (!inventoryList.contains("Attack Potion")) {
                                println("You don't have any Attack Potion left.")
                            }
                            break
                        } else {
                            println("Wrong Choice")
                        }
                    }

                    else -> {
                        throw IllegalArgumentException()
                    }
                }
            } catch (e: IllegalArgumentException) {
                println("Wrong Choice")
            }
        }
        if (inventoryList.size == 0) {
            println("Your Inventory is Empty")
        }
    }
}
