package br.com.mind5.masterData.petWeightSearch.model.action;

import br.com.mind5.masterData.petWeightSearch.info.PeteightarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPeteightarchDaoSelect extends ActionStdTemplate<PeteightarchInfo> {

	public StdPeteightarchDaoSelect(DeciTreeOption<PeteightarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PeteightarchInfo> buildVisitorHook(DeciTreeOption<PeteightarchInfo> option) {
		return new VisiPeteightarchDaoSelect(option);
	}
}
