# Learn coroutines
The objective of this project is to learn coroutines in Kotlin and deep dive into it.

# Setup
Import the project in IntelliJ IDEA via gradle import.

# Coroutines
Coroutines are light-weight threads. They are launched with coroutine builder in a context of some CoroutineScope

## Key concepts
- Coroutine builder
- Coroutine Scope

### Builders
- launch - launch a new coroutine in background
- runBlocking - blocks the main thread

## Key Points
- Only inside the coroutine the suspend functions can be called

# References:
* https://github.com/kotlin/kotlinx.coroutines/blob/master/README.md#using-in-your-projects
* https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html