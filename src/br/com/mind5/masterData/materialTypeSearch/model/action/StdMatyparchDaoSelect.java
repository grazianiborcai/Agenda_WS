package br.com.mind5.masterData.materialTypeSearch.model.action;

import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatyparchDaoSelect extends ActionStdTemplate<MatyparchInfo> {

	public StdMatyparchDaoSelect(DeciTreeOption<MatyparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatyparchInfo> buildVisitorHook(DeciTreeOption<MatyparchInfo> option) {
		return new VisiMatyparchDaoSelect(option);
	}
}
