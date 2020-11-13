package br.com.mind5.business.storeList.model.action;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdStolisMergeCurrency extends ActionStdTemplate<StolisInfo> {

	public StdStolisMergeCurrency(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StolisInfo> buildVisitorHook(DeciTreeOption<StolisInfo> option) {
		return new VisiStolisMergeCurrency(option);
	}
}
