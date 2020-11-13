package br.com.mind5.masterData.entityCategory.model.action;

import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEntitegDaoSelect extends ActionStdTemplate<EntitegInfo> {

	public StdEntitegDaoSelect(DeciTreeOption<EntitegInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EntitegInfo> buildVisitorHook(DeciTreeOption<EntitegInfo> option) {
		return new VisiEntitegDaoSelect(option);
	}
}
