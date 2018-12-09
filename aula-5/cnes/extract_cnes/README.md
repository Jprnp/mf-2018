# Escopo
Esta aplicação tem como objetivo realizar o download de um arquivo .zip e extrair informações dele, armazenando em um arquivo .json nomeado pelo usuário.

# Execução da aplicação
## Gerar o executável do projeto
Para gerar o arquivo executável, é necessário que, no diretório base deste, se execute o seguinte comando (cmd ou bash):
```
mvn package -P executavel-unico
```
Este comando irá gerar um diretório _target_ e, dentro dele, o arquivo _App-unico.jar_.

## Executar o arquivo
A execução do programa depende de dois parâmetros:
+ 1º parâmetro = URL do arquivo .zip a ser baixado.
+ 2º parâmetro = Nome do arquivo .json a ser gerado.
Para executar o arquivo, será necessário executar o seguinte comando:
```
java -jar <caminho_pro_arquivo> <parâmetro1> <parâmetro2>
```
