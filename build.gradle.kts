import org.gradle.api.provider.Property
import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters

abstract class CountingService : BuildService<CountingService.Parameters> {

    interface Parameters : BuildServiceParameters {
        val initialValue: Property<Int>
    }

    private var value: Int = parameters.initialValue.orNull ?: 0

    fun increment(): Int {
        value += 1
        return value
    }
}

val counter = gradle.sharedServices.registerIfAbsent("counter", CountingService::class) {
    parameters.initialValue.set(41)
    maxParallelUsages.set(1)
}

tasks.register<DefaultTask>("broken") {
    doLast {
        println("Service says ${counter.get().increment()}.")
    }
}