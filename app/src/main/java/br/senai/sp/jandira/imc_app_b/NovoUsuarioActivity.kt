package br.senai.sp.jandira.imc_app_b

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_novo_usuario.*

class NovoUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        bt_gravar.setOnClickListener {
            gravarUsuario()
        }

    }

    private fun gravarUsuario() {

        // *** Criar/Abrir o arquivo de dados do usuário
        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)

        // *** Criar o objeto que permitirá a edição do arquivo (inserir, alterar dados dentro do arquivo)
        val editor = dados.edit()

        // *** Inserir os dados no arquivo
        editor.putString("nome", et_nome.text.toString())
        editor.putString("profissao", et_profissao.text.toString())
        editor.putString("email", et_email.text.toString())
        editor.putString("senha", et_senha.text.toString())
        editor.putFloat("peso", et_peso.text.toString().toFloat())
        editor.putInt("idade", et_idade.text.toString().toInt())
        editor.apply()

        Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_SHORT).show()
        finish()

    }
}