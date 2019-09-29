package br.com.gda.business.company.model.checker;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.StdCompSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CompCheckExist extends ModelCheckerTemplateActionV2<CompInfo, CompInfo> {
	
	public CompCheckExist(ModelCheckerOption option) {
		super(option, CompInfo.class);
	}
	
	
	
	@Override protected ActionStd<CompInfo> buildActionHook(DeciTreeOption<CompInfo> option) {
		ActionStd<CompInfo> select = new StdCompSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COMPANY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_NOT_FOUND;
	}
}
