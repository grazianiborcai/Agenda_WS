package br.com.mind5.business.storeSnapshot.model.action;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorapMergeToSelect extends ActionStdTemplate<StorapInfo> {

	public StdStorapMergeToSelect(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorapInfo> buildVisitorHook(DeciTreeOption<StorapInfo> option) {
		return new VisiStorapMergeToSelect(option);
	}
}
