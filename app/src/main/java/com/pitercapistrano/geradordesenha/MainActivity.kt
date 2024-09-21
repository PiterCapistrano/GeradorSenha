package com.pitercapistrano.geradordesenha

// Importações necessárias para o funcionamento do código
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge // Habilita o suporte a telas de borda a borda
import androidx.appcompat.app.AppCompatActivity // Base para atividades que utilizam a action bar
import androidx.core.view.ViewCompat // Facilita o trabalho com visões (Views)
import androidx.core.view.WindowInsetsCompat // Para manipular margens e preenchimentos de janelas
import com.pitercapistrano.geradordesenha.databinding.ActivityMainBinding // Importa o layout associado com a Activity
import kotlin.random.Random // Biblioteca para gerar números aleatórios
import kotlin.random.nextInt // Extensão para definir intervalos para números aleatórios

// Classe principal da Activity
class MainActivity : AppCompatActivity() {

    // Declaração de uma variável para fazer o binding (vinculação) do layout com a Activity
    private lateinit var binding: ActivityMainBinding

    // Array contendo o alfabeto de A a Z
    private val alfabeto = arrayOf("A","B","C","D","E","F","G","H","I","J","K","L","M",
        "N","O","P","Q","R","S","T","U","V","W","X","Y","Z")

    // Função que é chamada ao iniciar a Activity
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita a interface para telas de borda a borda
        enableEdgeToEdge()

        // Infla (carrega) o layout e associa a variável 'binding' ao layout XML
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Define o layout associado a esta Activity
        setContentView(binding.root)

        // Ajusta os preenchimentos (padding) da visualização principal para se adaptar às barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Obtém as margens do sistema (como barra de status e navegação)
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Aplica essas margens como preenchimento na visualização
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Esconde a action bar (barra superior da aplicação)
        supportActionBar?.hide()

        // Define o comportamento do botão 'Gerar Senha' quando clicado
        binding.btGerarSenha.setOnClickListener {
            // Seleciona aleatoriamente duas letras do alfabeto
            val letraAleatoria1 = alfabeto.random()
            val letraAleatoria2 = alfabeto.random()

            // Gera um número aleatório entre 1000 e 9999
            val numero = Random.nextInt(1000..9999)

            // Define o texto da senha no campo de texto como: duas letras aleatórias + um hífen + número aleatório
            binding.txtSenha.text = "$letraAleatoria1$letraAleatoria2-$numero"
        }
    }
}
