package br.com.mind5.masterData.language.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.action.StdLanguDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LanguCheckExist extends ModelCheckerTemplateActionV2<LanguInfo, LanguInfo> {
		
	public LanguCheckExist(ModelCheckerOption option) {
		super(option, LanguInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<LanguInfo> buildActionHook(DeciTreeOption<LanguInfo> option) {
		ActionStdV2<LanguInfo> select = new StdLanguDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.LANGUAGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.LANGUAGE_NOT_FOUND;
	}
}
