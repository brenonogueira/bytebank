fun main(args: Array<String>) {

    var contaBreno = Conta("Breno Nogueira Araújo", 23)
    contaBreno.depositar(210.0)

    contaBreno.depositar(25.0)
    println("saldo atual após depósito ${contaBreno.titular}: ${contaBreno.saldo}")

    contaBreno.sacar(30.0)
    println("saldo atual após saque ${contaBreno.titular}: ${contaBreno.saldo}")

    var contaDebora = Conta("Debora Michely", 15)
    contaDebora.depositar(200.0)

    contaDebora.depositar(10.0)
    println("saldo atual após depósito ${contaDebora.titular}: ${contaDebora.saldo}")

    contaDebora.sacar(100.0)
    println("saldo atual após saque ${contaDebora.titular}: ${contaDebora.saldo}")

    println("transferindo de breno pra debora")
    if (contaBreno.transferir(120.0, contaDebora)) {
        println("Transferencia concluída")
    } else {
        println("Transferencia não ocorrida")
    }

    println("saldo atual após transferencia ${contaBreno.titular}: ${contaBreno.saldo}")

    println("saldo atual após transferencia ${contaDebora.titular}: ${contaDebora.saldo}")
}

class Conta(val titular: String, val numero: Int) {
    var saldo = 0.0
        private set

//    constructor(titular: String, numero: Int) {
//        this.titular = titular
//        this.numero = numero
//    }

    fun depositar(valor: Double) {
        this.saldo += valor
    }

    fun sacar(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        }
    }

    fun transferir(valor: Double, destino: Conta): Boolean {
        if (this.saldo >= valor) {
            saldo -= valor
            destino.depositar(valor)
            return true
        }
        return false
    }

//    fun getSaldo(): Double {
//        return this.saldo
//    }
//
//    fun setSaldo(valor: Double) {
//        if (valor > 0){
//            this.saldo = valor
//        }
//    }
}


//fun testaCondicoes(saldo: Double) {
//    //equivale ao if else e parece o switch case
//    when {
//        saldo > 0.0 -> println("conta positiva")
//        saldo == 0.0 -> print("conta neutra")
//        else -> println("conta negativa")
//    }
//}
