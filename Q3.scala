object Q3 extends App {
  var accountList:List[Acc] = List()

  def accCreate(nic:String, accId: Int):Unit = {
    val acc = new Acc(nic, accId)
    accountList = accountList ::: acc :: Nil
    println(accountList)
  }

  val find = (a:Int, b:List[Acc]) => b.filter(account => account.accId.equals(a))

  /*              Driver Code                */

  accCreate("1",1)
  accCreate("2",2)

  //deposit money
  find(1, accountList)(0).deposit(1000)
  println(find(1, accountList)(0))

  //transfer money
  find(1, accountList)(0).transfer(2, 100.0)
  println(find(2, accountList)(0))
}

class Acc(nic:String, val accId: Int, var balance: Double = 0.0){

  def withdraw(amount:Double) : Unit = {
    this.balance = this.balance - amount
  }

  def deposit(amount:Double) : Unit = {
    this.balance = this.balance + amount
  }

  def transfer(account:Int, amount:Double) : Unit = {
    val transferAcc = Q3.find(account, Q3.accountList)
    if (balance < 0.0) println("Insufficient balance")
    else {
      this.withdraw(amount)
      transferAcc(0).deposit(amount)
    }
  }

  override def toString = "["+nic+":"+accId +":"+ balance+"]"
}