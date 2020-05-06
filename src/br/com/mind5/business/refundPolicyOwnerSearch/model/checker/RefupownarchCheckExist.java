package br.com.mind5.business.refundPolicyOwnerSearch.model.checker;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.model.decisionTree.RootRefupownarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownarchCheckExist extends ModelCheckerTemplateActionV2<RefupownarchInfo, RefupownarchInfo> {
	
	public RefupownarchCheckExist(ModelCheckerOption option) {
		super(option, RefupownarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<RefupownarchInfo> buildActionHook(DeciTreeOption<RefupownarchInfo> option) {
		ActionStdV1<RefupownarchInfo> select = new RootRefupownarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_OWNER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_OWNER_SEARCH_NOT_FOUND;
	}
}
