Gerenciador de Funcionários

Este projeto é um sistema de gerenciamento de funcionários que realiza diversas operações como cadastramento, remoção, aumento de salário, agrupamento por função e cálculo da quantidade de salários mínimos equivalentes ao salário de cada funcionário.

Funcionalidades

Adicionar Funcionários com nome, data de nascimento, salário e função.

Remover Funcionários pelo nome.

Aplicar aumento de 10% no salário de todos os funcionários.

Exibir a lista de funcionários agrupados por função.

Calcular a média de salários mínimos equivalentes ao salário dos funcionários.

Ordenar os funcionários por nome.

Exibir os aniversariantes de outubro e dezembro.

Encontrar e exibir o funcionário mais velho.

📚 Estrutura do Código

O código é estruturado da seguinte forma:

Funcionario → Classe que representa um funcionário.

Gerenciar → Classe principal que gerencia a lista de funcionários e executa as funcionalidades.

Métodos principais:

insertEmploye() → Adiciona novos funcionários.

removeEmploye() → Remove um funcionário pelo nome.

increaseSalaryEmploye() → Aplica aumento de 10% no salário.

groupByFunction() → Agrupa os funcionários por função.

medMinSalary() → Calcula a quantidade de salários mínimos equivalente ao salário dos funcionários.

printEmploye() → Exibe os funcionários formatados corretamente.

printEmployeesByBirthdayMonth() → Exibe os aniversariantes de outubro e dezembro.

printOldestEmployee() → Exibe o funcionário mais velho.

🛠️ Decisões de Implementação

BigDecimal foi usado para cálculos financeiros, garantindo precisão.

Stream API foi utilizada para filtragem e ordenação de dados.

Formatação de saída foi ajustada para manter o alinhamento correto das colunas.

Separar métodos de cálculo e exibição ajuda na reutilização do código.