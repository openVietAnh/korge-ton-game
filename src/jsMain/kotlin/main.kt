actual object TON {
    actual fun connectWallet() {
        console.log("Testing")
        tonConnectUI.connectWallet()
    }
}

@JsModule("@tonconnect/ui")
@JsNonModule
external object tonConnectUI {
    fun connectWallet()
}
