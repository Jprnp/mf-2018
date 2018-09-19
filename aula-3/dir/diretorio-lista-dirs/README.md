# Escopo
Esta aplicação tem como objetivo listar o caminho absoluto para todos os diretórios e subdiretórios visíveis a partir do diretório corrente (de onde é executado o programa).

# Execução da aplicação
## Gerar o executável do projeto
Para gerar o arquivo executável, é necessário que, no diretório base deste, se execute o seguinte comando (cmd ou bash):
```
mvn package -P executavel-unico
```
Este comando irá gerar um diretório _target_ e, dentro dele, o arquivo DiretorioListarDirs.jar.

## Executar o arquivo
Para executar o arquivo, será necessário executar o seguinte comando:
```
java -jar <caminho_pro_arquivo>
```
