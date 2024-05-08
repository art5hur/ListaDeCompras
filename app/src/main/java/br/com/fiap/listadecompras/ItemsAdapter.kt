package br.com.fiap.listadecompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
  Cria um adaptador personalizado para a lista de itens na RecyclerView.
 */
class ItemsAdapter :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
/* 
  Cria uma lista de itens a serem exibidos;
  mutableListOf - collection do Kotlin que cria uma lista mutável;
  
*/
    private val items = mutableListOf<ItemModel>()

    /*
      Adiciona um novo item à lista e notifica o RecyclerView para atualizar a exibição.
      newItem: O novo item a ser adicionado à lista.
     */
    
    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }
    /*
      Cria e retorna uma nova instância de ItemViewHolder.
      parent: O ViewGroup pai no qual a nova visualização será anexada após ser associada a uma visualização de adapter.
      viewType: O tipo de visualização do novo item.
      return: Um novo ItemViewHolder contendo a visualização do item.

      LayoutInflater – função do adpter que vai injetar a lista no item_layout e depois no RecycleView;
     */
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    /*
      Vincula os dados do item à visualização representada pelo ViewHolder especificado.
      holder: O ViewHolder que deve ser atualizado para representar o conteúdo do item na posição dada no conjunto de dados.
      position: A posição do item dentro do conjunto de dados.
      
      onBindViewHolder – pega a posição de cada item na lista;
     */
    
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /*
      Retorna o número total de itens na lista.
    */
    override fun getItemCount(): Int = items.size
     /*
       ViewHolder para exibir cada item na RecyclerView.
        
        Todo recyclerview precisa de um objeto chamado viewholder;
        ViewHolder:
            - É o objeto responsável por manipular o conteúdo visual de um item da lista e guardar uma referência da instância
            daquele item.       
     */

     /*
       Constrói um novo ItemViewHolder.
       view: A visualização do item a ser mantida pelo ViewHolder.
       
        Vincula os dados do item à visualização.
        item: O item a ser exibido na visualização.
      */
        
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }

}
