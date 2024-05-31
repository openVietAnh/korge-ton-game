import korlibs.korge.*
import korlibs.korge.scene.*
import korlibs.korge.view.*
import korlibs.image.color.*
import korlibs.korge.ui.*
import korlibs.math.geom.*
import kotlinx.coroutines.*

expect object TON {
    suspend fun connectWallet(): String
}

suspend fun main() = Korge(windowSize = Size(512, 512), backgroundColor = Colors["#2b2b2b"]) {
	val sceneContainer = sceneContainer()

	sceneContainer.changeTo { MyScene() }
}

class MyScene : Scene() {
	override suspend fun SContainer.sceneMain() {
        uiButton("Connect TON Wallet").also {
            it.width = 500.0
            it.height = 30.0
            it.pos = Point(256 - 250, 256 - 15)
        }.clicked { GlobalScope.launch { it.text =  TON.connectWallet() } }
	}
}
