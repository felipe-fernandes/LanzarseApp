
@file:kotlin.Suppress(
  "KotlinRedundantDiagnosticSuppress",
  "LocalVariableName",
  "MayBeConstant",
  "RedundantVisibilityModifier",
  "RemoveEmptyClassBody",
  "SpellCheckingInspection",
  "LocalVariableName",
  "unused",
)

package connectors.produtos

import com.google.firebase.dataconnect.getInstance as _fdcGetInstance

public interface ProdutosConnector : com.google.firebase.dataconnect.generated.GeneratedConnector<ProdutosConnector> {
  override val dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect

  
    public val agragetedHouseStock: AgragetedHouseStockQuery
  
    public val createProduto: CreateProdutoMutation
  
    public val distinctProductInfo: DistinctProductInfoQuery
  
    public val listProdutosDisponiveis: ListProdutosDisponiveisQuery
  

  public companion object {
    @Suppress("MemberVisibilityCanBePrivate")
    public val config: com.google.firebase.dataconnect.ConnectorConfig = com.google.firebase.dataconnect.ConnectorConfig(
      connector = "produtos",
      location = "us-central1",
      serviceId = "lanzarseapp",
    )

    public fun getInstance(
      dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect
    ):ProdutosConnector = synchronized(instances) {
      instances.getOrPut(dataConnect) {
        ProdutosConnectorImpl(dataConnect)
      }
    }

    private val instances = java.util.WeakHashMap<com.google.firebase.dataconnect.FirebaseDataConnect, ProdutosConnectorImpl>()
  }
}

public val ProdutosConnector.Companion.instance:ProdutosConnector
  get() = getInstance(com.google.firebase.dataconnect.FirebaseDataConnect._fdcGetInstance(config))

public fun ProdutosConnector.Companion.getInstance(
  settings: com.google.firebase.dataconnect.DataConnectSettings = com.google.firebase.dataconnect.DataConnectSettings()
):ProdutosConnector =
  getInstance(com.google.firebase.dataconnect.FirebaseDataConnect._fdcGetInstance(config, settings))

public fun ProdutosConnector.Companion.getInstance(
  app: com.google.firebase.FirebaseApp,
  settings: com.google.firebase.dataconnect.DataConnectSettings = com.google.firebase.dataconnect.DataConnectSettings()
):ProdutosConnector =
  getInstance(com.google.firebase.dataconnect.FirebaseDataConnect._fdcGetInstance(app, config, settings))

private class ProdutosConnectorImpl(
  override val dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect
) : ProdutosConnector {
  
    override val agragetedHouseStock by lazy(LazyThreadSafetyMode.PUBLICATION) {
      AgragetedHouseStockQueryImpl(this)
    }
  
    override val createProduto by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateProdutoMutationImpl(this)
    }
  
    override val distinctProductInfo by lazy(LazyThreadSafetyMode.PUBLICATION) {
      DistinctProductInfoQueryImpl(this)
    }
  
    override val listProdutosDisponiveis by lazy(LazyThreadSafetyMode.PUBLICATION) {
      ListProdutosDisponiveisQueryImpl(this)
    }
  

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun operations(): List<com.google.firebase.dataconnect.generated.GeneratedOperation<ProdutosConnector, *, *>> =
    queries() + mutations()

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun mutations(): List<com.google.firebase.dataconnect.generated.GeneratedMutation<ProdutosConnector, *, *>> =
    listOf(
      createProduto,
        
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun queries(): List<com.google.firebase.dataconnect.generated.GeneratedQuery<ProdutosConnector, *, *>> =
    listOf(
      agragetedHouseStock,
        distinctProductInfo,
        listProdutosDisponiveis,
        
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun copy(dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect) =
    ProdutosConnectorImpl(dataConnect)

  override fun equals(other: Any?): Boolean =
    other is ProdutosConnectorImpl &&
    other.dataConnect == dataConnect

  override fun hashCode(): Int =
    java.util.Objects.hash(
      "ProdutosConnectorImpl",
      dataConnect,
    )

  override fun toString(): String =
    "ProdutosConnectorImpl(dataConnect=$dataConnect)"
}



private open class ProdutosConnectorGeneratedQueryImpl<Data, Variables>(
  override val connector: ProdutosConnector,
  override val operationName: String,
  override val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data>,
  override val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables>,
) : com.google.firebase.dataconnect.generated.GeneratedQuery<ProdutosConnector, Data, Variables> {

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun copy(
    connector: ProdutosConnector,
    operationName: String,
    dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data>,
    variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables>,
  ) =
    ProdutosConnectorGeneratedQueryImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun <NewVariables> withVariablesSerializer(
    variablesSerializer: kotlinx.serialization.SerializationStrategy<NewVariables>
  ) =
    ProdutosConnectorGeneratedQueryImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun <NewData> withDataDeserializer(
    dataDeserializer: kotlinx.serialization.DeserializationStrategy<NewData>
  ) =
    ProdutosConnectorGeneratedQueryImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  override fun equals(other: Any?): Boolean =
    other is ProdutosConnectorGeneratedQueryImpl<*,*> &&
    other.connector == connector &&
    other.operationName == operationName &&
    other.dataDeserializer == dataDeserializer &&
    other.variablesSerializer == variablesSerializer

  override fun hashCode(): Int =
    java.util.Objects.hash(
      "ProdutosConnectorGeneratedQueryImpl",
      connector, operationName, dataDeserializer, variablesSerializer
    )

  override fun toString(): String =
    "ProdutosConnectorGeneratedQueryImpl(" +
    "operationName=$operationName, " +
    "dataDeserializer=$dataDeserializer, " +
    "variablesSerializer=$variablesSerializer, " +
    "connector=$connector)"
}

private open class ProdutosConnectorGeneratedMutationImpl<Data, Variables>(
  override val connector: ProdutosConnector,
  override val operationName: String,
  override val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data>,
  override val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables>,
) : com.google.firebase.dataconnect.generated.GeneratedMutation<ProdutosConnector, Data, Variables> {

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun copy(
    connector: ProdutosConnector,
    operationName: String,
    dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data>,
    variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables>,
  ) =
    ProdutosConnectorGeneratedMutationImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun <NewVariables> withVariablesSerializer(
    variablesSerializer: kotlinx.serialization.SerializationStrategy<NewVariables>
  ) =
    ProdutosConnectorGeneratedMutationImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun <NewData> withDataDeserializer(
    dataDeserializer: kotlinx.serialization.DeserializationStrategy<NewData>
  ) =
    ProdutosConnectorGeneratedMutationImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  override fun equals(other: Any?): Boolean =
    other is ProdutosConnectorGeneratedMutationImpl<*,*> &&
    other.connector == connector &&
    other.operationName == operationName &&
    other.dataDeserializer == dataDeserializer &&
    other.variablesSerializer == variablesSerializer

  override fun hashCode(): Int =
    java.util.Objects.hash(
      "ProdutosConnectorGeneratedMutationImpl",
      connector, operationName, dataDeserializer, variablesSerializer
    )

  override fun toString(): String =
    "ProdutosConnectorGeneratedMutationImpl(" +
    "operationName=$operationName, " +
    "dataDeserializer=$dataDeserializer, " +
    "variablesSerializer=$variablesSerializer, " +
    "connector=$connector)"
}



private class AgragetedHouseStockQueryImpl(
  connector: ProdutosConnector
):
  AgragetedHouseStockQuery,
  ProdutosConnectorGeneratedQueryImpl<
      AgragetedHouseStockQuery.Data,
      Unit
  >(
    connector,
    AgragetedHouseStockQuery.Companion.operationName,
    AgragetedHouseStockQuery.Companion.dataDeserializer,
    AgragetedHouseStockQuery.Companion.variablesSerializer,
  )


private class CreateProdutoMutationImpl(
  connector: ProdutosConnector
):
  CreateProdutoMutation,
  ProdutosConnectorGeneratedMutationImpl<
      CreateProdutoMutation.Data,
      Unit
  >(
    connector,
    CreateProdutoMutation.Companion.operationName,
    CreateProdutoMutation.Companion.dataDeserializer,
    CreateProdutoMutation.Companion.variablesSerializer,
  )


private class DistinctProductInfoQueryImpl(
  connector: ProdutosConnector
):
  DistinctProductInfoQuery,
  ProdutosConnectorGeneratedQueryImpl<
      DistinctProductInfoQuery.Data,
      Unit
  >(
    connector,
    DistinctProductInfoQuery.Companion.operationName,
    DistinctProductInfoQuery.Companion.dataDeserializer,
    DistinctProductInfoQuery.Companion.variablesSerializer,
  )


private class ListProdutosDisponiveisQueryImpl(
  connector: ProdutosConnector
):
  ListProdutosDisponiveisQuery,
  ProdutosConnectorGeneratedQueryImpl<
      ListProdutosDisponiveisQuery.Data,
      Unit
  >(
    connector,
    ListProdutosDisponiveisQuery.Companion.operationName,
    ListProdutosDisponiveisQuery.Companion.dataDeserializer,
    ListProdutosDisponiveisQuery.Companion.variablesSerializer,
  )



// The lines below are used by the code generator to ensure that this file is deleted if it is no
// longer needed. Any files in this directory that contain the lines below will be deleted by the
// code generator if the file is no longer needed. If, for some reason, you do _not_ want the code
// generator to delete this file, then remove the line below (and this comment too, if you want).

// FIREBASE_DATA_CONNECT_GENERATED_FILE MARKER 42da5e14-69b3-401b-a9f1-e407bee89a78
// FIREBASE_DATA_CONNECT_GENERATED_FILE CONNECTOR produtos
