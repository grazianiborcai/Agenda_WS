package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatarchObfuscateCodStore extends ActionStdTemplateV2<MatarchInfo> {

	public StdMatarchObfuscateCodStore(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatarchInfo> buildVisitorHook(DeciTreeOption<MatarchInfo> option) {
		return new VisiMatarchObfuscateCodStore(option);
	}
}
