# Escopo
Esta aplicação tem como objetivo listar o número de linhas para cada arquivo encontrado a partir de um diretório e seus subdiretórios e o total de linhas contadas para todos os arquivos de acordo com um sufixo informado.

# Execução da aplicação
## Gerar o executável do projeto
Para gerar o arquivo executável, é necessário que, no diretório base deste, se execute o seguinte comando (cmd ou bash):
```
mvn package -P executavel-unico
```
Este comando irá gerar um diretório _target_ e, dentro dele, o arquivo _ContaLinhas-unico.jar_.

## Executar o arquivo
A execução do programa varia de acordo com a quantidade de parâmetros informados (deve-se passar ao menos 1):
+ 1 parâmetro = O parâmetro informado será considerado como o sufixo que será levado em consideração para a contagem de linhas. A busca pelos arquivos se iniciará a partir do diretório corrente.
+ 2 parâmetros = O primeiro parâmetro deverá ser o caminho no qual a busca deverá ser iniciada e o segundo parâmetro será o sufixo.
+ 3 ou mais parâmetros = A execução será igual ao descrito acima para 2 parâmetros. Os demais serão ignorados.

Para executar o arquivo, será necessário executar o seguinte comando:
```
java -jar <caminho_pro_arquivo> <parâmetro1> <parâmetro2>
```
