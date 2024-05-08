package br.com.fiap.listadecompras
/*
  Um classe modelo de dados para representar um item na lista de compras.
 */

//data - Ao colocar o “data” o Kotlin entende que é uma modelagem de BD;

/*
  Constrói um novo ItemModel
     name: O nome do item.
*/
data class ItemModel(val name: String)
