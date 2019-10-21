package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.action.StdLanguSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LanguCheckExist extends ModelCheckerTemplateActionV2<LanguInfo, LanguInfo> {
		
	public LanguCheckExist(ModelCheckerOption option) {
		super(option, LanguInfo.class);
	}
	
	
	
	@Override protected ActionStd<LanguInfo> buildActionHook(DeciTreeOption<LanguInfo> option) {
		ActionStd<LanguInfo> actionSelect = new StdLanguSelect(option);
		return actionSelect;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.LANGUAGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.LANGUAGE_NOT_FOUND;
	}
}
