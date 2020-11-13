package br.com.mind5.business.company.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.StdCompDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompCheckExist extends ModelCheckerTemplateAction<CompInfo, CompInfo> {
	
	public CompCheckExist(ModelCheckerOption option) {
		super(option, CompInfo.class);
	}
	
	
	
	@Override protected ActionStd<CompInfo> buildActionHook(DeciTreeOption<CompInfo> option) {
		ActionStd<CompInfo> select = new StdCompDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COMPANY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_NOT_FOUND;
	}
}
