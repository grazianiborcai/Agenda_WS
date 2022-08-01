package br.com.mind5.masterData.languageSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.info.LangarchSetterAll;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LangarchVisiEnforceAll extends ActionVisitorTemplateEnforce<LangarchInfo> {
	
	public LangarchVisiEnforceAll(DeciTreeOption<LangarchInfo> option) {
		super(option);
	}

	
	
	@Override protected LangarchInfo enforceHook(LangarchInfo recordInfo) {
		InfoSetter<LangarchInfo> attrSetter = new LangarchSetterAll();
		return attrSetter.setAttr(recordInfo);
	}
}
