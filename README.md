# 🧪 Desafio Completo — Spring Boot (HERANÇA + JOINED + STRATEGY + FACTORY)

---

## 🎯 Objetivo

Construir uma API REST que demonstre domínio de:

* Herança JPA (`SINGLE_TABLE` e `JOINED`)
* Polimorfismo real
* Strategy Pattern
* Factory Pattern
* Arquitetura desacoplada
* Tomada de decisão arquitetural

---

## 🕒 Prazo

* Base: 48h
* Completo: 72h

---

# 🧠 PARTE 1 — HERANÇA (SINGLE_TABLE)

## Você deve:

* Implementar herança com `SINGLE_TABLE`
* Criar:

  * Classe base abstrata
  * Subclasses (Pix, Cartão, Boleto)

---

## ✅ Resultado esperado:

* Uma única tabela
* Coluna discriminadora
* Colunas nulas para tipos diferentes

---

## ❓ Perguntas (responda no README)

1. Por que `SINGLE_TABLE` pode gerar muitas colunas nulas?
2. Qual vantagem de performance dessa estratégia?
3. Em que cenário ela NÃO seria uma boa escolha?

---

## 🎯 Avaliação (0 a 10)

* Uso correto da herança
* Entendimento conceitual

---

# 🧠 PARTE 2 — HERANÇA (JOINED)

## Você deve:

* Criar uma **segunda versão da modelagem**
* Utilizar `InheritanceType.JOINED`

---

## ✅ Resultado esperado:

* Uma tabela para a classe base
* Uma tabela para cada subclasse
* Relacionamento via chave estrangeira

---

## ❓ Perguntas

1. Qual a principal diferença estrutural entre `SINGLE_TABLE` e `JOINED`?
2. Qual delas tem melhor performance? Por quê?
3. Qual delas evita colunas nulas?
4. Em que cenário você escolheria `JOINED`?

---

## 🎯 Avaliação (0 a 10)

* Clareza na comparação
* Entendimento de trade-offs

---

# 🔁 PARTE 3 — POLIMORFISMO

## Você deve:

* Buscar dados usando a classe base
* Retornar diretamente os objetos

---

## 🚨 Regras:

* NÃO usar `instanceof`
* NÃO usar `if`
* NÃO usar `switch`

---

## ✅ Resultado esperado:

* Lista com múltiplos tipos
* Cada objeto com seus próprios atributos

---

## ❓ Perguntas

1. Como o Hibernate sabe qual classe instanciar?
2. Onde o polimorfismo está acontecendo nesse fluxo?
3. Por que usar `instanceof` quebra o conceito?

---

## 🎯 Avaliação (0 a 10)

* Entendimento de polimorfismo
* Aplicação prática

---

# 🧱 PARTE 4 — ARQUITETURA DESACOPLADA

## Você deve:

Separar corretamente:

* Controller
* Service
* Repository
* DTO

---

## ✅ Resultado esperado:

* Código organizado
* Baixo acoplamento

---

## ❓ Perguntas

1. Por que não devemos colocar regra de negócio no controller?
2. Qual o papel do service?
3. Por que usar DTO ao invés de entidade?

---

## 🎯 Avaliação (0 a 10)

* Organização
* Boas práticas

---

# 🏭 PARTE 5 — FACTORY PATTERN

## Você deve:

* Criar uma estrutura responsável por instanciar pagamentos
* Receber tipo + dados
* Retornar objeto correto

---

## 🚨 Regras:

* NÃO usar `new` fora da factory
* NÃO espalhar lógica de criação

---

## ✅ Resultado esperado:

* Criação centralizada
* Código extensível

---

## ❓ Perguntas

1. Qual problema a Factory resolve?
2. O que acontece se você não usar Factory nesse cenário?
3. Como adicionar um novo tipo sem alterar código existente?

---

## 🎯 Avaliação (0 a 10)

* Uso correto do padrão
* Clareza da solução

---

# ⚙️ PARTE 6 — STRATEGY PATTERN

## Você deve:

* Criar comportamento para processar pagamento
* Cada tipo com lógica própria

---

## 🚨 Regras:

* NÃO usar `if`
* NÃO usar `instanceof`

---

## ✅ Resultado esperado:

* Cada tipo executa comportamento diferente
* Sistema escolhe automaticamente

---

## ❓ Perguntas

1. Qual problema o Strategy resolve?
2. Qual a diferença entre Strategy e herança?
3. Quando usar Strategy ao invés de if/switch?

---

## 🎯 Avaliação (0 a 10)

* Aplicação correta
* Entendimento conceitual

---

# 🔗 PARTE 7 — FLUXO COMPLETO

## Você deve implementar:

Fluxo completo:

1. Receber requisição
2. Factory cria objeto
3. Salvar no banco
4. Recuperar objeto
5. Aplicar Strategy
6. Retornar resposta

---

## ✅ Resultado esperado:

* Sistema funcionando ponta a ponta
* Sem lógica condicional baseada em tipo

---

## ❓ Perguntas

1. Onde estão aplicados os princípios SOLID?
2. O sistema está aberto para extensão? Explique.
3. O que aconteceria ao adicionar um novo tipo de pagamento?

---

## 🎯 Avaliação (0 a 10)

* Integração
* Arquitetura

---

# 🛑 PARTE 8 — VALIDAÇÃO E ERROS

## Você deve:

* Validar entradas
* Tratar erros

---

## ✅ Resultado esperado:

* API robusta
* Respostas claras

---

## ❓ Perguntas

1. Por que validar na entrada é importante?
2. Qual o impacto de não tratar erros?

---

## 🎯 Avaliação (0 a 10)

* Robustez
* Qualidade

---

# 📊 AVALIAÇÃO FINAL

Você deve se autoavaliar:

| Etapa                | Nota (0–10) |
| -------------------- | ----------- |
| Herança SINGLE_TABLE |             |
| Herança JOINED       |             |
| Polimorfismo         |             |
| Arquitetura          |             |
| Factory              |             |
| Strategy             |             |
| Integração           |             |
| Validação            |             |

---

# 🏁 RESULTADO FINAL ESPERADO

Você deve demonstrar:

* Domínio de herança no JPA
* Capacidade de modelagem
* Uso correto de padrões de projeto
* Arquitetura limpa
* Código preparado para crescimento

---

# 💬 INSTRUÇÃO FINAL

Após concluir:

* Responda todas as perguntas
* Me envie suas respostas
* Me envie seu código

👉 Eu vou te avaliar como em uma entrevista técnica real (com nota e feedback detalhado)

---

# 🧠 Respsotas
# 🧠 PARTE 1 — HERANÇA (SINGLE_TABLE)
## ❓ Perguntas (responda no README)

1. Por que `SINGLE_TABLE` pode gerar muitas colunas nulas?
   R: Na estrategia Sinlge Table e usada Heranca simples, dessa forma o JPA cria unica tabela para as subclasses oriundas
   da classe principal (ou classe mae). Cada subclasse pode ter varios atributos e nao necessariamente iguais umas das outras, com isso em um insert na tabela A por exemplo os atributos que existem na tabela A e nao existem na tabela B irao ficar null na tabela b, ou seja a Tabela Geral que no banco de dados e mesma de para A e B apenas tem um dtype diferente, tende a ter varias colunas com null. 
3. Qual vantagem de performance dessa estratégia?
   R: Eu acredito que e possivel o uso de indices conforme demonstrado no codigo. 
5. Em que cenário ela NÃO seria uma boa escolha?

