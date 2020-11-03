# editor-de-texto-ET
Editor de Pilha
Vamos escrever um Editor de Texto (ET) que aceite os comandos:
• Cancela caracter
• Cancela linha
• Imprime linha

O ET deverá ler um caractere de cada vez do texto de entrada e produzir a impressão linha a linha, cada
linha contendo no máximo 70 caracteres de impressão. O ET deverá utilizar o tipo abstrato de dados Pilha
definido anteriormente, implementado por meio de apontadores (Pilha dinâmica).

➢ “#”: cancelar caractere anterior na linha sendo editada.
Ex.: CFM##EFETP# → CEFET
➢ “\”: cancela todos os caracteres anteriores na linha sendo editada.
➢ “*”: salta a linha. Ex: DCCTIM*CEFET*
DCCTIM
CEFET
➢ “~”: Indica fim dos dados de entrada

Sugestão de Texto para Testar o ET

Este et# um teste para o ET, o extraterrestre em Java.*Acabamos de testar a
capacidade de o ET saltar de linha, utilizando seus poderes extras (cuidado,
pois agora vamos estourar a capacidade máxima da linha de impressão, que é de
70 caracteres.)*O k#cut#rso dh#e Estruturas de Dados et# h#um cuu#rsh#o #x#
x?*!#?!#+.*
Como
et#
bom
n#nt#ao###
r#ess#tt#ar
mb#aa#triz#cull#ado
nn#x#ele!\ Sera que este funciona\\\? O sinal? não### deve ficar! ~

Saída esperada: 

Este e um teste para o ET, o extraterrestre em Java.
Acabamos de testar a capacidade de o ET saltar de linha, utilizando seus poderes
extras (cuidado, pois agora vamos estourar a capacidade máxima da linha de impressão,
que é de 70 caracteres.)
O curso de Estruturas de Dados e um curso?
?+.
? O sinal? deve ficar!

OBSERVAÇÕES:
• Data de entrega: 09/11/2020
• Clareza, identação e comentários no programa também serão avaliados;
• NÃO é permitido o uso de estruturas de dados já implementadas no Java, tais como: ArrayList, LinkedList,
Stack ou similares. Todas as funções e as estruturas utilizadas deverão ser implementadas;
