package com.example.proyectoandroidv2.data.repository.source.remote

import com.example.proyectoandroidv2.domain.model.Product
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class ProductRepository(val firestore: FirebaseFirestore) {

    private val productsCollection = firestore.collection("products")

    suspend fun getProductById(productId: String?): Product? {
        return productId?.let { productId ->
            try {
                val documentSnapshot = productsCollection.document(productId).get().await()
                documentSnapshot.toObject(Product::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

    }

    fun list(): Flow<List<Product>> {
        return callbackFlow {

            val listener = productsCollection
                .orderBy("nombre", Query.Direction.DESCENDING)
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

    suspend fun update(product: Product) {
        productsCollection.document(product.idSql).update(
            "nombre", product.nombre,
            "numReferencia", product.numReferencia,
            "stock", product.stock,
            "fabricante", product.fabricante,
            "material", product.material,
            "garantia", product.garantia,
            "precio", product.precio,
            "createdAt", product.createdAt
        ).await()
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