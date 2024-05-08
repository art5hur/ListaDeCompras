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


     É um método de ciclo de vida de uma atividade Android. 
     Ele é chamado quando a atividade é criada.
     Inicializa a interface do usuário e configura o RecyclerView para exibir a lista de produtos.
    

    /*
    --Bundle:
    O Bundle é usado para armazenar e passar dados entre componentes do Android,
    como atividades (Activity), fragmentos (Fragment), serviços (Service), etc.
    O Bundle é frequentemente utilizado para transferir informações entre diferentes partes
    do aplicativo ou entre diferentes atividades. Ele faz isso através da chave e valor;
    
    - Chave: Uma chave é uma string única que identifica um valor dentro do Bundle. É usada
    como um identificador para recuperar o valor correspondente mais tarde. Cada chave em um
    Bundle deve ser única, pois é usada para distinguir entre diferentes valores armazenados no Bundle.

    - Valor: O valor associado a uma chave é o dado real que está sendo armazenado. Este pode ser de 
    qualquer tipo de dado suportado pelo Bundle, incluindo primitivos como inteiros, strings, booleanos,
    bem como objetos serializáveis (reconstruído a partir da sequência de bytes original) e parceláveis
    (conversão do objeto em uma representação de bytes que pode ser transmitida ou armazenada).
     
     */

     /*
       O que é a UI do Android?
       A UI (User Interface, ou Interface do Usuário) do Android é a camada visual e interativa que permite aos usuários 
       interagir com os dispositivos Android, como smartphones e tablets. Ela é responsável por exibir informações na tela,
       receber entrada do usuário e fornecer uma experiência intuitiva e agradável.
    */
    
     /*
       O super.OnCreate(savedInstanceState) chama a implementação do método onCreate() da classe pai (Activity) para garantir que o comportamento padrão seja executado antes de qualquer personalização adicional.

      A função do super.onCreate(savedInstanceState) é permitir que a classe base execute as inicializações necessárias para a atividade, como inflar o layout associado à atividade, restaurar o estado anterior da atividade (se houver) a partir do Bundle fornecido (savedInstanceState), configurar o ambiente de execução da atividade.

     Ao chamar super.onCreate(savedInstanceState), você está garantindo que a classe base tenha a oportunidade de executar seu próprio código de inicialização antes de você adicionar qualquer lógica personalizada. Isso é crucial para garantir o funcionamento adequado da atividade dentro do ciclo de vida do Android e para manter o comportamento consistente em todo o aplicativo.
 
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
        
        /* 
          A função principal do RecyclerView é gerenciar a exibição de uma grande quantidade de itens de dados de maneira eficiente, especialmente quando a lista pode mudar dinamicamente, como ao adicionar ou remover itens. Ele faz isso implementando um padrão de projeto chamado "View Holder" que reutiliza as visualizações de itens que não estão visíveis na tela, reduzindo a sobrecarga de memória e melhorando o desempenho.
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
