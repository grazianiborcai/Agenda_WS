package br.com.mind5.masterData.languageSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.action.StdLangarchDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LangarchCheckExist extends ModelCheckerTemplateAction<LangarchInfo, LangarchInfo> {
		
	public LangarchCheckExist(ModelCheckerOption option) {
		super(option, LangarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<LangarchInfo> buildActionHook(DeciTreeOption<LangarchInfo> option) {
		ActionStd<LangarchInfo> select = new StdLangarchDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.LANGUAGE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.LANGUAGE_SEARCH_NOT_FOUND;
	}
}
