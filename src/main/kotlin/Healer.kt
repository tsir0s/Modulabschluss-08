import Classes.Enemy

class Healer(name: String, lifePoints: Double) : Hero(name, lifePoints) {
    var listOfHealerAttacks: MutableMap<String, Int> = mutableMapOf(
        "Divine Slap" to (25..35).random(),
        "Smite" to (30..40).random(),
        "Holy Strike" to (35..45).random(),
        "Purifying Flame" to (45..55).random()
    )

    override fun attacks(enemy: Enemy) {
        while (true) {
            try {
                println("Choose an Attack 1-4")
                var index = 1
                for (attack in listOfHealerAttacks.keys) {
                    println("$index. $attack")
                    index++
                }
                val choice = readLine()
                val selectedAttack = when (choice) {
                    "1" -> "Divive Slap"
                    "2" -> "Smite"
                    "3" -> "Holy Strike"
                    "4" -> "Purifying Flame"
                    else -> throw IllegalArgumentException("Wrong Choice")
                }
                val damage = listOfHealerAttacks[selectedAttack]
                println("$name attacks with $selectedAttack and Deals $damage dmg to ${enemy.name}")
                if (damage != null) {
                    enemy.lifePointsEnemy -= damage
                    println("${enemy.name} has ${enemy.lifePointsEnemy} HP remaining")
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
                println("1: Heal Potion 2: Attack Potion")
                val choice = readLine()
                when (choice) {
                    "1" -> {
                        if (inventoryList.contains("Healing Potion")) {
                            lifePoints *= 1.5
                            println("$name used a Healing Potion and healed for half of their HP.")
                            println("Remaining HP: $lifePoints")
                            inventoryList.remove("Healing Potion")
                            if (!inventoryList.contains("Healing Potion")) {
                                println("You don't have any Healing Potions left.")
                            }
                            break
                        } else {
                            println("Wrong Choice")
                        }
                    }

                    "2" -> {
                        if (inventoryList.contains("Destruction Potion")) {
                            println("All your attacks deal 100% damage once.")
                            for (attacks in listOfHealerAttacks.keys) {
                                listOfHealerAttacks[attacks] = listOfHealerAttacks[attacks]!! * 2
                            }
                            val target = enemyChoice(enemyList)
                            attacks(target)
                            inventoryList.remove("Attack Potion")
                            if (!inventoryList.contains("Attack Potion")) {
                                println("You don't have any Attack Potions left.")
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
