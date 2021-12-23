
# Stable Shared Build Services 

In Gradle 7.4, the Shared Build Services API will be promoted to stable.

Using a build service from a task without the corresponding `Task#usesService` declaration will be deprecated. The deprecation is documented in the [migration guide](https://docs.gradle.org/release-nightly/userguide/upgrading_version_7.html#undeclared_build_service_usage). The docs and javadocs were updated to make the requirement clear.

Gradle will nag about the deprecated behaviour but, as with the other "nags" for deprecations, it has been deferred until Gradle 7.5.

The nags are currently enabled by a feature flag. The `settings.gradle.kts` script for this build enables the feature.
You can see the nags by running:

```
> ./gradlew broken --warning-mode all
```
