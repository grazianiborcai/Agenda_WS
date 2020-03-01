package br.com.mind5.payment.systemPartnerSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;
import br.com.mind5.payment.systemPartnerSearch.model.decisionTree.RootSysparchSelect;

public final class SysparchCheckExist extends ModelCheckerTemplateActionV2<SysparchInfo, SysparchInfo> {
	
	public SysparchCheckExist(ModelCheckerOption option) {
		super(option, SysparchInfo.class);
	}
	

	
	@Override protected ActionStd<SysparchInfo> buildActionHook(DeciTreeOption<SysparchInfo> option) {
		ActionStd<SysparchInfo> select = new RootSysparchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_PAYPAR_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_PAYPAR_SEARCH_NOT_FOUND;
	}
}
