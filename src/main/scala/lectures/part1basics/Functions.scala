package lectures.part1basics

object Functions {
  def aFunction(a: String, b: Int): String =
    a + " " + b // << + is string concatenation
                // Also, the compiler can infer function types

  /*
   * can also be written as follows
   * def aFunction(a: String, b: Int): String = {
   *   a + " " + b
   * }
   */

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)
  // ^^^ parameter-less functions can be called like this

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  // Use Unit as a return type

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    // We can define functions inside other functions
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
   1. A greeting functions (name, age) => "Hi, my name is $name and I am $age years old"
   2. Factorial function 1 * 2 * 3 * .. * n
   3. A Fubonacci function
   f(1) = 1
   f(2) = 1
   f(n) = f(n - 1) + f(n - 2)
   4. Tests if a number is prime
   */

  def jGreeting(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old"
  }

  def jFactorial(n: Int): Int = {
    def recur(cur: Int, acc: Int): Int = {
      if(cur < 2) acc
      else recur(cur - 1, acc * cur)
    }
    recur(n, 1)
  }

  def jFib(n: Int): Int = {
    def recur(count: Int, cur: Int, next: Int): Int = {
      if (count == 0) cur
      else recur(count - 1, next, cur + next)
    }
    recur(n, 0, 1)
  }

  def jIsPrime(n: Int): Boolean = {
    if (n == 2) true
    else if((n % 2 == 0) || (n < 2)) false
    else {
      val limit = math.sqrt(n)
      def recur(cur: Int): Boolean = {
        if (cur > limit) true
        else if (n % cur == 0) false
        else recur(cur + 2)
      }
      recur(3)
    }
  }

  println(jGreeting("Alonzo", 33))
  println(jFactorial(4))
  println(jFib(8))
  println(jIsPrime(99))
  println(jIsPrime(113))


  def greetingForKids(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old"

  println(greetingForKids("David", 12))

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(factorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  // 1 1 2 3 5 8 13 21
  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
