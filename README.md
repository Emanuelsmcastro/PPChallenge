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

> Nessa sessão iremos conseguir configurar o ambiente para conseguirmos rodar a aplicação corretamente.

## Docker-compose

1. Substitua o IP que está no docker-compose para o da sua máquina:
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/7341dbb4-fefb-4aaf-ba33-ac5e12a3cb73)
OBS: Umas das validações do access token é o "issuer-uri":
![image](https://github.com/Emanuelsmcastro/PPChallenge/assets/93106680/0e398496-7c36-4b6e-912e-23c4e9a99ad4)
Por essa razão é necessário colocar o IP da máquina para que tanto os serviços quanto você tenha acesso ao mesmo issuer, evitando um possível erro de emissor.

3. Na raiz do projeto, digite: docker-compose up -d --build

4. Aguarde os containers iniciarem:

5. Utilize o Postman para realizar suas transações!
