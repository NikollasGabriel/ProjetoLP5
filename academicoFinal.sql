-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 15-Maio-2018 às 07:33
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `academico`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `idPessoa` int(11) NOT NULL,
  `nomeAluno` varchar(45) DEFAULT NULL,
  `idadeAluno` int(11) DEFAULT NULL,
  `Turma_idTurma` int(11) NOT NULL,
  `numeroFaltas` int(11) DEFAULT NULL,
  `mediaNotas` float DEFAULT NULL,
  `situacao` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`idPessoa`, `nomeAluno`, `idadeAluno`, `Turma_idTurma`, `numeroFaltas`, `mediaNotas`, `situacao`) VALUES
(2, 'jonas', 25, 1, 1, 10, 'Reprovado por Nota'),
(3, 'roberto', 20, 7, 0, 60.3333, 'Aprovado por Nota');

-- --------------------------------------------------------

--
-- Estrutura da tabela `coordenador`
--

CREATE TABLE `coordenador` (
  `idCoordenador` int(11) NOT NULL,
  `nomeCoordenador` varchar(45) DEFAULT NULL,
  `idadeCoordenador` int(11) DEFAULT NULL,
  `salarioBase` float DEFAULT NULL,
  `tempoServico` int(11) DEFAULT NULL,
  `ViceCoordenador_idViceCoordenador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `coordenador`
--

INSERT INTO `coordenador` (`idCoordenador`, `nomeCoordenador`, `idadeCoordenador`, `salarioBase`, `tempoServico`, `ViceCoordenador_idViceCoordenador`) VALUES
(1, 'Joaoooooo', 400, 5000, 20, 1),
(2, 'Roberto', 34, 5000, 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `idDisciplina` int(11) NOT NULL,
  `nomeDisciplina` varchar(45) DEFAULT NULL,
  `numeroCreditos` int(11) DEFAULT NULL,
  `numeroVagas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`idDisciplina`, `nomeDisciplina`, `numeroCreditos`, `numeroVagas`) VALUES
(1, 'Historia', 25, 20),
(2, 'Matematica', 33, 50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `idPessoa` int(11) NOT NULL,
  `nomeProfessor` varchar(45) DEFAULT NULL,
  `idadeProfessor` int(11) DEFAULT NULL,
  `numeroFaltas` int(11) DEFAULT NULL,
  `nivelEnsinoSuperior` varchar(45) DEFAULT NULL,
  `salarioBase` float DEFAULT NULL,
  `tempoServico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`idPessoa`, `nomeProfessor`, `idadeProfessor`, `numeroFaltas`, `nivelEnsinoSuperior`, `salarioBase`, `tempoServico`) VALUES
(2, 'George', 49, 0, 'foda', 6000, 20),
(3, 'John', 45, 0, 'foda', 5000, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova`
--

CREATE TABLE `prova` (
  `idProva` int(11) NOT NULL,
  `valor` int(11) DEFAULT NULL,
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `Pessoa_idPessoa` int(11) NOT NULL,
  `Professor_idPessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `prova`
--

INSERT INTO `prova` (`idProva`, `valor`, `Disciplina_idDisciplina`, `Pessoa_idPessoa`, `Professor_idPessoa`) VALUES
(9, 10, 1, 2, 2),
(10, 10, 1, 2, 2),
(11, 10, 1, 2, 2),
(12, 61, 2, 3, 3),
(13, 60, 2, 3, 3),
(14, 60, 2, 3, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `idTurma` int(11) NOT NULL,
  `periodo` varchar(45) DEFAULT NULL,
  `tamanho` int(11) DEFAULT NULL,
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `Coordenador_idCoordenador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`idTurma`, `periodo`, `tamanho`, `Disciplina_idDisciplina`, `Coordenador_idCoordenador`) VALUES
(1, '222', 202, 1, 1),
(7, '999', 88, 1, 1),
(9, '9999', 4564654, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vicecoordenador`
--

CREATE TABLE `vicecoordenador` (
  `idViceCoordenador` int(11) NOT NULL,
  `nomeViceCoordenador` varchar(45) DEFAULT NULL,
  `idadeViceCoordenador` int(11) DEFAULT NULL,
  `salarioBase` float DEFAULT NULL,
  `tempoServico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `vicecoordenador`
--

INSERT INTO `vicecoordenador` (`idViceCoordenador`, `nomeViceCoordenador`, `idadeViceCoordenador`, `salarioBase`, `tempoServico`) VALUES
(1, 'Ze', 30, 1000, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`idPessoa`),
  ADD KEY `fk_Pessoa_Turma1_idx` (`Turma_idTurma`);

--
-- Indexes for table `coordenador`
--
ALTER TABLE `coordenador`
  ADD PRIMARY KEY (`idCoordenador`),
  ADD KEY `fk_Coordenador_ViceCoordenador1_idx` (`ViceCoordenador_idViceCoordenador`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`idDisciplina`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`idPessoa`);

--
-- Indexes for table `prova`
--
ALTER TABLE `prova`
  ADD PRIMARY KEY (`idProva`),
  ADD KEY `fk_Prova_Disciplina1_idx` (`Disciplina_idDisciplina`),
  ADD KEY `fk_Prova_Pessoa1_idx` (`Pessoa_idPessoa`),
  ADD KEY `fk_Prova_Professor1_idx` (`Professor_idPessoa`);

--
-- Indexes for table `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`idTurma`),
  ADD KEY `fk_Turma_Disciplina1_idx` (`Disciplina_idDisciplina`),
  ADD KEY `fk_Turma_Coordenador1_idx` (`Coordenador_idCoordenador`);

--
-- Indexes for table `vicecoordenador`
--
ALTER TABLE `vicecoordenador`
  ADD PRIMARY KEY (`idViceCoordenador`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `idPessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `coordenador`
--
ALTER TABLE `coordenador`
  MODIFY `idCoordenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `idDisciplina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `idPessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `prova`
--
ALTER TABLE `prova`
  MODIFY `idProva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `turma`
--
ALTER TABLE `turma`
  MODIFY `idTurma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `vicecoordenador`
--
ALTER TABLE `vicecoordenador`
  MODIFY `idViceCoordenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_Pessoa_Turma1` FOREIGN KEY (`Turma_idTurma`) REFERENCES `turma` (`idTurma`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `coordenador`
--
ALTER TABLE `coordenador`
  ADD CONSTRAINT `fk_Coordenador_ViceCoordenador1` FOREIGN KEY (`ViceCoordenador_idViceCoordenador`) REFERENCES `vicecoordenador` (`idViceCoordenador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `prova`
--
ALTER TABLE `prova`
  ADD CONSTRAINT `fk_Prova_Disciplina1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Prova_Pessoa1` FOREIGN KEY (`Pessoa_idPessoa`) REFERENCES `aluno` (`idPessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Prova_Professor1` FOREIGN KEY (`Professor_idPessoa`) REFERENCES `professor` (`idPessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `fk_Turma_Coordenador1` FOREIGN KEY (`Coordenador_idCoordenador`) REFERENCES `coordenador` (`idCoordenador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Turma_Disciplina1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
