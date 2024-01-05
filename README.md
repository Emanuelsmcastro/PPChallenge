# PPChallenge

![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/d3bcde0c-eae8-4db1-9d04-3cf8fc757d8b)

> Este projeto é um sistema sofisticado que simula operações bancárias com uma série de restrições específicas para garantir a segurança e a integridade das transações. Ele foi projetado para replicar o funcionamento de um banco digital, permitindo que os usuários realizem transações financeiras.

> Um aspecto fundamental deste sistema é a distinção entre diferentes tipos de usuários. Por exemplo, um usuário comum tem a capacidade de enviar e receber dinheiro, proporcionando a flexibilidade necessária para uma ampla gama de transações. No entanto, um usuário vendedor, que representa um comerciante ou uma entidade comercial, tem permissões mais restritas e só pode receber dinheiro. Esta restrição é uma medida de segurança que protege contra possíveis abusos do sistema.

> O sistema é dividido em duas partes lógicas principais para garantir uma separação clara de responsabilidades e facilitar a manutenção e a escalabilidade. A primeira parte é o microsserviço de usuários, que gerencia todas as informações e atividades relacionadas aos usuários do sistema. A segunda parte é o microsserviço de transações, que lida com todas as operações de transação, incluindo a verificação de restrições e a execução de transações.

> Cada microsserviço tem sua própria responsabilidade distinta, permitindo que o sistema opere de maneira eficiente e eficaz. Esta arquitetura modular não só melhora a robustez do sistema, mas também facilita futuras expansões ou modificações.

A seguir teremos uma explicação mais técnica sobre o projeto.

![wallpaperflare com_wallpaper](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/1cb1876b-fa28-400c-b9f3-1cd6f7c82f21)

Este projeto é o resultado de um desafio técnico que me permitiu consolidar e aplicar diversos conceitos que venho estudando. O objetivo principal era integrar vários dos meus estudos em um único projeto, criando uma plataforma robusta e funcional. Dentre as tecnologias empregadas, destaco o uso do Spring Boot 3 e Java, que foram fundamentais para o desenvolvimento e aprimoramento deste projeto. A seguir, apresento a lista completa das tecnologias utilizadas.

- Spring Data / JPA / Hibernate
- Spring Security
- OAuth2
- OpenFeign
- HATEOAS
- Eureka Server
- Gateway Server
- Keycloak / Authorization Server
- Docker

> É evidente que a escalabilidade de um projeto não se limita apenas à qualidade do código escrito. Requer uma compreensão profunda dos conceitos empregados e das melhores práticas de desenvolvimento de software. A excelência técnica é alcançada através da aplicação consciente de princípios e padrões de design que promovem a robustez e a flexibilidade do código.

> Neste projeto, adotei os princípios SOLID, um acrônimo para cinco princípios de design orientado a objetos e programação que tornam o software mais compreensível, flexível e sustentável. Estes princípios são: Single Responsibility (Responsabilidade Única), Open-Closed (Aberto-Fechado), Liskov Substitution (Substituição de Liskov), Interface Segregation (Segregação de Interface) e Dependency Inversion (Inversão de Dependência).

> Além disso, implementei três padrões de projeto fundamentais para estruturar o código de maneira eficiente e eficaz. O padrão Factory Method foi usado para fornecer classe para criar objetos, permitindo o objeto desejado seja instanciado. O padrão Builder foi empregado para construir objetos complexos passo a passo, oferecendo a possibilidade de produzir diferentes tipos e representações de um objeto usando o mesmo código de construção. Por fim, o padrão Chain of Responsibility foi utilizado para tratar as estrições das operações, como por exemplo: retornar um erro ao usuário ou atualizar o status da transação de acordo com o estabelecido na regra de negócio.

> Além disso, o projeto também emprega o padrão de arquitetura Model-View-Controller (MVC), que é fundamental para a estruturação eficaz do sistema. O MVC é um padrão de design que divide a aplicação em três componentes interconectados: o Model, que representa os dados e as regras de negócio; a View, que é a interface do usuário; e o Controller, que processa e responde às ações do usuário, manipulando os dados conforme necessário. A utilização do MVC permite uma separação clara das responsabilidades, facilitando a manutenção e a compreensão do código. Além disso, ele promove a modularidade e a flexibilidade, características essenciais para a escalabilidade do projeto. Portanto, a adoção do padrão MVC é uma parte crucial da estratégia de design deste projeto, contribuindo significativamente para a sua robustez e eficiência.

# Como posso utilizar a aplicação?

> Nessa sessão iremos configurar o ambiente para conseguirmos rodar a aplicação corretamente.

## Docker-compose

1. Substitua o IP que está no docker-compose para o da sua máquina:                                                                           
   ![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/7341dbb4-fefb-4aaf-ba33-ac5e12a3cb73)
   OBS: Umas das validações do access token é o "issuer-uri":                                                                                                                                                     
   ![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/0e398496-7c36-4b6e-912e-23c4e9a99ad4)
   Por essa razão é necessário colocar o IP da máquina para que tanto os serviços quanto você tenha acesso ao mesmo issuer, evitando um possível erro de emissor.

2. Na raiz do projeto, digite: docker-compose up -d --build                                                              
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/87f3003a-86fc-4354-ab0e-8d023d24846c)

3. Aguarde os containers iniciarem:                                                                                                                        
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/41b0ef3e-8ebd-4f28-9bf5-7c39b6889530)

5. Utilize o Postman para realizar suas transações!

## Postman

1. Importe a coleção e o ambiente do postman disponibilizado no projeto:
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/b8f3c3f3-ccac-4166-b600-0152c02655df)

2. Modifique a variável "access_token_url" para que tenha o seu IP:
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/a5527f31-fe37-428b-bab5-43b059932615)

3. Acesse a aba "Authorization" e certifiquesse que esteja como o exemplo a seguir:
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/677c2641-c247-45f3-8470-9abf5c7b974d)

4. Clique em "Get New Access Token"                                                         
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/352bc37f-d95d-426e-90e3-4d123d2a633b)

5. Clique em "Use Token":                                                       
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/95a1712d-f0af-4f99-866e-d31b8878c36a)

6. Agora você já possui um access token para utilizar a aplicação!                                      
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/ffd6e29f-91aa-4db5-b959-5a0d36a416b7)

## Swagger
1. Escolha entre MS-USER (http://localhost:1001/swagger-ui/index.html) e MS-TRANSFER (http://localhost:1002/swagger-ui/index.html):
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/b0629e27-4b2e-4fa1-a900-ff9c26621dc9)

# Exemplo de uso
1. Escolha o uuid do usuário que irá enviar e o usuário que irá receber (OBS: O uuid do usuário principal não é válido, precisa ser um CommonUser ou Shopkeeper):
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/02b4a829-f0cb-49bb-8b64-00f09661a515)
>Nesse exemplo irei utilizar o CommonUser (123e4567-e89b-12d3-a456-426614174000) para enviar 25 para o ShopKeeper (123e4567-e89b-12d3-a456-426614174003).
2. Realize a transação:
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/e85141ef-a380-4900-8fec-b85db9e4aa45)

## Erros comuns

1. Valores de envio e recebimento diferentes:                                                                  
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/347d6e70-7aeb-493e-9617-cf106e83b431)

2. Transferência para o mesmo usuário (OBS: Nesse caso a análise de usuário é feita pelo uuid do usuário principal, não do CommonUser e nem do Shopkeeper):
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/e1615dff-18a8-4eb2-81b5-addd99818476)

3. Usuário não encontrado:                                                             
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/17750f70-09bb-462c-ab64-f8440f934ec9)
