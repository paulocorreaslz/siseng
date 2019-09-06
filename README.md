# siseng
Sistema de Engenharia

Problema:
O sistema possui o controle destes contratos, das ordens de serviço e medições para manutenção de edifícios do Tribunal.
No contexto deste sistema, cada contrato possui uma composição de itens de contrato. A composição dos itens de contrato é estruturada com:
-Itens de insumo, tais como materiais (por ex: cimento, argila etc.) ou mão de obra (pedreiro, engenheiro etc.), que possuem valor por unidade e uma unidade de medida (metros quadrado, metros cúbicos, hora/homem etc.), com a quantidade do item no contrato;
-Itens compostos, que são composições de insumos ou de outras composições, cujos valores são calculados através da soma de todos os itens da composição.

Objetivo:
Criar uma solução que imprima os itens de um contrato (cada item possui um identificador e descrição), com o valor equivalente a cada item (se o item for composto, imprimir também somente o identificador, descrição e valor equivalente). 
No final, imprimir o valor total do contrato.

Ex: (item 105 é composto)
103 – Argila – R$ 150,00
105 – Levantamento de Parede – R$ 1.200,00
...
	Total: R$ 150.200,30

Solução:

Para o sistema acima após a análise do pedido do cliente, observou-se a arquitetura conforme o MindMap a seguir:

![Contrato_mindmap](https://user-images.githubusercontent.com/20933804/64403271-4f6bc480-d04e-11e9-9dcf-af9c26440e0c.jpg)

Após a identificação do problema, optou-se por uma arquitetura simples de uma API de MicroServiços RestFull.
Os dados de retorno estão encapsulados em uma Entidade "ResponseEntity e GenericResponse" para utilizar o protocolo http e a arquitura Rest.

Foi criado um arquivo json com alguns insumos para utilizar dentro da API. 
Foi criada ainda cadastros de contratos, itens e itens compostos em tempo de execução para demostrar o uso do sistema.
Foi utilizada a api Gson para importar o arquivo Json como repositorio de insumos inicial no sistema.

Tecnologias Utilizadas:
- Spring Boot 1.5.21
- Maven 4.0
- Java 1.8
- Docker 1.13.1
- Docker-Compose 1.24.1 
- Container web Undertow - Default Web Server do WildFly
- json-simple 1.1.1
- com.google.code.gson
- springfox-swagger2 2.6.1
- springfox-swagger-ui 2.6.1

Configuração:
- Porta servidor: 9092

Executando a aplicação:
- Baixar o projeto com o comando "git clone git@github.com:paulocorreaslz/siseng.git"

Entrar no diretorio "siseng/target" e executar o comando:
- java -jar siseng.war

Utilizando a API:
Para acessar o swagger para acessar as chamadas da API utilize os endereços abaixo.

Em caso de instalação Local:
http://localhost:9092/swagger-ui.html

Pelo Heroku:
https://siseng.herokuapp.com/swagger-ui.html

Acessando a API Localmente:
- Endereço local: http://localhost:9092/api/online

Endereço no Heroku:
https://siseng.herokuapp.com/api/online
Resposta: "online"

{URL}:
- http://localhost:9092/
- https://siseng.herokuapp.com/

Urls Disponives:

{URL}/api/oneline - Testar a aplicação exemplo: http://localhost:9092/api/online

{URL}/api/insumos - Listar todos os insumos exemplo: http://localhost:9092/api/insumos

{URL}/api/insumo/{tipo} -  Listar insumo por tipo onde {tipo} é o nome do tipo que pode ser MATERIAL, MAODEOBRA OU COMPOSTO exemplo: http://localhost:9092/api/insumo/MATERIAL 

{URL}/api/contratos - Listar todos os contatos exemplo: http://localhost:9092/api/contratos

{URL}/api/contrato/{id} - Lista o contrato por id, onde o id é o numero do contrato, exemplo: http://localhost:9092/api/contrato/1
