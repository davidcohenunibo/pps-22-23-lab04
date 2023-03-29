package u04lab.code

// Express a second degree polynomial
// Structure: secondDegree * X^2 + firstDegree * X + constant
trait SecondDegreePolynomial:
  def constant: Double
  def firstDegree: Double
  def secondDegree: Double
  def +(polynomial: SecondDegreePolynomial): SecondDegreePolynomial
  def -(polynomial: SecondDegreePolynomial): SecondDegreePolynomial


object SecondDegreePolynomial:
  def apply(secondDegree: Double, firstDegree: Double, constant: Double): SecondDegreePolynomial =
    SecondDegreePolynomialImpl(secondDegree, firstDegree, constant)

private case class SecondDegreePolynomialImpl(
                                _secondDegree: Double,
                                _firstDegree: Double,
                                _constant: Double
                                ) extends SecondDegreePolynomial:
  override def constant: Double = _constant
  override def firstDegree: Double = _firstDegree
  override def secondDegree: Double = _secondDegree
  override def +(polynomial: SecondDegreePolynomial): SecondDegreePolynomial =
    SecondDegreePolynomialImpl(
      _secondDegree + polynomial.secondDegree,
      _firstDegree + polynomial.firstDegree,
      _constant + polynomial.constant
    )
  override def -(polynomial: SecondDegreePolynomial): SecondDegreePolynomial =
    SecondDegreePolynomialImpl(
      _secondDegree - polynomial.secondDegree,
      _firstDegree - polynomial.firstDegree,
      _constant - polynomial.constant,
    )


