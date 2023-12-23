import Module.*
import commons.lcm

private typealias SignalCallback = (signal: Boolean) -> Unit

private data class ModuleNetworkRequest(val receiver: Module, val sender: Module, val signal: Boolean)

private class ModuleNetwork {

    val dispatchQueue = ArrayDeque<ModuleNetworkRequest>()
    var dispatchedHighSignals: Long = 0
    var dispatchedLowSignals: Long = 0

    fun queue(receiver: Module, sender: Module, signal: Boolean) {
        dispatchQueue += ModuleNetworkRequest(receiver, sender, signal)
    }

    fun completeDispatchCycle() {
        while (dispatchQueue.isNotEmpty()) {
            val request = dispatchQueue.removeFirst()
            val (receiver, sender, signal) = request
            receiver.receiveSignal(sender, signal)
            if (signal) dispatchedHighSignals++
            else dispatchedLowSignals++
        }
    }
}

private sealed class Module(val id: String, val network: ModuleNetwork) {

    protected val watchers = HashSet<SignalCallback>()
    val senders = ArrayList<Module>()
    val receivers = ArrayList<Module>()

    fun watchForSignal(onSignal: SignalCallback) {
        watchers += onSignal
    }

    open fun addSender(sender: Module) {
        senders.add(sender)
    }

    open fun addReceivers(receiver: Collection<Module>) {
        receivers.addAll(receiver)
    }

    open fun receiveSignal(sender: Module, signal: Boolean) {
        watchers.forEach { it.invoke(signal) }
    }

    class TerminatingModule(id: String, network: ModuleNetwork) : Module(id, network)

    class BroadcasterModule(id: String, network: ModuleNetwork) : Module(id, network) {
        override fun receiveSignal(sender: Module, signal: Boolean) {
            super.receiveSignal(sender, signal)
            receivers.forEach { network.queue(it, this, signal) }
        }
    }

    class FlipFlopModule(id: String, network: ModuleNetwork) : Module(id, network) {
        private var state = false
        override fun receiveSignal(sender: Module, signal: Boolean) {
            super.receiveSignal(sender, signal)
            if (signal == false) {
                state = !state
                receivers.forEach { network.queue(it, this, state) }
            }
        }
    }

    class ConjunctionModule(id: String, network: ModuleNetwork) : Module(id, network) {
        private val senderLastSignals = HashMap<Module, Boolean>()
        override fun addSender(sender: Module) {
            senderLastSignals[sender] = false
            super.addSender(sender)
        }

        override fun receiveSignal(sender: Module, signal: Boolean) {
            super.receiveSignal(sender, signal)
            senderLastSignals[sender] = signal
            if (senderLastSignals.values.all { it == true }) receivers.forEach { network.queue(it, this, false) }
            else receivers.forEach { network.queue(it, this, true) }
        }
    }

}

internal class Day20 {

    fun solvePart1(input: String): Long {
        val network = ModuleNetwork()
        val modules = parseModules(input, network)

        val button = TerminatingModule("button", network)
        val broadcaster = modules.first { it is BroadcasterModule }

        repeat(1000) {
            network.queue(broadcaster, button, false)
            network.completeDispatchCycle()
        }

        return network.dispatchedHighSignals * network.dispatchedLowSignals
    }

    fun solvePart2(input: String): Long {
        val network = ModuleNetwork()
        val modules = parseModules(input, network)

        val button = TerminatingModule("button", network)
        val broadcaster = modules.first { it is BroadcasterModule }

        val rxModule = modules.first { it.id == "rx" }
        val watchedModulesSignalIterations = rxModule.senders
            .flatMap { it.senders }
            .associateWith { -1L }
            .toMutableMap()

        var iteration = 1L
        watchedModulesSignalIterations.keys.forEach {
            it.watchForSignal { signal ->
                if (!signal) watchedModulesSignalIterations[it] = iteration
            }
        }

        while (watchedModulesSignalIterations.values.any { it == -1L }) {
            network.queue(broadcaster, button, false)
            network.completeDispatchCycle()
            iteration++
        }

        return lcm(watchedModulesSignalIterations.values)
    }

    private fun parseModules(input: String, network: ModuleNetwork): Collection<Module> {
        val rawModules = input.lineSequence().map { parseInputLine(it) }
        val modules = rawModules.associate { (type, id, _) -> id to Module(type, id, network) }.toMutableMap()

        rawModules.forEach { (_, id, receiverIds) ->
            val module = modules[id] ?: error("Module not found")
            val receivers = receiverIds.map { id -> modules[id] ?: TerminatingModule(id, network).also { modules[id] = it } }
            module.addReceivers(receivers)
            receivers.forEach { it.addSender(module) }
        }

        return modules.values
    }

    private fun parseInputLine(line: String): Triple<Char, String, List<String>> {
        val (name, receiversInput) = line.split(" -> ")
        val receivers = receiversInput.split(", ")
        return Triple(name.first(), name.letters(), receivers)
    }

    private fun String.letters() = filter { it.isLetter() }

    private fun Module(type: Char, id: String, network: ModuleNetwork) = when (type) {
        '%' -> FlipFlopModule(id, network)
        '&' -> ConjunctionModule(id, network)
        else -> BroadcasterModule(id, network)
    }
}
