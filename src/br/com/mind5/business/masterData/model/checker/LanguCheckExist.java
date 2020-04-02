package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.action.StdLanguSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LanguCheckExist extends ModelCheckerTemplateAction<LanguInfo, LanguInfo> {
		
	public LanguCheckExist(ModelCheckerOption option) {
		super(option, LanguInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<LanguInfo> buildActionHook(DeciTreeOption<LanguInfo> option) {
		ActionStdV1<LanguInfo> select = new StdLanguSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.LANGUAGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.LANGUAGE_NOT_FOUND;
	}
}
