package br.com.mind5.masterData.prospectStatusSearch.model.action;

import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdProstarchDaoSelect extends ActionStdTemplate<ProstarchInfo> {

	public StdProstarchDaoSelect(DeciTreeOption<ProstarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<ProstarchInfo> buildVisitorHook(DeciTreeOption<ProstarchInfo> option) {
		return new VisiProstarchDaoSelect(option);
	}
}
