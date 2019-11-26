# AJuDE - BackEnd

> Repositório referente ao backend do projeto final da disciplina de Projeto de Software da UFCG (2019.2) desenvolvida em Spring MVC.

## O projeto 

<p> O AJuDE é uma ferramenta que permite a organização de doações para projetos/campanhas. Antes de continuar vamos entender crowdfunding: </p>

> Financiamento coletivo, também conhecido como crowdfunding, consiste na obtenção de capital para iniciativas de interesse coletivo através da agregação de múltiplas fontes de financiamento, em geral pessoas físicas interessadas na iniciativa. O termo é muitas vezes usado para descrever especificamente ações na Internet com o objetivo de arrecadar dinheiro para artistas, jornalismo cidadão, pequenos negócios e empresas emergentes, campanhas políticas, iniciativas de software livre, filantropia e ajuda a regiões atingidas por desastres, entre outros.



## Diretórios

- `src/main/java/br/ufcg/psoft/ajude` Nesse caminho está todas as pastas nescessárias para o funcionamento do sistema.
  - `/business` Diretório onde encontra-se os arquivos CampaignBusinessDelegate.java, CommentBusinessDelegate.java e UserProfileBusinessDelegate.java.
    - `/CampaignBusinessDelegate` Responsável por delegar funções ao campanhaService usando CampaignDTO.
    - `/CommentBusinessDelegate` Responsável por delegar funções ao commentService usando CommentDTO.
    - `/UserProfileBusinessDelegate` Responsável por criar o perfil do usuário autenticado.
  - `/config` Diretório onde encontra-se o arquivo SwaggerConfig.java.
    - `/SwaggerConfig` Responsável por documentar a api.
  - `/controller`  Diretório onde encontra-se os arquivos CampaignController.java, CommentController.java, DonationController.java, UserController.java, UserProfileController.java. É no controller onde se encontram as rotas para comunicação com o frontend. 
    - `/CampaignController` Responsável por cadastrar uma campanha, pegar uma campanha pela url, busca campanhas por uma ordem ou não, buscar campanhas a partir de uma substring e dar like em uma campanha.
    - `/CommentController`  Responsável pela inserção e remoção de comentarios em alguma campanha.
    - `/DonationController` Responsável por realizar uma doação para uma campanha.
    - `/UserController` Responsável pelo cadastramento de um novo usuário no sistema.
    - `/UserProfileController` Responsável por criar o perfil do usuário autenticado.
  - `/dto` Diretório onde encontra-se os arquivos CampaignDTO.java, CommentDTO.java, UserDTO.java, UserProfileDTO.java.
    - `/CampaignDTO` Responsável por criar o DTO de uma campanha.
    - `/CommentDTO` Responsável por criar o DTO de uma comentário.
    - `/TokenDTO` Responsável por criar o DTO do Token.
    - `/UserDTO` Responsável por criar o DTO de um usuário.
    - `/UserProfileDTO` Responsável por criar o DTO de um perfil do usuário.
  - `/exceptions` Diretório onde encontra-se os pacotes com exceções para cada entidade do sistema e seus atributos.
    - `/campaign` Pacote que contem as exceções para situações na entidade Campaign.
    - `/comment` Pacote que contem as exceções para situações na entidade Comment.
    - `/date` Pacote que contem as exceções para situações que usem data.
    - `/email` Pacote que contem as exceções para situações que usem email.
    - `/entity` Pacote que contem as exceções para situações para entidades em geral.
    - `/password` Pacote que contem as exceções para situações que usem password.
    - `/user` Pacote que contem as exceções para situações na entidade User.
  - `/model` Diretório onde encontra-se os arquivos Campaign.java, Comment.java, Donation.java, User.java, User.java. é nesse pacote que estão as entidades usadas no sistema junto ao status.java que é um enum. 
    - `/Campaign`Entidade responsável pelo campanha.
    - `/Comment` Entidade responsável pelo comentário.
    - `/Donation` Entidade responsável pela doação.
    - `/Status` Enum para status de uma campanha
    - `/User` Entidade responsável pelo usuário.
  - `/repositories` Diretório onde encontra-se os arquivos CampaignDAO.java, CommentDAO.java, DonationDAO.java, UserDAO.java.
    - `/CampaignDAO`  Responsável pelo DAO de campanha com as funcionalidades de buscar uma campanha pela url, pegar todas as campanhas, pegar as campanhas ordenadas pela data, meta e like, buscar campanhas por uma substring, pegar campanhas que um usuário doou e por fim pegar campanhas criadas por um usuário.
    - `/CommentDAO`  Responsável pelo DAO de comentários com as funcionalidades de salvar um comentário e buscar um comentário pelo seu ID.
    - `/DonationDAO`  Responsável pelo DAO de doação.
    - `/UserDAO`  Responsável pelo DAO de usuário com a funcionalidade de buscar um usuário pelo seu email.
    - `/user` Pacote que contem as exceções para situações na entidade User.
  - `/security` Diretório onde encontra-se os arquivos ConstantesSeguranca.java, CustomAuthenticationManager.java, JwtAuthenticationFilter.java, JwtAuthorizationFilter.java, SecurityConfiguration.java.
    - `/ConstantesSeguranca` Constantes para melhor legibilidade.
    - `/CustomAuthenticationManager` Adaptador que recebe as credenciais de autenticação da requisição e valida isso com o usuário do sistema.
    - `/JwtAuthenticationFilter` Responsável por autenticar um usuário a partir do seu email e senha.
    - `/JwtAuthorizationFilter` Responsável por autorizar um usuário autenticado.
    - `/SecurityConfiguration` Responsável por configurar a segurança da api.
  - `/service` Diretório onde encontra-se os arquivos CampaignService.java/ CampaignBean.java, CommentService.java/ CommentBean.java, DonationService.java/ DonationBean.java, EmailService.java/ EmailBean.java, UserService.java/ UserBean.java. Sendo os arquivos Service interfaces com a assinatura do metodos e o bean implementando suas respectivas interfaces. 
    - `/campaign`  Service responsável por buscar todas as campanhas a partir de uma ordem ou não, buscar uma campanha pela url, cadastrar uma campanha, encontrar campanhas por substring, dar like em uma campanha, atualizar uma campanha, buscar as campanhas que um usuário criou e buscar as campanhas que um usuário doou.
    - `/comment`  Service responsável pela inserção e remoção de comentários do sistema.
    - `/donation` Service responsável pela doação de dinheiro para um campanha.
    - `/email` Service responsável pelo envio de um email de boas vindas para um usuário recém cadastrado no sistema.
    - `/user` Service responsável pelo cadastro e buscas de usuários.
  - `/validators` Diretório onde encontra-se os arquivos CampaignValidator.java, CommentValidatorjava, UserValidator.java
    - `/CampaignValidator` Responsável por validar uma campanha.
    - `/CommentValidator` Responsável por validar um comentário.
    - `/UserValidator` Responsável por validar um usuário.

## Links 

## Token(JWT)

A configuração do token é de 86400000 milissegundos(equivalente a um dia) já que a aplicação não é crítica.

## Documentação da API 

[Link para o Swagger](https://ajudepsoft192.herokuapp.com/api/swagger-ui.html#/)
 
## FrontEnd

[Repositório do Front](https://github.com/almirgon/Frontend-Ajude-19.2)


