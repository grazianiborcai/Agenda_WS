package br.com.mind5.masterData.materialGroupSearch.model.action;

import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatouparchDaoSelect extends ActionStdTemplate<MatouparchInfo> {

	public StdMatouparchDaoSelect(DeciTreeOption<MatouparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatouparchInfo> buildVisitorHook(DeciTreeOption<MatouparchInfo> option) {
		return new VisiMatouparchDaoSelect(option);
	}
}
