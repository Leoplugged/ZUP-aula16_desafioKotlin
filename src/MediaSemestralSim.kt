package br.catalisa.com
import kotlin.system.exitProcess

//Programa para cálculo da Média Semestral do Aluno da SimCity
//Pendências: 1. tratar o NFE na notasAlune() -> Linhas 33 a 39; 2. arredondar notas

fun main() {
    menu()
    notasAlune()
}

fun menu() {
    print("\n------------------------------------\n#===MÉDIA SEMESTRAL DE ALUNE SIM===#\n------------------------------------\n| COMANDO |       DESCRIÇÃO        |\n------------------------------------\n|    1    | CALCULAR MÉDIA NOVA    |\n|    2    | SAIR DA CALCULADORA    |\n------------------------------------\nObs.: Digite um dos comandos acima: ")
    val comando = readln().toIntOrNull()
    selecao(comando)
}

fun selecao(comando: Int?) {
    when(comando) {
        1 -> {notasAlune()
            menu()}
        2 -> {print("#  Saindo do programa. À Bientôt!  #")
            exitProcess(0)}
        else -> {println("\n-> Comando não válido! Tente de novo. <-\n")
            menu()}
    }
}

fun notasAlune() {
    println("\n\n#======== Notas de Alune Sim =======#\n#  Digite as notas conforme seguem  #")
    val notas = DoubleArray(size = 4)
    for(cont in 1..4) {
    //  try{ -> Tentativa
        print("# ${cont}a nota: ")
        notas[cont-1] = readln().toDouble()
        while (notas[cont - 1] !in 0.0..10.0) {
            print("# Nota não válida; digite entre 0.0 a 10.0.\n# ${cont}a nota: ")
            notas[cont - 1] = readln().toDouble()
    //  }catch(NumberFormatException NFE) { -> Tentativa
        }
    }
    val mediaNotas = calcularMedia(notas)
    println("#A Média Semestral de Alune Sim é $mediaNotas.#")
}

fun calcularMedia(notas: DoubleArray): Double {
    var somaNotas = 0.0
    for (cont in notas.indices) {
        somaNotas += notas[cont]
    }
    return somaNotas / 4
}