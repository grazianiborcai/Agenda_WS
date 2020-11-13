package br.com.mind5.business.storeList.model.action;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolisDaoSelect extends ActionStdTemplate<StolisInfo> {

	public StdStolisDaoSelect(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StolisInfo> buildVisitorHook(DeciTreeOption<StolisInfo> option) {
		return new VisiStolisDaoSelect(option);
	}
}
