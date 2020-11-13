package br.com.mind5.business.ownerList.model.action;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnelisDaoSelect extends ActionStdTemplate<OwnelisInfo> {

	public StdOwnelisDaoSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OwnelisInfo> buildVisitorHook(DeciTreeOption<OwnelisInfo> option) {
		return new VisiOwnelisDaoSelect(option);
	}
}
