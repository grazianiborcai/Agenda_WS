package br.com.mind5.masterData.languageSearch.model.action;

import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdLangarchDaoSelect extends ActionStdTemplate<LangarchInfo> {

	public StdLangarchDaoSelect(DeciTreeOption<LangarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<LangarchInfo> buildVisitorHook(DeciTreeOption<LangarchInfo> option) {
		return new VisiLangarchDaoSelect(option);
	}
}
