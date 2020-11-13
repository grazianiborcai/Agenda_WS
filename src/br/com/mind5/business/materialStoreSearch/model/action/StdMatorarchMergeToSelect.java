package br.com.mind5.business.materialStoreSearch.model.action;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatorarchMergeToSelect extends ActionStdTemplate<MatorarchInfo> {

	public StdMatorarchMergeToSelect(DeciTreeOption<MatorarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatorarchInfo> buildVisitorHook(DeciTreeOption<MatorarchInfo> option) {
		return new VisiMatorarchMergeToSelect(option);
	}
}
