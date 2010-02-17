package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("enderecoList")
public class EnderecoList extends EntityQuery<Endereco> {

	private static final String EJBQL = "select endereco from Endereco endereco";

	private static final String[] RESTRICTIONS = {
			"lower(endereco.idtCep) like lower(concat(#{enderecoList.endereco.idtCep},'%'))",
			"lower(endereco.desBairro) like lower(concat(#{enderecoList.endereco.desBairro},'%'))",
			"lower(endereco.desCidade) like lower(concat(#{enderecoList.endereco.desCidade},'%'))",
			"lower(endereco.desLogradouro) like lower(concat(#{enderecoList.endereco.desLogradouro},'%'))",
			"lower(endereco.desUf) like lower(concat(#{enderecoList.endereco.desUf},'%'))", };

	private Endereco endereco = new Endereco();

	public EnderecoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Endereco getEndereco() {
		return endereco;
	}
}
