xMANUAL DO COSMOSCHECKER


O CosmosChecker recebe três valores de entrada: (1) o arquivo de regras do COSMOS;(2) o pacote do componente e;(3) o diretório das classes ou o arquivo jar. O arquivo de regras do COSMOS lista as regras que analisam o componente para saber se ele satisfaz as restrições do COSMOS.

1. O caminho para o arquivo de regras deve ser completo. Veja o exemplo abaixo:

/home/user/cosmos.drl


2. O pacote do componente não deve conter os sub-pacotes do COSMOS. Por exemplo:

br.unicamp.ic.sed.MyComponent

e NÃO

br.unicamp.ic.sed.MyComponent.impl ou br.unicamp.ic.sed.MyComponent.spec


3. O caminho para o componente pode ser o caminho para o diretório onde estão as classes ou o caminho até o arquivo jar.
Exemplos:

/home/user/workspace/br/unicamp/ic/sed/MyComponent/

ou 

/home/user/workspace/mycomponent.jar


Repare que o caminho para o diretório do componente para no diretório imediatamente acima dos diretórios 'impl' e 'spec', comuns aos componentes COSMOS.
