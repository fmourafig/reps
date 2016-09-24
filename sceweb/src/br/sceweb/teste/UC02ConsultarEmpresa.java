package br.sceweb.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {

	static Empresa resultadoEsperado;
	static Empresa resultadoObtido;
	static EmpresaDAO empresaDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		resultadoEsperado = new Empresa();
		resultadoEsperado.setCnpj("10258787000140");
		resultadoEsperado.setNomeDaEmpresa("Casas Bahia");
		resultadoEsperado.setEndereco("Rua Taquari");
		resultadoEsperado.setNomeFantasia("Casas Bahia");
		resultadoEsperado.setTelefone("11111111");
		empresaDAO = new EmpresaDAO();
		//empresaDAO.exclui("10258787000140");
		empresaDAO.adiciona(resultadoEsperado);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void excluiEmpresa(){
		empresaDAO.exclui("10258787000140");
	}

	@Test
	public void CT01UC02FBConsultarEmpresa_com_sucesso() {
		resultadoObtido = empresaDAO.consulta("10258787000140");
		assertTrue(resultadoEsperado.equals(resultadoObtido));
	}

}
