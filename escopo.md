# AGRUPAMENTO DAS MINHAS ANOTAÇÕES
================

Dicas para Registro no Workflow
Início

Ideia inicial e o problema que o projeto resolve.
Lista de requisitos.
Etapas de Desenvolvimento

Planejamento: arquitetura inicial, esboços, ferramentas escolhidas.
Construção: fases implementadas (CRUD, autenticação, etc.).
Testes: métodos e ferramentas para garantir qualidade.
Decisões e Aprendizados

Por que escolheu certas tecnologias ou abordagens.
Problemas enfrentados e como os resolveu.


==============

Java Projeto
credenciais JWT, gerenciamento de credencial no backend para as permissões

---------------

todos menos usuário podem:
se autenticado poder atualizar suas informações de endereço, telefone, email ou senha

permissões de nível estratégico:
crud (deleção logica(deletado"desativado"/porquem/quando) e regra de negócio: exigir que todos os funcionarios vinuculados sejam desvinculados) todos os setores
***crud (deleção logica(deletado"desativado"/porquem/quando) e regra de negócio: exigir que todos os funcionarios vinuculados sejam desvinculados) de permissões (nivel tático)***
visualizar todos os membros ou por setores ou por nível tático ou por nível operacional
associar permissões para perfis de nível tático (gerente).


permissões de nível tático:
***crud (deleção logica(deletado"desativado"/porquem/quando) e regra de negócio: exigir que todos os funcionarios vinuculados sejam desvinculados) de funções (nivel operacional)***
visualizar membros apenas do próprio setor
associar permissões para perfis de nível operacional.


permissões de nível operacional:
se autenticado poder acessar sua respectiva rota
"departamento/supervisor", "departamento/analista", "departamento/acessor", "departamento/auxiliar".

ENTIDADES
credenciamento (idusuário, credencial)
membros ()
perfil (id_perfil, codigo_credencial, nome do perfil, e descrição_da_função)

RELACIONAMENTOS

==============

DOING
- criar entidade Membros (pessoa) (
classe JPA
? repository 
FEITO: migration
- criar método post membros



TO-DO
- Criar Entidades (classes JPA e repositorys p/ acesso DB e entidades DB PostgreSQL):
- criar entidade Perfis de acesso (enum e outros atributos) (classe JPA, repository e migration)
- criar entidade Permissões (enum e outros atributos) (classe JPA, repository e migration)
- criar entidade Setores (nome_setor e desc) (classe JPA, repository e migration)
- criar entidade Função (nome_fun e desc) (classe JPA, repository e migration)

- 18. rota de autenticação (POST/ /login)
- serviço de token JWT
- serviço de autenticação

- criar usuário com todas permissões (para teste)
- criar um usuário para cada permissão
- usuário com nenhuma permissão (para teste)

- Criar controllers de rotas:
- 1. rota (GET/ membros) filtros -> setor/níveis(os 3) [RH e nível estrategico]
- 2. rota (POST/ membros) [RH]

- 3. rota (POST/ setor) [nível estrategico]
- 4. rota (GET/ setor) [nível estratégico e RH]
- 5. rota (PATCH ou PUT/ setor) [nível estrategico]
- 6. rota (DELETE/ setor) [nível estrategico]

- 7. rota (POST/ membros/setor) vincular membro setor [RH]
- 8. rota (POST/ membros/tatico/permissoes) [nível estrategico]
- 9. rota (POST/ membros/operacional/permissoes) [nível tatico]

- 10. rota (POST/ funcao) [nível tatico]
- 11. rota (GET/ funcao) [nível tatico e RH]
- 12. rota (PATCH ou PUT/ funcao) [nível tatico]
- 13. rota (DELETE/ funcao) [nível tatico]
- 14. rota (GET/ /usuarios?setor={idSetor}) [nível tatico]

- 15. rota (GET/ /{setor}/{funcao}) [nível operacional]
- 16. rota (GET/ /usuario) pega id pelo token dps validar retorna informações pessoais
- 17. rota (PUT ou PATCH /usuario) atualiza informações

- Criar configurações de segurança
- mapear permissões das 17 rotas estipuladas no filter

- criar DTOs para receber pelas as 17 rotas
- criar DTOs de retorno das 17 rotas

- criar Serviços 17 para cada rota intermédio controller-repository
- Tratador de erros (códigos de rota)

DONE
- Entender com o chatGPT como mais de um tipo de permissão será administrada no sistema
- Pensar entidades do sistema

=====================

camada de controllers (respostas padronizadas das requisições)

camada de DTOs

camada de entidades JPA (repository)

camada de serviços

utilizar migatrions

camada de permissões (serviços de permissões) 

configurações no arquivo proprieties: para não retornar o tracer no json de erro

====================

controlador de PF com métodos:
	cadastrar
		dto: nome, cpf, (rg e OrgExp) , email (unique), telefone (unique), endereço (unique), sexo(enum), estado civil(enum), data de nascimento (verificação de datas aceitaveis), nacionalidade (enum). senha

ativo? , id, hashsenha, ultimo acesso, 

	atualizar
		dto: id e patch: informações atualizáveis:
	excluir fisicamente
		id por rota ou parametro
	excluir logicamente (inativo)
		id por rota ou parametro
	

controlador de Perfil com metodos

funcionalidades para permissão dos membros do RH:
cadastrar novos membros no sistema
visualizar todos os membros ou por setores ou por nível tático ou por nível operacional


funcionalidades para permissão de nível estratégico:
crud (deleção logica(deletado"desativado"/porquem/quando) e regra de negócio: exigir que todos os funcionarios vinuculados sejam desvinculados) todos os setores
visualizar todos os membros ou por setores ou por nível tático ou por nível operacional
associar permissões para perfis de nível tático (gerente).


funcionalidades para permissão de nível tático:
crud (deleção logica(deletado"desativado"/porquem/quando) e regra de negócio: exigir que todos os funcionarios vinuculados sejam desvinculados) de funções
visualizar membros apenas do próprio setor
associar permissões para perfis de nível operacional.


funcionalidades para permissão de nível operacional:
se autenticado poder acessar sua respectiva rota
"departamento/supervisor", "departamento/analista", "departamento/acessor", "departamento/auxiliar".


funcionalidade para todos usuários:
se autenticado/autorizado (não sei qual é o certo), podem atualizar suas informações alteráveis do próprio cadastro (endereço, telefone, email ou senha)

tabelas
relacionamente (idusuário, credencial)
pessoa fisica
perfil (id perfil, credencial)

=====================
