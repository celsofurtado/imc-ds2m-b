# Como "dockerizar" um app Spring Boot

## Configurando o projeto

Para criar uma imagem Docker do aplicativo Spring Boot é necessário criar o arquivo *Dockerfile* na raiz do projeto. Esse arquivo será criado na sua IDE preferencial. O conteúdo do arquivo deve ser o seguinte:

		FROM openjdk:11-jdk-slim-bullseye
		VOLUME /tmp
		ADD target/cht-0.0.1-SNAPSHOT.jar app.jar
		ENTRYPOINT ["java", "-jar", "/app.jar"]

**Onde,**

**FROM** - É a imagem que será utilizado pelo container Docker;\
**VOLUME** - Representa o volume onde a aplicação irá ser executada;\
**ADD** - É o local onde o executável se encontra. O *app.jar* é um *alias*.\
**ENTRYPOINT** - É o comando usado para executar o aplicativo com os seu atributos.\

## Criando a imagem do app

Para criar a imagem Docker da aplicação é necessário que já tenhamos criado, na Azure, um *Container Registry*, que terá um *Login server* do tipo *registryname.azurecr.io*. Esse *Login server* deverá ser utilizado na criação da imagem a partir do *Docker CLI*. Para criar a imagem execute o seguinte comando:

		docker build -t regsitryname.azure.io/seu_nome_de_imagem .

> **ATENÇÃO**, Você deve estar na raiz do projeto, no mesmo diretório do arquivo *Dockerfile*

Após a execução do comando acima, rode o comando:

		docker images

Verifique, na saída do comando, se a nova imagem aparece na lista de imagens Docker disponíveis no seu computador.


## Criando o container

Para criar um container a partir da imagem criada, rode o seguinte comando:

		docker container run -d -p 80:8080 regsitryname.azure.io/seu_nome_de_imagem

**Onde,**

**-d** - Executa o container em *background*
**-p** - Diz ao Docker que requisições no *localhost*, na porta 80 deverão ser redirecionados para a porta 8080 do container.


## Enviando o container para a Azure

Após a criação do container, vamos enviá-lo para a Azure. Para isso, devemos efetuar a autenticação no *Container Registry* que criamos na Azure. Para isso digite o seguinte comando no terminal:

		docker login regsitryname.azure.io			

Após a execução do comando acima, será solicitado o nome do usuário e a senha. Para obter as informações corretas de *user name*  e *password*, acesse o menu *Access keys* do lado esquerdo da tela.

Assim que a autenticação estiver concluído, basta enviar o container para a Azure com o comando abaixo:

		docker push regsitryname.azure.io/seu_nome_de_imagem 

É isso aí, agora é só criar uma aplicação web e apontar para o container que foi publicado :)
