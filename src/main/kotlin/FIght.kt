import Classes.Enemy

open class Fight(var championsList: MutableList<Hero>, var enemyList: MutableList<Enemy>) {
    fun startBattle() {
        var round = 1
        while (championsList.isNotEmpty() && enemyList.isNotEmpty()) {
            println("Round: $round:")
            for (champion in championsList) {
                if (champion.counter > 0) {
                    champion.debuff()
                    champion.counter--
                }
                println("${champion.name} is Attacking")
                println("Please Type 1 or 2")
                println("1: Attack\n2: Inventory")
                while (true) {
                    var choice = readLine()
                    when (choice) {
                        "1" -> {
                            val target = enemyChoice(enemyList)
                            champion.attacks(target)
                            if (target.lifePointsEnemy <= 0.0) {
                                println("${target.name} got defeated")
                                enemyList.remove(target)
                                if (enemyList.isEmpty()) {
                                    println("Champions Won")
                                    return
                                }
                            }
                            break
                        }

                        "2" -> {
                            println(champion.inventoryList.size)
                            if (champion.inventoryList.isNotEmpty()) {
                                champion.useInventory(enemyList)
                                break
                            } else {
                                println("Your Inventory is Empty")
                                println("1: Attack\n2: Inventory")
                                continue
                            }
                        }

                        else -> println("Wrong Choice, Please Type 1 or 2")
                    }
                }
            }

            for (enemy in enemyList.toList()) {
                enemy.enemyAttacks(championsList, enemyList)
                println("Name: ${enemy.name}   LifePoints: ${enemy.lifePointsEnemy}")

                for (champion in championsList.toList()) {
                    if (champion.lifePoints <= 0) {
                        println("${champion.name} Died")
                        championsList.remove(champion)
                    }
                }
            }
            for (champion in championsList.toList()) {
                println("Name: ${champion.name}   LifePoints: ${champion.lifePoints}")
            }
            round++
        }
        if (championsList.isEmpty()) {
            println("Champions Lost")
        }
    }
}
