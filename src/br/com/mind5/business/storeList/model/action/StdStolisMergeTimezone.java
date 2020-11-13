package br.com.mind5.business.storeList.model.action;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdStolisMergeTimezone extends ActionStdTemplate<StolisInfo> {

	public StdStolisMergeTimezone(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StolisInfo> buildVisitorHook(DeciTreeOption<StolisInfo> option) {
		return new VisiStolisMergeTimezone(option);
	}
}
