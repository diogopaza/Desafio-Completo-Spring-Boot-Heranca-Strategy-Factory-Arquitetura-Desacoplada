# 🧪 Desafio Completo — Spring Boot (Herança + Strategy + Factory + Arquitetura Desacoplada)

---

## 🎯 Objetivo

Construir uma API REST completa que demonstre:

* Herança com JPA (`SINGLE_TABLE`)
* Polimorfismo real
* Strategy Pattern (comportamento)
* Factory Pattern (criação de objetos)
* Arquitetura desacoplada

---

## 🕒 Prazo

* Base obrigatória: **48h**
* Completo (nível avançado): **72h**

---

# 📦 Cenário

Sistema de **Pagamentos**, onde cada tipo possui:

* Estrutura própria (dados)
* Comportamento próprio (processamento)

---

# 🧱 ETAPA 1 — MODELAGEM (HERANÇA)

## Você deve:

* Criar uma classe base **abstrata**
* Configurar herança com `SINGLE_TABLE`
* Definir coluna discriminadora

Criar subclasses:

* Cartão de crédito
* Pix
* Boleto

Cada uma deve possuir atributos próprios

---

## ✅ Resultado esperado:

* Apenas **uma tabela no banco**
* Coluna que identifica o tipo
* Colunas específicas por tipo (com valores nulos quando não aplicável)

---

# 🌐 ETAPA 2 — API REST

## Você deve implementar:

* Criação de pagamentos (endpoint único)
* Listagem de todos os pagamentos
* Busca por ID

---

## ✅ Resultado esperado:

* API funcional
* Dados persistidos corretamente
* Retorno com polimorfismo

---

# 🔁 ETAPA 3 — POLIMORFISMO

## Você deve:

* Buscar dados usando a classe base
* Retornar diretamente os resultados

---

## 🚨 Regras:

* NÃO usar `instanceof`
* NÃO usar `if` baseado em tipo
* NÃO usar `switch`

---

## ✅ Resultado esperado:

* Lista com objetos de tipos diferentes
* Cada objeto com seus próprios campos
* Sistema identifica automaticamente o tipo

---

# 🧱 ETAPA 4 — ARQUITETURA DESACOPLADA

## Você deve separar:

* Controller → entrada/saída
* Service → regras de negócio
* Repository → acesso ao banco
* DTO → entrada/saída da API

---

## ✅ Resultado esperado:

* Código organizado
* Baixo acoplamento
* Responsabilidades bem definidas

---

# 🏭 ETAPA 5 — FACTORY PATTERN (CRIAÇÃO)

## Você deve:

* Criar uma estrutura responsável por instanciar os tipos de pagamento
* Receber dados genéricos (com tipo)
* Retornar o objeto correto

---

## 🚨 Regras:

* Controller NÃO pode instanciar objetos diretamente
* Service NÃO deve conter lógica de criação

---

## ✅ Resultado esperado:

* Criação centralizada
* Fácil adição de novos tipos
* Código limpo e extensível

---

# ⚙️ ETAPA 6 — STRATEGY PATTERN (COMPORTAMENTO)

## Você deve:

* Criar uma estrutura para processar pagamentos
* Cada tipo deve ter seu próprio comportamento

---

## Você deve implementar:

* Interface de comportamento
* Implementações separadas por tipo

---

## 🚨 Regras:

* NÃO usar `if` ou `switch` para decidir comportamento
* NÃO usar `instanceof`

---

## ✅ Resultado esperado:

* Cada tipo processa de forma diferente
* Sistema escolhe automaticamente o comportamento correto
* Código aberto para extensão

---

# 🔗 ETAPA 7 — INTEGRAÇÃO (FLUXO COMPLETO)

## Fluxo esperado:

1. Receber requisição com tipo de pagamento
2. Factory cria o objeto correto
3. Objeto é salvo no banco
4. Sistema recupera o objeto
5. Strategy correta é aplicada automaticamente
6. Resultado é retornado

---

## ✅ Resultado esperado:

* Fluxo completo funcionando
* Sem lógica condicional baseada em tipo
* Total desacoplamento

---

# 🛑 ETAPA 8 — VALIDAÇÃO E ERROS

## Você deve:

* Validar dados de entrada
* Tratar:

  * Tipo inválido
  * Campos obrigatórios
  * ID inexistente

---

## ✅ Resultado esperado:

* API robusta
* Erros controlados
* Mensagens claras

---

# 📁 ENTREGÁVEIS

## ✅ Código

* Projeto completo e funcional
* Estrutura organizada

---

## ✅ README

Explicando:

* Como rodar o projeto
* Como testar endpoints
* Estrutura da aplicação
* Decisões de arquitetura
* Explicação de:

  * Herança (SINGLE_TABLE)
  * Polimorfismo
  * Strategy Pattern
  * Factory Pattern

---

## ✅ Evidência do banco

* Print da tabela
  OU
* Script SQL

---

# 🧠 CRITÉRIOS DE AVALIAÇÃO

* Modelagem correta de herança
* Uso correto de polimorfismo
* Ausência de lógica condicional baseada em tipo
* Aplicação de Strategy Pattern
* Aplicação de Factory Pattern
* Arquitetura desacoplada
* Clareza e organização do código

---

# ⚠️ ERROS QUE ELIMINAM

* Uso de `instanceof`
* Uso de `if` para decidir tipo
* Lógica de criação espalhada
* Lógica de comportamento acoplada
* Retornar entidades diretamente
* Código sem separação de camadas

---

# 🚀 RESULTADO FINAL ESPERADO

O sistema deve:

* Persistir diferentes tipos em uma única tabela
* Retornar dados polimórficos corretamente
* Criar objetos de forma centralizada
* Processar comportamentos sem condicionais
* Estar preparado para expansão sem alteração de código existente

---

# 💬 OBJETIVO FINAL

Ao concluir este desafio, você deve dominar:

* Herança no JPA (nível real)
* Polimorfismo aplicado
* Strategy Pattern na prática
* Factory Pattern na prática
* Arquitetura desacoplada (nível profissional)

---
