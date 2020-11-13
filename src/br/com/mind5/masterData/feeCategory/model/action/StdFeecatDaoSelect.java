package br.com.mind5.masterData.feeCategory.model.action;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeecatDaoSelect extends ActionStdTemplate<FeecatInfo> {

	public StdFeecatDaoSelect(DeciTreeOption<FeecatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FeecatInfo> buildVisitorHook(DeciTreeOption<FeecatInfo> option) {
		return new VisiFeecatDaoSelect(option);
	}
}
