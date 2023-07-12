import Classes.Boss
import Classes.Enemy

val sleepTime = 1000

fun main() {
    Thread.sleep(sleepTime * 3L)
    begruessung()
    Thread.sleep((sleepTime * 2.5).toLong())
    println("Have fun!")

    val mage1: Mage = Mage("Danny", 180.0)
    val warrior1: Warrior = Warrior("Sascha", 200.0)
    val priest1: Healer = Healer("Dimi", 220.0)
    val listChampions: MutableList<Hero> = mutableListOf(mage1, warrior1, priest1)
    val boss: Boss = Boss("Sebito", 500.0)
    val listEnemy: MutableList<Enemy> = mutableListOf(boss)

    println("Your journey is beginning...")
    println("These are your Champions:")
    Thread.sleep((sleepTime * 2.5).toLong())

    println("Mage: ${mage1.name}   Life Points: ${mage1.lifePoints}")
    Thread.sleep((sleepTime * 1.5).toLong())

    println("Warrior: ${warrior1.name}   Life Points: ${warrior1.lifePoints}")
    Thread.sleep((sleepTime * 1.5).toLong())

    println("Healer: ${priest1.name}   Life Points: ${priest1.lifePoints}")
    Thread.sleep((sleepTime * 1.5).toLong())

    println("The fight is starting soon. Please wait a moment...")
    Thread.sleep((sleepTime * 5).toLong())

    println("Your enemy is ${boss.name} and he has ${boss.lifePointsEnemy} Life Points")
    println("To win the fight, decrease his Life Points to 0")
    Thread.sleep((sleepTime * 1.5).toLong())

    println("Good luck!")
    Thread.sleep((sleepTime * 1.5).toLong())

    Fight(listChampions, listEnemy).startBattle()
}
