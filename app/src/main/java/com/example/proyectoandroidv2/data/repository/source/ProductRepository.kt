package com.example.proyectoandroidv2.data.repository.source

import com.example.proyectoandroidv2.domain.model.Product
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class ProductRepository(val firestore: FirebaseFirestore) {

    private val productsCollection = firestore.collection("products")

    // Obtener un usuario por ID
    suspend fun getProductById(idSql: String): Product? {
        return try {
            val documentSnapshot = productsCollection.document(idSql).get().await()
            documentSnapshot.toObject(Product::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun list(): Flow<List<Product>> {
        // Esta implementación crea un Flow que actualiza la lista de usuarios
        // cada vez que hay un cambio en la base de datos
        return callbackFlow {

            val listener = productsCollection
                // Aquí viene la query,
                // Se ordena por nombre de manera desceniente
                .orderBy("nombre", Query.Direction.DESCENDING)
                // Creamos un listener a la query para que se actualice siempre que haya cambios
                .addSnapshotListener { snapshots, error ->
                    if (error != null) {
                        close(error)
                        return@addSnapshotListener
                    }

                    val items = snapshots?.documents?.mapNotNull { doc ->
                        doc.toObject(Product::class.java)
                    } ?: emptyList()

                    trySend(items)
                }

            awaitClose() { listener.remove() }
        }
    }

    suspend fun addProduct(product: Product): Boolean {
        return try {
            productsCollection.add(product).await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    suspend fun updateProduct(idSql: String, product: Map<String, Any>): Boolean {
        return try {
            productsCollection.document(idSql).update(product).await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    suspend fun deleteProduct(idSql: String): Boolean {
        return try {
            productsCollection.document(idSql).delete().await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

}