import Classes.Enemy

fun begruessung() {
    println("Whalecum Adventurer!")
    println("Are you ready to save the World?")
    println("You want the Boss Jewelry?")
    println("Get him boy!")
}

fun enemyChoice(enemyList: MutableList<Enemy>): Enemy {
    while (true) {
        var i = 0
        println("Select target:")
        for (enemies in enemyList) {
            println("$i: ${enemies.name}")
            i++
        }
        try {                                                           //Allows to choose a target from a list of enemies
            var choice2 = readLine()!!.toInt()                          //And a try catch falls falsche eingabe
            val target = enemyList[choice2]
            return target
        } catch (e: NumberFormatException) {
            println("Wrong Choice")
        } catch (e: IndexOutOfBoundsException) {
            println("Wrong Choice")
        }
    }
}
