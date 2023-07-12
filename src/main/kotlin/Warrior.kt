import Classes.Enemy

class Warrior(name: String, lifePoints: Double) : Hero(name, lifePoints) {
    var listOfWarriorAttacks: MutableMap<String, Int> = mutableMapOf(
        "Rage Strike" to (25..35).random(),
        "Sword Slash" to (30..40).random(),
        "Battlecry" to (35..45).random(),
        "Shield Bash" to (45..55).random()
    )

    override fun attacks(enemy: Enemy) {
        var attack = true
        while (attack) {
            try {
                println("Choose your Attack 1-4")
                var index = 1
                for (attack in listOfWarriorAttacks.keys) {
                    println("$index. $attack")
                    index++
                }
                val choice = readLine()
                val selectedAttack = when (choice) {
                    "1" -> "Rage Strike"
                    "2" -> "Sword Slash"
                    "3" -> "Battlecry"
                    "4" -> "Shield Bash"
                    else -> throw IllegalArgumentException("Wrong Choice")
                }
                val damage = listOfWarriorAttacks[selectedAttack]
                println("$name attacks with $selectedAttack and Deals $damage Dmg to ${enemy.name}")
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
                        if (inventoryList.contains("Heal Potion")) {
                            lifePoints *= 1.5
                            println("$name used a Heal Potion and healed for half of their LP.")
                            println("Remaining HP: $lifePoints")
                            inventoryList.remove("Heal Potion")
                            if (!inventoryList.contains("Heal Potion")) {
                                println("You don't have any Heal Potions left.")
                            }
                            return
                        } else {
                            println("Wrong Choice")
                        }
                    }

                    "2" -> {
                        if (inventoryList.contains("Attack Potion")) {
                            println("All your attacks deal 100% more damage for once.")
                            for (attacks in listOfWarriorAttacks.keys) {
                                listOfWarriorAttacks[attacks] = listOfWarriorAttacks[attacks]!! * 2
                            }
                            val target = enemyChoice(enemyList)
                            attacks(target)
                            inventoryList.remove("Attack Potion")
                            if (!inventoryList.contains("Attack Potion")) {
                                println("You don't have any Attack Potions left.")
                            }
                            return
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
