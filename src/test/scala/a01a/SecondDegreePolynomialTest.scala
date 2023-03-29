package a01a

import org.junit.Test
import u04lab.code.SecondDegreePolynomial.*
import org.junit.Assert.*
import u04lab.code.SecondDegreePolynomial
class SecondDegreePolynomialTest:

  val simplePolynomial: SecondDegreePolynomial = SecondDegreePolynomial(1.0, 0, 3)
  val anotherPolynomial: SecondDegreePolynomial = SecondDegreePolynomial(0.0, 1, 0.0)
  val fullPolynomial: SecondDegreePolynomial = SecondDegreePolynomial(3.0, 2.0, 5.0)

  @Test def testSum(): Unit =
    val sum = simplePolynomial + anotherPolynomial
    assertEquals((simplePolynomial.constant+anotherPolynomial.constant,
      simplePolynomial.firstDegree+anotherPolynomial.firstDegree,
    simplePolynomial.secondDegree+anotherPolynomial.secondDegree), (sum.constant, sum.firstDegree, sum.secondDegree))

  @Test def testSubtraction(): Unit =
    val sum = simplePolynomial - anotherPolynomial
    assertEquals((simplePolynomial.constant - anotherPolynomial.constant,
      simplePolynomial.firstDegree - anotherPolynomial.firstDegree,
      simplePolynomial.secondDegree - anotherPolynomial.secondDegree), (sum.constant, sum.firstDegree, sum.secondDegree))

  @Test def testMultiOperations(): Unit =
    val multipleOperations = fullPolynomial - (anotherPolynomial + simplePolynomial)
    assertEquals((fullPolynomial.constant - (simplePolynomial.constant + anotherPolynomial.constant),
      fullPolynomial.firstDegree - (simplePolynomial.firstDegree + anotherPolynomial.firstDegree),
      fullPolynomial.secondDegree - (simplePolynomial.secondDegree + anotherPolynomial.secondDegree)),
      (multipleOperations.constant, multipleOperations.firstDegree, multipleOperations.secondDegree))

  @Test def testEquality(): Unit =
    val simpleCopyPolynomial = SecondDegreePolynomial(1.0,0,3)
    assertTrue(simpleCopyPolynomial == simplePolynomial)

