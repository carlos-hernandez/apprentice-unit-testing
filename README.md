# Apprentice CDMX - Unit Testing

## JUnit

[JUnit](http://junit.org/junit4/) es un framework que utiliza anotaciones para identificar métodos que especifican una prueba.

### ¿Cómo se define una prueba con JUnit?

Una prueba de JUnit es un método contenido en una clase que sólo se utiliza para pruebas, comúnmente conocida como una **clase de pruebas**. Para definir que un método es un método de prueba se marcan con la anotación `@Test`.

Este método ejecuta el código bajo prueba. Se utilizan métodos de afirmación (**asserts**), proporcionados por JUnit u otro framework, para comparar un resultado esperado contra un resultado real.

A continuación se listan algunas de las anotaciones más importantes de JUnit para la versión 4.x:

JUnit 4 | Descripción
------- | -----------
`import org.junit.*` | Sentencia `import` para usar las siguientes anotaciones
`@Test` | Identifica un método como un método de prueba
`@Before` | Método que se ejecuta **antes de cada prueba**. Se utiliza para preparar el ambiente de pruebas (leer o definir datos de entrada)
`@After` | Método que se ejecuta **después de cada prueba**. Se utiliza para limpiar el ambiente de pruebas (eliminar datos temporales, restablecer configuraciones por defecto)
`@BeforeClass` | Método que se ejecuta **una sola vez antes de que comience la ejecución de todas las pruebas**. Los métodos marcados con esta anotación necesitan ser definidos como `static`.
`@AfterClass` | Método que se ejecuta **una sola vez después de que todas las pruebas han finalizado**. Los métodos marcados con esta anotación necesitan ser definidos como `static`.
`@Ignore` o `@Ignore("Why disabled")` | Marca una prueba como inactiva. Es útil cuando el código relacionado ha sido modificado y la prueba aún no ha sido adaptada a esos cambios, o si tarda demasiado tiempo en ejecutarse como para ser incluida. Se recomienda incluir una descripción para saber la razón por la cual la prueba es ignorada.
`@Test(expected = Exception.class)` | La prueba falla si el método no lanza la excepción especificada.
`@Test(timeout=100)` | La prueba falla si el método tarda más de 100 milisegundos en ejecutarse.

### Ejemplo 01: Primera prueba con JUnit

Revisa el código de la clase `CalculatorTests` dentro del paquete `com.nearsoft.apprentice.testing.basics` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=CalculatorTests test
```

### Ejemplo 02: Anotaciones básicas

Revisa el código de la clase `FixturesTests` dentro del paquete `com.nearsoft.apprentice.testing.basics`. Ejecuta la prueba desde la línea de comandos y analiza la salida en consola:

```bash
./mvnw -Dtest=FixturesTests test
```

### Ejemplo 03: Ignorando pruebas

Revisa el código de la clase `IgnoredTests` dentro del paquete `com.nearsoft.apprentice.testing.ignore` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=IgnoredTests test
```

### Ejemplo 04: Verificando excepciones

Revisa el código de la clase `ExceptionTests` dentro del paquete `com.nearsoft.apprentice.testing.exceptions` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=ExceptionTests test
```

A continuación, revisa el código de la clase `ExceptionRuleTests` dentro del paquete `com.nearsoft.apprentice.testing.exceptions` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=ExceptionRuleTests test
```

¿Qué diferencias encuentras entre las distintas maneras de verificar excepciones?

### Ejemplo 05: Especificando timeouts para nuestras pruebas

Revisa el código de la clase `TimeoutTests` dentro del paquete `com.nearsoft.apprentice.testing.timeout` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=TimeoutTests test
```

A continuación, revisa el código de la clase `TimeoutRuleTests` dentro del paquete `com.nearsoft.apprentice.testing.timeout` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=TimeoutRuleTests test
```

¿Qué diferencias encuentras respecto a las pruebas que has ejecutado anteriormente?

## Hamcrest matchers

[Hamcrest](https://github.com/hamcrest/JavaHamcrest) es una librería de verificación que se utiliza para crear expresiones flexibles para indicar nuestras expectativas dentro de una prueba.

A continuación se muestran algunos de los matchers más importantes que tenemos a nuestra disposición con Hamcrest:

* Core
  - `anything` - Siempre hace una coincidencia no importando cual sea el objeto que estemos verificando
  - `describedAs` - Decorator para agregar un mensaje específico de fallo
  - `is` - Decorator para mejorar la lectura del código
* Lógicos
  - `allOf` - Encuentra una coincidencia si todos los matchers definidos encuentran alguna (Java &&)
  - `anyOf` - Encuentra una coincidencia si cualquiera de los matchers definidos encuentra alguna (Java ||)
  - `not` - Encuentra una coincidencia si el matcher asociado no encuentra alguna y viceversa (Java !)
* Objetos
  - `equalTo` - Verifica la igualdad entre objetos usando `Object.equals`
  - `instanceOf`, `isCompatibleType` - Verificación de tipos
  - `notNullValue`, `nullValue` - Verificaciones para valores nulos
  - `sameInstance` - Verifica la identidad de un objeto
* Colecciones
  - `hasEntry`, `hasKey`, `hasValue` - Verifica si un mapa contiene una entrada, llave o valor
  - `hasItem`, `hasItems` - Verifica si una colección contiene elementos
  - `hasItemInArray` - Verifica si un arreglo contiene un elemento
* Números
  - `closeTo` - Verifica si el valor de un número de punto flotante es aproximado a un valor específico
  - `greaterThan`, `greaterThanOrEqualTo`, `lessThan`, `lessThanOrEqualTo` - Comparaciones entre números
* Texto
  - `equalToIgnoringCase` - Verifica la igualdad entre cadenas sin importar su case (mayúsculas y minúsculas)
  - `equalToIgnoringWhiteSpace` - Verifica la igualdad entre cadenas ignorando espacios en blanco
  - `containsString`, `endsWith`, `startsWith` - Verificaciones para saber si una cadena contiene otra subcadena

### Ejemplo 06: Asserts dentro de una prueba

Revisa el código de la clase `JUnitAssertTests` dentro del paquete `com.nearsoft.apprentice.testing.asserts` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=JUnitAssertTests test
```

A continuación, revisa el código de la clase `HamcrestAssertTests` dentro del paquete `com.nearsoft.apprentice.testing.asserts` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=HamcrestAssertTests test
```

Compara la forma en que se escriben los asserts usando los métodos por defecto que nos provee JUnit contra los que Hamcrest nos ofrece.

## Ejercicios - Parte 1

El siguiente listado contiene especificaciones simples que pueden convertirse fácilmente en métodos de prueba. Utiliza JUnit y Hamcrest para crear el código necesario para verificar cada una de ellas.

- Objetos
  1. Crea un objeto y verifica que no sea nulo y que su tipo sea de una clase específica.
  1. Crea un objeto y asígnalo a dos variables diferentes. Verifica que ambas variables hagan referencia a la misma instancia.
- Texto
  1. Define una cadena y verifica que no sea nula o vacía.
  1. Crea dos cadenas con el mismo contenido. Agrega espacios en blanco al final de una de ellas y verifica que ambas son iguales si se ignoran esos espacios.
  1. Crea dos cadenas con el mismo contenido. Escribe una de ellas en mayúsculas y la otra en minúsculas. Verifica que ambas son iguales, ignorando mayúsculas y minúsculas
  1. Crea una cadena que contenga un saludo dirigido a ti (ejemplo: `Hola, Juan. ¿Cómo estás?`). Verifica que dicha cadena comience con `Hola` y contiene tu nombre.
- Listas
  1. Crea una lista con 5 elementos y verifica su tamaño.
  1. Crea una lista con 5 elementos distintos. Verifica que dicha lista contenga exactamente esos elementos sin importar el orden en el que se encuentren.
  1. Crea una lista con 5 elementos distintos. Verifica que dicha lista contiene dos elementos en particular.
- Números
  1. Crea una lista con los números del 5 al 10. Verifica que todos los elementos son mayores o iguales a 5.
  1. Crea una lista con los números del 1 al 5. Verifica que todos los valores son menores a 10.
- Mapas
  1. Crea un mapa con 3 entradas. Verifica que el mapa contiene una llave en particular.
  1. Crea un mapa con 3 entradas. Verifica que el mapa contiene un valor en específico.

---

## Uso de mocks dentro de nuestras pruebas

Una prueba unitaria debe funcionar de manera aislada. Para ello nos valemos de algunos frameworks que nos permiten crear reemplazos (**test doubles**) de las dependencias reales del componente que estamos probando.

[Mockito](http://site.mockito.org/) es uno de los frameworks que podemos usar dentro de JUnit para crear test doubles y usarlos dentro de nuestras pruebas.

### Ejemplo 07: Mockito - Verificaciones

Revisa el código de la clase `MockitoVerificationTests` dentro del paquete `com.nearsoft.apprentice.testing.mocks` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=MockitoVerificationTests test
```

Mientras revisas el código, presta atención a:
- Cómo se define un mock usando la anotación `@Mock`
- Cómo es usado el método `Mockito.verify` para verificar las interacciones dentro de un mock en sus distintas variantes:
  - `verify(mock)`
  - `verify(mock, times(1))`, `verify(mock, never())`
  - `verifyZeroInteractions(mock)`, `verifyNoMoreInteractions(mock)`
  - `verify(mock, atLeast(1))`, `verify(mock, atMost(1))`

### Ejemplo 08: Mockito - Definir comportamiento

Revisa el código de la clase `MockitoBehaviourTests` dentro del paquete `com.nearsoft.apprentice.testing.mocks` y ejecuta la prueba desde la línea de comandos:

```bash
./mvnw -Dtest=MockitoBehaviourTests test
```

Mientras revisas el código, presta atención a:
- Cómo se define el valor de retorno al invocar un método de un mock usando `when(mock)`/`thenReturn(value)` y su variante `doReturn(value)`/`when(mock)`
- Cómo se lanza una excepción al invocar un método de un mock usando `when(mock)`/`thenThrow(exception)` y su variante `doThrow(exception)`/`when(mock)`
- Cómo se define un espía usando la anotación `@Mock`

## Ejercicios - Parte 2

Dentro del paquete `com.nearsoft.apprentice.testing.login` se encuentran algunas clases que simulan un flujo muy básico para realizar el login de un usuario. Revisa el código y crea métodos de prueba que verifiquen que la clase `LoginController` cumple con los siguientes escenarios:

1. Se intenta hacer login con un valor nulo. Verificar que el servicio no recibe llamada alguna.
1. Cuando el login de un usuario es exitoso verificar que:
  - La respuesta recibida es `OK`.
  - El método `login()` del servicio es invocado con el usuario recibido desde el controller.
  - El método `setCurrentUser()` del servicio es invocado usando el nombre de usuario especificado en el formulario.
1. Cuando el login de un usuario es inválido verificar que:
  - La respuesta recibida es `KO`.
  - El método `login()` del servicio es invocado con el usuario recibido desde el controller.
  - Verificar que no haya más interacciones con el servicio.
1. Cuando ocurre un error durante el login de un usuario verificar que:
  - La respuesta recibida es `ERROR`.
  - El método `login()` del servicio es invocado con el usuario recibido desde el controller.
  - Verificar que no haya más interacciones con el servicio.
1. Verificar nuevamente el escenario en el que el login de un usuario es exitoso usando la implementación real del servicio en lugar de un mock.
  - **Tip**: Si se usa la implementación real del servicio éste intentará hacer una llamada al repositorio. Se debe especificar cuál será su respuesta para permitir que el login sea exitoso.

La configuración básica para estas pruebas la puedes encontrar en la clase `LoginControllerTests`.
