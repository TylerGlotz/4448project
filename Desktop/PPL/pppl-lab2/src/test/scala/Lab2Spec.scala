import jsy.tester.JavascriptyTester
import org.scalatest._
import jsy.lab2.ast._

import jsy.student.Lab2
import Lab2._

/*
 * This file contains a number of *Spec classes that define a set of
 * tests.
 *
 * All of the tests are gathered together in Lab2Suite.
 */

class AndOrSpec extends FlatSpec {

  "And" should "return true only if both expressions are true" in {
    val t = B(true)
    val f = B(false)
    assert(eval(Binary(And,t,t)) === t)
    assert(eval(Binary(And,t,f)) === f)
    assert(eval(Binary(And,f,t)) === f)
    assert(eval(Binary(And,f,f)) === f)
  } 
 
  "And" should "return non-intuitive results from differing types" in {
    val e1 = N(0)
    val e2 = B(true)
    val e3 = eval(Binary(And, e1, e2))
    assert(e3 === N(0))
  }
 
  "Or" should "return true if either or both expressions are true" in {
    val t = B(true)
    val f = B(false)
    assert(eval(Binary(Or,t,t)) === t)
    assert(eval(Binary(Or,f,t)) === t)
    assert(eval(Binary(Or,t,f)) === t)
    assert(eval(Binary(Or,f,f)) === f)
  }

  "Or" should "return non-intuitive results from differing types" in {
    val e1 = N(5)
    val e2 = B(false)
    val e3 = eval(Binary(Or, e1, e2))
    assert(e3 === N(5))
  }
  
}

class ArithmeticSpec extends FlatSpec {

  "Plus" should "add two number values and return a number" in {
    val e1 = N(1)
    val e2 = N(2)
    val e3 = eval(Binary(Plus, e1, e2))
    assert(e3 === N(3))
  }

  "Minus" should "subtract two number values and return a number" in {
    val e1 = N(3)
    val e2 = N(1)
    val e3 = eval(Binary(Minus, e1, e2))
    assert(e3 === N(2))
  }

  "Times" should "multiply two number values and return a number" in {
    val e1 = N(3)
    val e2 = N(2)
    val e3 = eval(Binary(Times, e1, e2))
    assert(e3 === N(6))
  }

  "Div" should "divide two number values and return a number" in {
    val e1 = N(8)
    val e2 = N(5)
    val e3 = eval(Binary(Div, e1, e2))
    assert(e3 === N(1.6))
  }

  "Arithmetic Operators" should "produce non-intuitive solutions given differing expression types" in {
    val e1 = B(true)
    val e2 = N(7)
    assert(eval(Binary(Plus,e1,e2)) == N(8))
  }

}

class ComparisonSpec extends FlatSpec {

  "Eq" should "return true if two numerical values are the same" in {
    val e1 = N(5)
    val e2 = N(5)
    val e3 = eval(Binary(Eq, e1, e2))
    assert(e3 === B(true))
  } 
  
  "Eq" should "return false if two numerical values are not the same" in {
    val e1 = N(5)
    val e2 = N(7)
    val e3 = eval(Binary(Eq, e1, e2))
    assert(e3 === B(false))
  }

  "Ne" should "return true if two numerical values are different" in {
    val e1 = N(5)
    val e2 = N(7)
    val e3 = eval(Binary(Ne, e1, e2))
    assert(e3 === B(true))
  } 
  
  "Ne" should "return false if two numerical values are the same" in {
    val e1 = N(5)
    val e2 = N(5)
    val e3 = eval(Binary(Ne, e1, e2))
    assert(e3 === B(false))
  }

  "Lt" should "return true if the first expression is less than the second" in {
    val e1 = N(5)
    val e2 = N(7)
    val e3 = eval(Binary(Lt, e1, e2))
    assert(e3 === B(true))
  } 
  
  "Lt" should "return false if the first expression is not strictly less than the second" in {
    val e1 = N(7)
    val e2 = N(5)
    val e3 = eval(Binary(Lt, e1, e2))
    assert(e3 === B(false))
  } 
  
  "Lt" should "return false if two number values are the same" in {
    val e1 = N(5)
    val e2 = N(5)
    val e3 = eval(Binary(Lt, e1, e2))
    assert(e3 === B(false))
  } 

  "Le" should "return true if the first expression is less than the second" in {
    val e1 = N(5)
    val e2 = N(7)
    val e3 = eval(Binary(Le, e1, e2))
    assert(e3 === B(true))
  } 
  
  "Le" should "return false if the first expression is greater than the second" in {
    val e1 = N(7)
    val e2 = N(5)
    val e3 = eval(Binary(Le, e1, e2))
    assert(e3 === B(false))
  } 
  
  "Le" should "return true if two number values are the same" in {
    val e1 = N(5)
    val e2 = N(5)
    val e3 = eval(Binary(Le, e1, e2))
    assert(e3 === B(true))
  } 

  "Gt" should "return true if the first expression is greater than the second" in {
    val e1 = N(8)
    val e2 = N(7)
    val e3 = eval(Binary(Gt, e1, e2))
    assert(e3 === B(true))
  } 
  
  "Gt" should "return false if the first expression is not strictly greater than the second" in {
    val e1 = N(4)
    val e2 = N(5)
    val e3 = eval(Binary(Gt, e1, e2))
    assert(e3 === B(false))
  } 
  
  "Gt" should "return false if two number values are the same" in {
    val e1 = N(5)
    val e2 = N(5)
    val e3 = eval(Binary(Gt, e1, e2))
    assert(e3 === B(false))
  } 

  "Ge" should "return true if the first expression is greater than the second" in {
    val e1 = N(8)
    val e2 = N(7)
    val e3 = eval(Binary(Ge, e1, e2))
    assert(e3 === B(true))
  } 
  
  "Ge" should "return false if the first expression is less than the second" in {
    val e1 = N(4)
    val e2 = N(5)
    val e3 = eval(Binary(Ge, e1, e2))
    assert(e3 === B(false))
  } 
  
  "Ge" should "return true if two number values are the same" in {
    val e1 = N(5)
    val e2 = N(5)
    val e3 = eval(Binary(Ge, e1, e2))
    assert(e3 === B(true))
  }

  "Comparisons" should "produce non-intuitive results given the expressions given" in {
    val e1 = N(5)
    val e2 = Undefined
    assert(eval(Binary(Eq,e1,e2)) === B(false))
  } 
}

class ConstSpec extends FlatSpec {

  "ConstDecl" should "extend the environment with the first expression results bound to the identifier, and then eval the second expression" in {
    val e1 = N(3)
    val e2 = Binary(Plus, Var("x"), N(1))
    val e3 = eval(ConstDecl("x", e1, e2)) 
    assert(e3 === N(4))
  } 
  
}

class IfSpec extends FlatSpec {

  "If" should "eval the first expression if the conditional is true" in {
    val e1 = Binary(Plus, N(3), N(2))
    val e2 = Binary(Plus, N(1), N(1))
    val e3 = eval(If(B(true), e1, e2)) 
    assert(e3 === N(5))
  } 
  
  "If" should "eval the second expression if the conditional is false" in {
    val e1 = Binary(Plus, N(3), N(2))
    val e2 = Binary(Plus, N(1), N(1))
    val e3 = eval(If(B(false), e1, e2)) 
    assert(e3 === N(2))
  } 
  
}

class SeqSpec extends FlatSpec {

  "Seq" should "execute the first expression, followed by the second, and should eval to the second expression" in {
    val e1 = Binary(Plus, N(3), N(2))
    val e2 = Binary(Plus, N(1), N(1))
    val e3 = eval(Binary(Seq, e1, e2)) 
    assert(e3 === N(2))
  } 
  
}

class UnarySpec extends FlatSpec {

  "Neg" should "return the negation of a number value" in {
    val e1 = N(5)
    val e2 = eval(Unary(Neg, e1))
    assert(e2 === N(-5))
  } 
  
  "Not" should "return the compliment of a boolean value" in {
    val e1 = B(true)
    val e2 = B(false)
    val e3 = eval(Unary(Not, e1))
    val e4 = eval(Unary(Not, e2))
    assert(e3 === B(false))
    assert(e4 === B(true))
  }
}

class ToSpec extends FlatSpec {

  "toNumber" should "return a number of a number value" in {
    val e1 = N(1.01)
    val e2 = N(-5)
    val e3 = Undefined

    assert(toNumber(e1) === 1.01)
    assert(toNumber(e2) === -5)
    assert(toNumber(e3).isNaN === true)


  }

  "toNumber" should "return a number of a boolean value" in {
    val e1 = B(true)
    val e2 = B(false)

    assert(toNumber(e1) === 1)
    assert(toNumber(e2) === 0)
  }

  "toNumber" should "return a result of a string value" in {
    val e1 = S("Steve")
    val e2 = S("1234")
    val e3 = S("true1+false*")

    assert(toNumber(e1).isNaN  === true)
    assert(toNumber(e2) === 1234)
    assert(toNumber(e3).isNaN === true)
  }

  "toBoolean" should "return a boolean of a number value" in {
    val e1 = N(1)
    val e2 = N(0.999999)
    val e3 = N(-1)
    val e4 = N(-0)
    val e5 = N(0)

    assert(toBoolean(e1) === true)
    assert(toBoolean(e2) === true)
    assert(toBoolean(e3) === true)
    assert(toBoolean(e4) === false)
    assert(toBoolean(e5) === false)


  }

  "toBoolean" should "return a boolean of a boolean value" in {
    val e1 = B(true)
    val e2 = B(false)
    val e3 = Undefined

    assert(toBoolean(e1) === true)
    assert(toBoolean(e2) === false)
    assert(toBoolean(e3) === false)
  }

  "toBoolean" should "return a boolean of a string value" in {
    val e1 = S("true")
    val e2 = S("false")
    val e3 = S("56515614asdasdas")
    val e4 = S("")

    assert(toBoolean(e1) === true)
    assert(toBoolean(e2) === false)
    assert(toBoolean(e3) === true)
    assert(toBoolean(e4) === false)
  }

  "toStr" should "return a string of a number value" in {
    val e1 = N(1)
    val e2 = N(-1.55)
    val e3 = N(Double.NaN)

    assert(toStr(e1) === "1")
    assert(toStr(e2) === "-1.55")
    assert(toStr(e3) === "NaN")
  }

  "toStr" should "return a string of a boolean value" in {
    val e1 = B(true)
    val e2 = B(false)

    assert(toStr(e1) === "true")
    assert(toStr(e2) === "false")
  }

  "toStr" should "return a string of a string value" in {
    val e1 = S("true")
    val e2 = S("false")
    val e3 = S("124Str++")
    val e4 = Undefined

    assert(toStr(e1) === "true")
    assert(toStr(e2) === "false")
    assert(toStr(e3) === "124Str++")
    assert(toStr(e4) === "undefined")
  }
}

// The next bit of code runs a test for each .jsy file in src/test/resources/lab2.
// The test expects a corresponding .ans file with the expected result.
class Lab2JsyTests extends JavascriptyTester(None, "lab2", Lab2)

class Lab2Suite extends Suites(
  new AndOrSpec,
  new ArithmeticSpec,
  new ComparisonSpec,
  new ConstSpec,
  new IfSpec,
  new SeqSpec,
  new UnarySpec,
  new ToSpec,
  new Lab2JsyTests
)

