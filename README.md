# Convertidor de Moneda

El presente proyecto  brinda la funcionalidad para realizar conversiones de valores a los siguientes  tipos de monedas
 - USD (Dolares)
 - AED (UAE Dirham) que es De los Emiratos Arabes Unidos
 - COP (Peso colombiano)

 Adicional, puede generar el historial de conversiones que se han realizado durante la sesion.



 ## Desarrollo

 El proyecto se encuentra desarrollado con Java 17, utiliza la libreria Gson para transformar los JSON en objetos e internamente consume un servicio utilizando el HttpClient, el cual retorna una lista de monedas junto con sus valores para poder realizar las conversiones requeridas.



