package br.com.mind5.business.storeProspectSearch.model.action;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoprarchDaoSelect extends ActionStdTemplate<StoprarchInfo> {

	public StdStoprarchDaoSelect(DeciTreeOption<StoprarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoprarchInfo> buildVisitorHook(DeciTreeOption<StoprarchInfo> option) {
		return new VisiStoprarchDaoSelect(option);
	}
}
