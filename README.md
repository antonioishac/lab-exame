# API para manutenção de laboratórios e exames

#  Arquitetura do projeto
	Projeto desenvolvido com Spring Boot, Spring Data JPA com Hibernate,
	Validação com Bean Validation e mensagens configuradas em um arquivo .properties,
	Controlando as exceptions da API com ExceptionHandler utilizando a arquitetura RestControllerAdvice,
	Utilização do Criteria, CriteriaBuilder e CriteriaQuery, utilização de Metamodel,
	Nivel de maturiade Richardson, utilização de URI, HTTP Methods e HATEOAS (Hypermedia).
	Banco de dados MySql, criação dos scripts com a utilização do Flyway

## Instrução de uso da API

Estamos desenvolvendo uma aplicação para as seguintes situações:

## Laboratório:
##	cadastrar um novo laborário;
	POST - https://lab-exame.herokuapp.com/api/laboratorio

	{
	    "nome": "LABORATORIO DE ANALISES CLINICAS",
	    "enderecos": [
		{
		    "logradouro": "RUA ALBERTO LISTRADO",
		    "numero": "11",
		    "cep": "18603270",
		    "bairro": "BAIRRO DA MOCA",
		    "cidade": "SAO PAULO",
		    "uf": "SP",
		    "ddd": "11",
		    "telefone": "38475869"
		}			
	    ]
	}

##	obter uma lista de laboratórios ativos;
	GET - https://lab-exame.herokuapp.com/api/laboratorio/ativos

##  	atualizar um laboratório existente;
	https://lab-exame.herokuapp.com/api/laboratorio/1

	{
	    "nome": "LABORATORIO DE ANALISES CLINICAS ALTERADO",
	    "enderecos": [
		{
		    "logradouro": "RUA ALBERTO LISTRADO ALTERADO",
		    "numero": "11",
		    "cep": "18603270",
		    "bairro": "BAIRRO DA MOCA",
		    "cidade": "SAO PAULO",
		    "uf": "SP",
		    "ddd": "11",
		    "telefone": "38475869"
		}			
	    ]
	}

##  	remover logicamente um laboratório ativo.
	DELETE - https://lab-exame.herokuapp.com/api/laboratorio/2


## Exames:
##  	cadastrar um novo exame;
	POST - https://lab-exame.herokuapp.com/api/exame
	{
	  "nome": "EXAME COLESTEROL",
	  "tipo": "ANALISE"
	}

##	cadastrar um novo exame com um ou mais laboratórios
	POST - https://lab-exame.herokuapp.com/api/exame
	{
	  "nome": "EXAME DIABETE",
	  "tipo": "ANALISE",
	  "laboratorios": [
		{	
		  "id": "1"
		}
	  ]
	}


## 	obter uma lista de exames ativos;
	GET - https://lab-exame.herokuapp.com/api/exame/ativos

##	atualizar um exame existente;
	PUT - https://lab-exame.herokuapp.com/api/exame/1

	{
	  "nome": "EXAME COLTESTEROL ALTERADO",
	  "tipo": "ANALISE",
	  "laboratorios": [
		{	
		  "id": "1"
		}
	  ]
	}

##	remover logicamente um exame ativo.
	DELETE - https://lab-exame.herokuapp.com/api/exame/3

## Associação:
##	associar um exame ativo à um laboratório ativo;
	PUT - https://lab-exame.herokuapp.com/api/exame/1

	{
	  "nome": "EXAME COLTESTEROL ALTERADO",
	  "tipo": "ANALISE",
	  "laboratorios": [
		{	
		  "id": "1"
		},
		{
		  "id": "3"
		}
	  ]
	}

##	desassociar um exame ativo de um laboratório ativo;
	PUT - https://lab-exame.herokuapp.com/api/exame/1
	{
	  "nome": "EXAME COLTESTEROL ALTERADO",
	  "tipo": "ANALISE",
	  "laboratorios": [
		{
		  "id": "3"
		}
	  ]
	}

## Funcionalidades extras

##	remoção em lote;
	DELETE - https://lab-exame.herokuapp.com/api/exame/remover/2

##	Endpoint que faz a busca por nome do exame e retorna todos os laboratorios associados a esse exame.
	GET - https://lab-exame.herokuapp.com/api/exame/ativos?nome=COLESTEROL


## Diferenciais

##	Publicação do ambiente em um serviço cloud de hospedagens (Heroku, AWS, GCP, etc)
	https://lab-exame.herokuapp.com

##	Configurar a aplicação para rodar em um container
	Projeto configurado com para geração da imagem docker.
	Projeto publicado no docker hub: https://hub.docker.com/r/aishac/labexame
	Comando para subir a imagem docker: docker run -p 8080:8080 -t --network host aishac/labexame:01	

##	Documentação da API
	https://lab-exame.herokuapp.com/swagger-ui.html
