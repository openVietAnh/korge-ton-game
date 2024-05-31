import kotlinx.coroutines.*
import kotlin.js.*

actual object TON {
    actual suspend fun connectWallet(): String {
        console.log("Testing")
        val options = js("{}").unsafeCast<TonConnectUIOptions>().apply {
            manifestUrl = "http://localhost:5500/manifest.json"
        }
        val connector = tonConnectUI.TonConnectUI(options)
        console.log(connector);
        return connector.connectWallet().await().account.address
    }
}

external interface TonConnectUIOptions {
    var manifestUrl: String
}

external interface Account {
    val address: String
    val chain: String
    val publicKey: String
    val walletStateInt: String
}

external interface ConnectedWalletResponse {
    var account: Account
}

@JsModule("@tonconnect/ui")
@JsNonModule
external object tonConnectUI {
    class TonConnectUI(options: TonConnectUIOptions) {
        fun connectWallet(): Promise<ConnectedWalletResponse>
    }
}
