package br.com.mind5.masterData.languageSearch.model.action;

import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdLangarchDaoSelect extends ActionStdTemplateV2<LangarchInfo> {

	public StdLangarchDaoSelect(DeciTreeOption<LangarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<LangarchInfo> buildVisitorHook(DeciTreeOption<LangarchInfo> option) {
		return new VisiLangarchDaoSelect(option);
	}
}
