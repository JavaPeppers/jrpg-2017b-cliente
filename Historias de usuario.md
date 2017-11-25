#  Historias de usuario

## 01 Ítems:
Como `jugador` quiero que el `juego` posea una serie de `ítems`, y con estos aumentar las stats de los personajes, de manera tal que sea
notorio el cambio con los mismos a la hora de batallar, y poder ver la vida y la energía de los personajes con las stats que corresponden al tener los ítems equipados. Los ítems se obtendrán mediante una batalla, de haberla ganado, el personaje ganador obtendrá un item.
### Condiciones de aceptación:
1. El item debe modificar al menos un atributo de mi personaje.
2. El item debe tener una foto única que lo representa junto con su nombre.
3. Sólo debe dar un item al personaje ganador de la batalla.

## 02 Inventario:
Como `jugador` quiero que mi `personaje` posea un `inventario` en el cual pueda visualizar los `ítems` del `personaje` y a su vez, visualizar los `atributos` que estos ítems aumentan a las stats del personaje. Teniendo en cuenta que el inventario tiene un máximo de 9 ítems.
### Condiciones de aceptación:
1. Debo poder visualizar correctamente los ítems de mi personaje.
2. Mi inventario debe llenarse cuando éste posea 9 ítems.
3. Al ganar una batalla con el inventario lleno, esta no debe darme ningún item.

## 03 Manipulación del inventario:
Como jugador, quiero tener la habilidad de `eliminar` ítems del inventario del personaje de manera tal de dejar libre el espacio ocupado por éste item.
### Condiciones de aceptación:
1. Debo notar de inmediato el cambio de atributos de mi personaje al eliminar el item.
2. Una vez eliminatdo, si salgo y vuelvo a entrar al juego, el item debe de no aparecer en mi inventario.

## 04 Mercado:
Como `jugador` quiero que mi `personaje` posea la habilidad de intercambiar sus ítems con los de otro `personaje`, y que realizado el `intercambio` se aprecien las nuevas `stats` de mi `personaje`. Nótese que existe un área de `comercio`, solo se puede comerciar si solo si están dentro de dicha zona.
### Condiciones de aceptación:
1. Sólo se debe permitir el intercambio de ítems es decir no puede existir un intercambio entre un item y no recibir ninguno.
2. Se debe controlar que la suma total de los ítems finales de cada `personaje` no supere el límite máximo, de hacerlo, no se debe permitir el intercambio.
3. El intercambio debe ser realizado sí sólo si ambos `personajes` aceptan el intercambio.
4. Cuando selecciono un `item`, debe aparecer las `stats` de este, para que el `jugador` sepa que `stats` posee ese `item`.
5. Si un `jugador` pretende comerciar con otro y este ultimo está fuera de la zona de comercio, se debe mostrar el mensaje correspondiente.
6. Si un `jugador` pretende comerciar con otro y éste está fuera de la zona de comercio, se debe msotrar el mensaje correspondiente.

## 05 Chat:
Como `jugador` quiero poseer la habilidad de comunicarme con otros `jugadores` mediante un `Chat`, así como también quiero una `Sala` en la cual el mensaje enviado sea recibido por todos los `jugadores`.
### Condiciones de aceptación:
1. Al enviar un mensaje el `jugador` receptor debe recibirlo instantáneamente.
2. Al enviar un mensaje en la `Sala` todos los jugadores deben recibir el mensaje instantáneamente.
3. Se debe poder batallar y hablar al mismo tiempo.
4. Se debe poder comerciar y hablar al mismo tiempo.

## 06 Enemigos: 
Como `jugador` quiero que el `juego` tenga `Enemigos` situados en lugares aleatorios del mapa, con los cuales pueda pelear y ganar experiencia al vencerlos.
### Condiciones de aceptación:
1. Debo poder ganar experiencia al vencer un `Enemigo`, y poder subir de nivel cuando se llegue a la experiencia tope.
2. El `Enemigo` debe desaparecer del mapa luego de vencerlo.
3. Se debe establecer una batalla con un `Enemigo` al acercarme al mismo. 
4. No es necesario obtener `Ìtems` cuando se pasa de nivel venciendo al `Enemigo` 

## 07 Puntos de Skills:
Como `jugador` quiero poder aumentar los stats de mi `personaje`. Para ello, a medida que suba de nivel, se deberian ir acumulando puntos para poder asignar al `Skill` que desee.
### Condiciones de aceptación:
1. Se deben acumular 3(Tres) puntos de `Skills` por cada nivel subido con mi `personaje`
2. Se deben poder desasignar puntos a una `Skill` que se le asignó previamente, e incrementar los puntos disponibles para asignar a otra `Skill`
3. No se debe poder desasignar puntos a una `Skill` cuando está en su cantidad base o inicial
4. Solo se deben ganar `puntos skills` cuando se sube de nivel.

## 08 Cheats:
Como `jugador` quiero poder realizar `cheats` con los cuales pueda obtener distintos beneficios para mi `personaje`.
### Condiciones de aceptación:
1. Se debe poder evitar todo ataque de un enemigo (NPC o Personaje) tipeando el comando "iddqd" en el chat. Además, si dos Personajes poseen este `cheat`, si se deben poder hacer daño mutuo.
2. Se debe poder atravesar paredes, siempre y cuando no se salga del mapa del juego tipeando el comando "noclip" en el chat.
3. Se debe poder aumentar al doble de la fuerza de mi `personaje` tipeando "bigdaddy" en el chat. Por otro lado, se debe poder disminuir el doble de la fuerza, escribiendo el comando "tinydaddy".
4. Se debe poder poner invisible mi `personaje` para todos los demas Personajes logueados en el mismo mapa. Pero si otro Personaje se encuentra tambièn en modo invisible, debe poder verme. Todo esto se debe realizar con el comando "war aint what it used to be"
