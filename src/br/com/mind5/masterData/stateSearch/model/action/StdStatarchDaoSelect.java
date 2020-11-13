package br.com.mind5.masterData.stateSearch.model.action;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStatarchDaoSelect extends ActionStdTemplate<StatarchInfo> {

	public StdStatarchDaoSelect(DeciTreeOption<StatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StatarchInfo> buildVisitorHook(DeciTreeOption<StatarchInfo> option) {
		return new VisiStatarchDaoSelect(option);
	}
}
