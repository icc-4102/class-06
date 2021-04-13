# Clase 05

En esta clase se ve lo que puede hacer un intent y como pasar datos de un intent a otra. Es importante considerar que para pasar objeto tiene que se capaz de ser objetos parceables. 

Para parcear un objeto tiene que verse como este:

```kotlin
@Parcelize
data class User(val name: String, val lastName: String): Parcelable
```

Para esto tenemos que estar seguro que se agrego `id 'kotlin-parcelize'` dentro del `build.gradle` 

    ## **En clases se vio como nulo el objeto entregado por el intent, 
    pero resulta que el decode se crea un objeto nulo ya que en ` dataJson` recover se define como nulo** 
