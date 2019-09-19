package br.com.gda.business.masterData.model.checker;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.model.action.StdLanguSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
