package Classes

import Hero
import SubBoss

open class Enemy(var name: String, var lifePointsEnemy: Double) {

    open fun enemyAttacks(
        championsList: MutableList<Hero>,
        enemyList: MutableList<Enemy>
    ) {
    }

    open fun spawnAdd(): SubBoss {
        return SubBoss("", 0.0)
    }

    open fun enemyDebuff(championsList: MutableList<Hero>) {
    }

    open fun fireAoe(championsList: MutableList<Hero>) {
    }
}
