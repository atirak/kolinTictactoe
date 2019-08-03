package tictactoe


var arrOX = arrayOf(
    arrayOf(' ', '1', '2', '3'),
    arrayOf('1', '-', '-', '-'),
    arrayOf('2', '-', '-', '-'),
    arrayOf('3', '-', '-', '-')
)
var player = 'X'
var flag = true
var round = 0
fun main() {

    showWelcome()
    showTable()
    while (flag) {
        showTurn(round)
        try{
            val str = readLine()
            val splitStr = str?.split(" ")
            if(splitStr?.size != 2){
                println("try again")
                continue
            }
            val row = splitStr?.get(0)?.toInt()
            val col = splitStr?.get(1)?.toInt()
            if(setTable(row, col, player)){
                continue
            }else{
                showTable()
                checkAll()
                round++

            }

        }catch(t:Throwable) {
        }

    }
}
fun checkAll() {
    checkHorizantal(player)
    checkVertical(player)
    chcekDiagonal(player)
    checkIsDraw(round)
}
fun showWelcome() {
    println("Welcome to TicTacToe")
}

fun showTurn(round: Int) {
    if (round % 2 == 0) {
        player = 'X'
        println("X turn")
        print("Please input Row Col: ")
    } else {
        player = 'O'
        println("O turn")
        print("Please input Row Col: ")
    }
}

fun setTable(row: Int, col: Int, player: Char):Boolean {
    try {
        if (arrOX[row][col] === '-') {
            arrOX[row][col] = player
            return false
        } else {
            println("try agian")
            return true
        }
        return true
    } catch (e: Throwable) {
        println("try agian")
        return true

    }
}

fun showTable() {
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            print(" ${arrOX[i][j]}")
        }
        println()
    }
}

fun checkHorizantal(player: Char) {
    var count = 0;
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            if (arrOX[i][j] === player) {
                count++;
            }
        }
        if (count === 3) {
            flag = false;
            println("${player} WIN ")
        }
        count = 0;
    }
}

fun checkVertical(player: Char) {
    var count = 0;
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            if (arrOX[j][i] === player) {
                count++;
            }
        }
        if (count === 3) {
            flag = false;
            println("${player} WIN ")
        }
        count = 0;
    }
}

fun chcekDiagonal(player: Char) {
    if (arrOX[1][1] === player && arrOX[2][2] === player && arrOX[3][3] === player) {
        println("${player} WIN ")
        flag = false;
    } else if (arrOX[1][3] === player && arrOX[2][2] === player && arrOX[3][1] === player) {
        println("${player} WIN ")
        flag = false;
    }
}

fun checkIsDraw(round: Int) {
    if (round == 8 && flag) {
        println("DRAW")
        flag = false
    }
}
