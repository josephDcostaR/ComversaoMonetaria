# 💱 Conversor de Moedas - Java

## 📄 Descrição

Este é um projeto de **conversor de moedas** desenvolvido em **Java** que permite ao usuário converter valores entre diferentes moedas. O projeto utiliza a **API ExchangeRate-API** para obter as taxas de câmbio atualizadas e a biblioteca **Gson** para deserializar as respostas da API.

## 🛠️ Tecnologias Utilizadas

- **Java** (versão 21.0.1)
- **Gson** (para manipulação de JSON)
- **ExchangeRate-API** (para obter taxas de câmbio)

## 📋 Pré-requisitos

Certifique-se de ter o seguinte instalado em sua máquina:

- [Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Gson](https://github.com/google/gson)
- Um editor de código (por exemplo, **IntelliJ**, **Eclipse**, **VS Code**)

## 📦 Dependências

Baixe o arquivo `.jar` da biblioteca **Gson** e coloque-o na pasta `lib` do seu projeto, ou adicione a dependência manualmente se estiver utilizando um sistema de build como **Gradle** ou **Maven**.

### Gradle
```groovy
dependencies {
    implementation 'com.google.code.gson:gson:2.10.1'
}
```

### 🚀 Como Executar o Projeto

### 1. Clone o repositório:
```
git clone https://github.com/seu-usuario/conversor-moedas-java.git
cd conversor-moedas-java
```

### 2. Compile o projeto (se estiver usando linha de comando):
```
javac -cp lib/gson-2.10.1.jar src/*.java -d out
```

### 3. Execute o projeto:
```
java -cp "out;lib/gson-2.10.1.jar" Main
```

### 4. Interaja com o programa seguindo as instruções exibidas no console.

### 🧩 Funcionalidades
- Listar moedas suportadas no início da execução.
- Solicitar ao usuário uma moeda de origem e uma moeda de destino.
- Obter a taxa de conversão através da ExchangeRate-API.
- Realizar a conversão de valores monetários com base nas taxas obtidas.
- Continuar realizando conversões até o usuário decidir sair.

### 💻 Exemplo de Uso
````commandline
Moedas suportadas: [CLP, BRL, BOB, ARS, USD, COP]
Qual a sua moeda original (ex: USD, EUR, BRL):  
usd
Base: USD
Para qual moeda você quer converter (ex: ARS, BRL, EUR): cop
Taxa de conversão de USD para COP: 4434.19
Digite o valor que deseja converter: 100
100,00 USD em COP é: 443419,00 
Deseja realizar outra conversão? (s/n): n
Programa finalizado!
````

### 🗝️ Chave da API
Para usar a ExchangeRate-API, você precisa de uma chave de API. Cadastre-se em [ExchangeRate-API](https://www.exchangerate-api.com/) para obter sua chave gratuita.

Certifique-se de configurar a chave no arquivo ApiConection.java:
````commandline
private static final String API_KEY = "SUA_CHAVE_AQUI";
private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
````

### 📝 Licença
Este projeto é licenciado sob a MIT License. Sinta-se à vontade para usar, modificar e distribuir à vontade.

### 📢 Agradecimentos
Agradeço a todos que contribuíram com feedbacks e melhorias para o projeto!
