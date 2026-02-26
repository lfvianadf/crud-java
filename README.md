# Gerenciador de Notas - ESIG

Projeto desenvolvido por **Luís Felipe** como parte do processo seletivo da ESIG Group.

Uma aplicação web para gerenciamento de notas com autenticação de usuário.

🔗 **Acesse online:** https://crud-java-production-d531.up.railway.app/login.xhtml

---

## Tecnologias

- Java 8
- JSF 2.2 (Mojarra)
- PrimeFaces 8
- Hibernate 5.6 + JPA
- H2 Database (em memória)
- Apache Tomcat 9
- Maven

---

## Funcionalidades

- **Login** — autenticação simples para acesso ao sistema
- **Cadastrar nota** — título e descrição com data de criação automática
- **Listar notas** — tabela com todas as notas cadastradas
- **Editar nota** — carrega os dados no formulário para alteração
- **Excluir nota** — remove a nota da base de dados

---

## Como rodar localmente

**Pré-requisitos:** Java 8, Maven e Tomcat 9 instalados.

```bash
# Clone o repositório
git clone https://github.com/lfvianadf/crud-esig.git

# Entre na pasta
cd crud-esig

# Build
mvn clean package

# Deploy no Tomcat
# Copie o .war gerado em /target para a pasta webapps do Tomcat
```

**Login padrão:**
- Usuário: `admin`
- Senha: `123`

---

## Estrutura do projeto

```
src/
├── main/
│   ├── java/com/viana/
│   │   ├── bean/        # ManagedBeans (NotaBean, LoginBean)
│   │   ├── filter/      # Filtro de autenticação
│   │   ├── model/       # Entidade Nota
│   │   └── util/        # JPAUtil
│   ├── resources/
│   │   └── META-INF/persistence.xml
│   └── webapp/
│       ├── index.xhtml  # Tela principal
│       └── login.xhtml  # Tela de login
```
