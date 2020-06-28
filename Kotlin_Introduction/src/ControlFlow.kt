fun main(args: Array<String>) {

    var age = 60

    print(isEligibleForVoting(age.toInt()))
}

fun isEligibleForVoting(age:Int) : String{

    when (age){

        in 1..17 -> return "Not Eligible"

        in 18..60 -> return "Eligible and not a senior citizen"

        else -> return "Eligible and senior citizen"
    }
}