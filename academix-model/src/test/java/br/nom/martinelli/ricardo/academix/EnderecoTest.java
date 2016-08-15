package br.nom.martinelli.ricardo.academix;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.nom.martinelli.ricardo.academix.model.Endereco;
import br.nom.martinelli.ricardo.academix.rest.RestApplication;
import br.nom.martinelli.ricardo.academix.service.EnderecoResource;
import br.nom.martinelli.ricardo.academix.types.UF;

@RunWith(Arquillian.class)
public class EnderecoTest {
	
	@ArquillianResource
	private URL deploymentURL;

	@Deployment(testable = false)
	public static Archive<?> createDeployment() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class)
				.addPackage(Endereco.class.getPackage())
				.addClasses(RestApplication.class, EnderecoResource.class);
		// System.out.println(archive.toString(true));
		return archive;
	}

	@Test
	public void testAdicionaEndereco(@ArquillianResteasyResource EnderecoResource enderecoResource) {
		Endereco endereco = new Endereco();
		endereco.setCep("04538132");
		endereco.setLogradouro("Avenida almeida prado");
		endereco.setBairro("vila formosa");
		endereco.setCidade("Sao paulo");
		endereco.setUf(UF.SP);
		
		enderecoResource.adicionaEndereco(endereco);
	}

}
