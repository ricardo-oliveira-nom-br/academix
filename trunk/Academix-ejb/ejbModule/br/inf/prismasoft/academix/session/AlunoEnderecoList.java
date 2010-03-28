package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("alunoEnderecoList")
public class AlunoEnderecoList extends EntityQuery<AlunoEndereco> {

	private static final long serialVersionUID = 4503209895993733781L;

	private static final String EJBQL = "select alunoEndereco from AlunoEndereco alunoEndereco";

	private static final String[] RESTRICTIONS = {
			"lower(alunoEndereco.id.indEndereco) like lower(concat(#{alunoEnderecoList.alunoEndereco.id.indEndereco},'%'))",
			"lower(alunoEndereco.desComplemento) like lower(concat(#{alunoEnderecoList.alunoEndereco.desComplemento},'%'))",
			"lower(alunoEndereco.indTipoEndereco) like lower(concat(#{alunoEnderecoList.alunoEndereco.indTipoEndereco},'%'))", };

	private AlunoEndereco alunoEndereco;

	public AlunoEnderecoList() {
		alunoEndereco = new AlunoEndereco();
		alunoEndereco.setId(new AlunoEnderecoId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public AlunoEndereco getAlunoEndereco() {
		return alunoEndereco;
	}
}
