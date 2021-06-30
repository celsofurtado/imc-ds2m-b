package br.senai.sp.jandira.imc_app_b

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_criar_conta.setOnClickListener {
            val intent = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(intent)
        }

        button_entrar.setOnClickListener {
            login()
        }

    }

    private fun login() {
        val login = edit_text_user.text.toString()
        val senha = edit_text_password.text.toString()

        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)

        val loginGravada = dados.getString("email", "Não existe")
        val senhaGravada = dados.getString("senha", "Não existe")

        if (login == loginGravada && senha == senhaGravada) {
            val intent = Intent(this, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show()
        }
    }
}