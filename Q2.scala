object Q2 extends App {
  val x = new rational(3,4)
  val y = new rational(5,8)
  val z = new rational(2,7)

  val a = x-y-z

  println(a)
}

class rational(n:Int, d:Int) {
  require(denom > 0, "Denominator must be greater than 0")
  def numer = n
  def denom = d
  def neg = new rational(-this.numer, this.denom)
  def add(r:rational) = new rational(this.numer*r.denom + this.denom*r.numer, this.denom*r.denom)
  def -(r:rational) = this.add(r.neg)

  override def toString(): String = numer + "/" + denom
}