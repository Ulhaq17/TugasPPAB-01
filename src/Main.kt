// Nama : Mochammad Dhiya Ulhaq
// NIM  : L0122095

fun main() {
    print("Aplikasi Penghitung Nilai IP\n")
    val rawString = """Aplikasi ini memungkinkan Anda untuk melakukan perhitungan total nilai IP"""
    println(rawString)
    println("-------------------------------")
    print("Masukkan nama Anda: ")
    val namaMahasiswa = readln()
    print("Masukkan NIM Anda: ")
    val nimMahasiswa = readln()

    menyapa(namaMahasiswa, nimMahasiswa)

    print("Masukkan jumlah mata kuliah: ")
    val inputJumlahMatakuliah = readlnOrNull()
    val jumlahMatakuliah = inputJumlahMatakuliah?.toIntOrNull()

    if (jumlahMatakuliah == null || jumlahMatakuliah <= 0) {
        println("Jumlah mata kuliah $jumlahMatakuliah atau tidak valid")
        return
    }

    val namaMatakuliahArray = Array(jumlahMatakuliah) { "" }
    val nilaiMatakuliahArray = Array<Float?>(jumlahMatakuliah) { null }
    val sksMatakuliahArray = Array<Int?>(jumlahMatakuliah) { null }

    for (i in 0..< jumlahMatakuliah) {
        print("Masukkan nama mata kuliah ke-${i + 1}: ")
        namaMatakuliahArray[i] = readlnOrNull() ?: ""

        print("Masukkan SKS mata kuliah ke-${i + 1}: ")
        val inputSksMatakuliah = readlnOrNull()
        sksMatakuliahArray[i] = inputSksMatakuliah?.toIntOrNull()

        if (sksMatakuliahArray[i] == null || sksMatakuliahArray[i]!! <= 0) {
            println("SKS mata kuliah tidak valid")
            return
        }

        print("Masukkan nilai mata kuliah ke-${i + 1}: ")
        val inputNilaiMatakuliah = readlnOrNull()
        nilaiMatakuliahArray[i] = inputNilaiMatakuliah?.toFloatOrNull()

        if (nilaiMatakuliahArray[i] == null || nilaiMatakuliahArray[i]!! < 0 || nilaiMatakuliahArray[i]!! > 4) {
            println("Nilai mata kuliah tidak valid")
            return
        }
    }

    var totalIP = 0.0F
    var iP: Float

    for (i in 0..< jumlahMatakuliah) {
        val sks = sksMatakuliahArray[i]!!
        val nilai = nilaiMatakuliahArray[i]!!

        iP = sks * nilai
        totalIP += iP
    }

    val totalSKS = menghitungSKS(*sksMatakuliahArray.filterNotNull().toIntArray())
    val ips : Float = totalIP / totalSKS
    println("Jumlah SKS mata kuliah yang Anda ambil: $totalSKS")
    println("Indeks Prestasi Semester (IPS) Anda: $ips")
}

fun menyapa(namaMahasiswa: String, nimMahasiswa: String){
    println("Halo! $namaMahasiswa dengan NIM ($nimMahasiswa)")
}

fun menghitungSKS(vararg sksMatakuliah: Int): Int {
    var total = 0
    for (sks in sksMatakuliah) {
        total += sks
    }
    return total
}