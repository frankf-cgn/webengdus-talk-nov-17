package webengdus.shopservice

import java.io.Serializable
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Transient

@Entity
@Table
data class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var sku: Long? = null,
        @Column var productName: String? = null,
        @Column var productDescription: String? = null,
        @Column var price: Double? = null,
        @Column var stock: Int = 0,
        @Transient var soldOverTime: Int = 0,
        @Transient var otherPeopleBought: Set<Product> = setOf()) : Serializable

data class AnalyticsRecord(
        val sessionId: String,
        val skuPurchased: Long,
        val recordedAt: Long = Instant.now().toEpochMilli()) : Serializable