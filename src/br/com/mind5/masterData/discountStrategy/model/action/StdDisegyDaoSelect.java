package br.com.mind5.masterData.discountStrategy.model.action;

import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDisegyDaoSelect extends ActionStdTemplate<DisegyInfo> {

	public StdDisegyDaoSelect(DeciTreeOption<DisegyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<DisegyInfo> buildVisitorHook(DeciTreeOption<DisegyInfo> option) {
		return new VisiDisegyDaoSelect(option);
	}
}
