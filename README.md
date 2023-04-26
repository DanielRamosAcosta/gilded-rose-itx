# Gilded Rose Kata

Bienvenidos y bienvenidas al equipo de **Gilded Rose**.
Como quizá sabes, somos una pequeña posada ubicada estratégicamente en una prestigiosa ciudad, atendida por la amable **Allison**.
También compramos y vendemos mercadería de alta calidad.
Por desgracia, nuestra mercadería va bajando de calidad a medida que se aproxima la fecha de venta.

Tenemos un sistema instalado que actualiza automáticamente el `inventario`.
Este sistema fue desarrollado por un muchacho con poco sentido común llamado Leeroy, que ahora se dedica a nuevas aventuras.
Nos han concedido un breve tiempo para poder mejorar el código que ha dejado Leeroy, nuestra tarea consitirá en dejar el código algo mejor que como nos lo hemos encontrado.

## Descripción preliminar

Pero primero, vamos a introducir el sistema:

- Todos los artículos (`Item`) tienen una propiedad `sellIn` que denota el número de días que tenemos para venderlo
- Todos los artículos tienen una propiedad `quality` que denota cúan valioso es el artículo
- Al final de cada día, nuestro sistema decrementa ambos valores para cada artículo mediante el método `updateQuality`

Bastante simple, ¿no? Bueno, ahora es donde se pone interesante:

- Una vez que ha pasado la fecha recomendada de venta, la `quality` se degrada al doble de velocidad
- La `quality` de un artículo nunca es negativa
- El "Queso Brie envejecido" (`Aged brie`) incrementa su `quality` a medida que se pone viejo
  - Su `quality` aumenta en `1` unidad cada día
  - luego de la fecha de venta (`sellIn`) su `quality` aumenta `2` unidades por día
- La `quality` de un artículo nunca es mayor a `50`
- El artículo "Sulfuras" (`Sulfuras`), siendo un artículo legendario, no modifica su `sellIn` ni se degrada en `quality`
- Una "Entrada al Backstage", como el queso brie, incrementa su `quality` a medida que la fecha de venta (`sellIn`) se aproxima
  - si faltan 10 días o menos para el concierto, la `quality` se incrementa en `2` unidades
  - si faltan 5 días o menos, la `quality` se incrementa en `3` unidades
  - luego de la fecha de venta (`sellIn`) la `quality` cae a `0`

## Notas finales

Para aclarar: un artículo nunca puede tener una `quality` superior a `50`, sin embargo las Sulfuras siendo un artículo legendario posee una calidad inmutable de `80`.
