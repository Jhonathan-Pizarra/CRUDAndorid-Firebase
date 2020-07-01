# PruebaB1 

**Nombre:** Jhonathan Pizarra\
**Asignatura:** Tópicos Especiales\
**Facultad:** ESFOT\
**Descripción:**\

Aplicación en Android con un CRUD sobre firebase implementado.
Consiste en una lista de usuarios sobre los cuales se puede editar, borrar agregar o consultar en sus campos.
Por defecto muestra solamente el nombre, pero es porque sólo ese le mandé para que se muestre, debido a que manejar consultas en un mismo frame puede no ayudar con los patrones de diseño
También contiene un Splash screen e Icono personalizado.

*Diseño:*\
Se comenzó por el diseño, con un ConstraintLayout para la parte del formulario, para ayudarnos a manejar los imput que son especiales, no siempre vienen instalados con Andorid Studio, y toca descargarlas como nuevas dependencias
Luego ya no hacemos los botones tradicionales, ahora se presentan unos persoalizados en función del CRUD
después, implementamos el Splash Screen e Icono, que igual, andorid instala algunas dependencias para dar soporte, por lo que puede que el ícono en el SplashScreen no se presente muy bien, o se presente pizelado

*Programación*\
Para la programación se utiliza el paradigma orientado a objetos, es decir que existe herencia, abstracción, encapsulamiento, y herencia que por medio de objetos y clases nos permitieron realiar el crud.
La aplicación también maneja persistencia, es decir, que los datos que manejemos con la base esté siempre que haya conexión, si se usa la app sin tener conexion a internet no va a servir de nada, aunque en pricnipio pueda aparecer como registrado, cuando haya conexión a internet la lista se actualizará, de ese modo los datos persisten sin opción a ser corrompidos.
además Andorid permite trabajar con Firebase, además de otras bases de datos, e igual para poder acceder a sus métodos necesitabamos importarlos y crear un par de objetos!

*Complicaciones*\
Como errores principales tuvimos que el sopote de andorid design hoy por hoy no es compatible si trabajas con la versión Android 6.0, por lo que se recomienda trabajar con las actual, que hoy es 9.0
Otro problema fue el diseño, necesitamos saber las administrar dimensiones de nuestros componentes, o de lo contrario el patron de diseño no será atractivo
Debes tener una computadora que soporte el emulador Android, este es más pesado que otros, pero la ventaja es que al ejecutar el proyecto se muestra de inmediato, en cambio con otros emuladores primero debemos generar el APK
e instalarlo, y eso no es tan viable para en una prueba, e imagínate si es solo para probar un componente o una funcionalidad. 
Eso sería todo...

Gracias... Totales

2020-A

