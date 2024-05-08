package br.com.fiap.listadecompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.listadecompras.ui.theme.ListaDeComprasTheme

/*
  MainActivity é a atividade principal que controla a interface do usuário da lista de compras.
  É uma subclasse de ComponentActivity, que é uma classe base para todas as atividades no Android.
 */
class MainActivity : ComponentActivity() {
    /*
    A anotação @SuppressLint("missinginflatedid") em Android é usada para suprimir avisos de compilação 
    relacionados à falta de um ID inflado em um layout XML. O Android Studio pode gerar esse aviso quando 
    você infla um layout sem atribuir um ID a uma vista específica no XML.

    A anotação está sendo utilizada, pois tem um motivo válido para não atribuir um ID à vista, sendo assim 
    está suprimindo o aviso de compilação associado a isso. É importante tomar cuidado ao usar, para garantir
    que não esteja ignorando problemas importantes no código.
    */
    @SuppressLint("MissingInflatedId")

    /*
      onCreate(Bundle savedInstanceState):
      Método chamado quando a atividade está sendo criada.
      
      Dados fornecidos para a atividade quando foi reconstruída a partir de um estado anterior,
      caso exista. Caso contrário, é nulo.
      
      É onde ocorre a inicialização básica da atividade, como inflar o layout da IU (interface do usuário), associar 
      componentes da IU com variáveis Java e definir ouvintes de eventos.
     */

     /*
       O que é a UI do Android?
       A UI (User Interface, ou Interface do Usuário) do Android é a camada visual e interativa que permite aos usuários 
       interagir com os dispositivos Android, como smartphones e tablets. Ela é responsável por exibir informações na tela,
       receber entrada do usuário e fornecer uma experiência intuitiva e agradável.
    */
    
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
          setContentView(R.layout.activity_main): 
          Define o layout da atividade com base no arquivo XML activity_main.
        */
        
        setContentView(R.layout.activity_main)
        /*
            findViewById(R.id.recyclerView): 
            Encontra o RecyclerView no layout da atividade para exibir a lista de itens.
        */
        
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
         
        val itemsAdapter = ItemsAdapter()
        /*
          RecyclerView.setAdapter(itemsAdapter): 
          Define o adaptador (ItemsAdapter) para o RecyclerView, que gerencia a exibição dos itens na lista.
        */
        
        recyclerView.adapter = itemsAdapter
          
    /*
      O Adapter é o responsável por gerenciar a criação da lista, a exibição dos itens, e também é responsável por definir o layout 
      que será utilizado nos itens da lista;
      Portanto, ele não precisa saber como seus itens internos estão sendo montados e nem do layout que estão sendo utilizados;
    */
          
    /*
        findViewById(R.id.button) e findViewById(R.id.editText): 
        Encontra o botão e a caixa de texto no layout da atividade para adicionar novos itens à lista.      
    */
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        /*
            button.setOnClickListener: 
            Define um ouvinte de clique para o botão, fica aguardando ser apertado. Quando o botão é clicado, 
            o código dentro do bloco é executado.
        */

        
        button.setOnClickListener {
            //Cria um novo objeto ItemModel com o texto fornecido.
            val item = ItemModel(
                /*
                  editText.getText().toString(): 
                  Obtém o texto da caixa de texto e o converte em uma string.
                */
                name = editText.text.toString()
            )
            
            /*
            itemsAdapter.addItem(item): 
            Adiciona o item ao adaptador da lista de itens, atualizando assim a exibição na tela.
            */
            
            itemsAdapter.addItem(item)

        }
    }
}
