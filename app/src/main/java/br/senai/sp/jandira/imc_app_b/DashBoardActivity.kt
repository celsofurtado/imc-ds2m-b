package br.senai.sp.jandira.imc_app_b

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlin.coroutines.Continuation

class DashBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        carregarDados()

    }

    private fun carregarDados() {
        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)

        tv_nome_perfil.text = dados.getString("nome", "Não encontrado")
        tv_profissao.text = dados.getString("profissao", "Não encontrado")

        tv_peso.text = dados.getFloat("peso", 0.0f).toString()
        tv_idade.text = dados.getInt("idade", 0).toString()
    }
}