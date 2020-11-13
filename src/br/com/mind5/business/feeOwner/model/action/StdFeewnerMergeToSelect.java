package br.com.mind5.business.feeOwner.model.action;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeewnerMergeToSelect extends ActionStdTemplate<FeewnerInfo> {

	public StdFeewnerMergeToSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FeewnerInfo> buildVisitorHook(DeciTreeOption<FeewnerInfo> option) {
		return new VisiFeewnerMergeToSelect(option);
	}
}
