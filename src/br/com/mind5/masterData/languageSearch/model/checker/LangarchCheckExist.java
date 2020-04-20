package br.com.mind5.masterData.languageSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.action.StdLangarchDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LangarchCheckExist extends ModelCheckerTemplateActionV2<LangarchInfo, LangarchInfo> {
		
	public LangarchCheckExist(ModelCheckerOption option) {
		super(option, LangarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<LangarchInfo> buildActionHook(DeciTreeOption<LangarchInfo> option) {
		ActionStdV1<LangarchInfo> select = new StdLangarchDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.LANGUAGE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.LANGUAGE_SEARCH_NOT_FOUND;
	}
}
