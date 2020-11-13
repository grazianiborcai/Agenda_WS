package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatarchObfuscateCodStore extends ActionStdTemplate<MatarchInfo> {

	public StdMatarchObfuscateCodStore(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatarchInfo> buildVisitorHook(DeciTreeOption<MatarchInfo> option) {
		return new VisiMatarchObfuscateCodStore(option);
	}
}
