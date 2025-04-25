-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25/04/2025 às 03:44
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `av1`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `colaborador`
--

CREATE TABLE `colaborador` (
  `id` bigint(20) NOT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `idade` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `empresa_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `colaborador`
--

INSERT INTO `colaborador` (`id`, `cargo`, `idade`, `nome`, `empresa_id`) VALUES
(7, 'Infra', 26, 'Caio César', 4),
(8, 'Infra', 27, 'Duarlem', 4),
(9, 'Desenvolvedora Full Stack', 32, 'Ana Paula', 5),
(10, 'Analista de Dados', 29, 'Carlos Eduardo', 5),
(11, 'Gerente de Projetos', 35, 'Fernando Almeida', 6),
(12, 'Designer UX/UI', 28, 'Beatriz Martins', 6),
(13, 'Engenheiro de Software', 40, 'Gabriel Santos', 7),
(14, 'Especialista em Segurança', 25, 'Mariana Lopes', 7),
(15, 'Desenvolvedor Back-End', 29, 'Lucas Mendes', 8),
(16, 'Especialista DevOps', 34, 'Bruna Carvalho', 8),
(17, 'Analista de Sistemas', 30, 'Thiago Pereira', 8),
(18, 'Desenvolvedora Front-End', 26, 'Juliana Costa', 9),
(19, 'Gerente de TI', 38, 'Renato Almeida', 9),
(20, 'Especialista em Cloud', 27, 'Marcela Santos', 9),
(21, 'Analista de Dados', 25, 'Gabriela Monteiro', 10),
(22, 'Engenheiro de Machine Learning', 33, 'Henrique Castro', 10),
(23, 'Cientista de Dados', 28, 'Camila Barbosa', 10),
(24, 'Desenvolvedor Mobile', 31, 'Eduardo Ribeiro', 11),
(25, 'Designer de Produtos', 29, 'Patrícia Fernandes', 11),
(26, 'Consultor de Segurança', 35, 'Ricardo Lopes', 11),
(27, 'Especialista em Inteligência Artificial', 27, 'Ana Beatriz Oliveira', 12),
(28, 'Analista de Redes', 32, 'João Victor Nunes', 12),
(29, 'Gestora de Projetos', 30, 'Daniela Martins', 12);

-- --------------------------------------------------------

--
-- Estrutura para tabela `empresa`
--

CREATE TABLE `empresa` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `empresa`
--

INSERT INTO `empresa` (`id`, `nome`) VALUES
(4, 'TLP'),
(5, 'Tech Solutions'),
(6, 'Digital Corp'),
(7, 'InovaTech'),
(8, 'InnovateX'),
(9, 'NextTech Solutions'),
(10, 'SmartLabs'),
(11, 'FutureWorks'),
(12, 'VisionaryCorp');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `colaborador`
--
ALTER TABLE `colaborador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4280c1cy6m7y706okib7puela` (`empresa_id`);

--
-- Índices de tabela `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `colaborador`
--
ALTER TABLE `colaborador`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de tabela `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `colaborador`
--
ALTER TABLE `colaborador`
  ADD CONSTRAINT `FK4280c1cy6m7y706okib7puela` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
