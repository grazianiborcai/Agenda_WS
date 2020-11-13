package br.com.mind5.masterData.language.model.action;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdLanguDaoSelect extends ActionStdTemplate<LanguInfo> {

	public StdLanguDaoSelect(DeciTreeOption<LanguInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<LanguInfo> buildVisitorHook(DeciTreeOption<LanguInfo> option) {
		return new VisiLanguDaoSelect(option);
	}
}
