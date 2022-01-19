package br.com.mind5.masterData.petWeight.model.action;

import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPeteightDaoSelect extends ActionStdTemplate<PeteightInfo> {

	public StdPeteightDaoSelect(DeciTreeOption<PeteightInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PeteightInfo> buildVisitorHook(DeciTreeOption<PeteightInfo> option) {
		return new VisiPeteightDaoSelect(option);
	}
}
