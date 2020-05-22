package br.com.mind5.masterData.entityCategory.model.action;

import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEntitegDaoSelect extends ActionStdTemplateV2<EntitegInfo> {

	public StdEntitegDaoSelect(DeciTreeOption<EntitegInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EntitegInfo> buildVisitorHook(DeciTreeOption<EntitegInfo> option) {
		return new VisiEntitegDaoSelect(option);
	}
}
