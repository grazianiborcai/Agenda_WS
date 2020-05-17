package br.com.mind5.business.refundPolicyOwnerSearch.model.checker;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.model.decisionTree.RootRefupowarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupowarchCheckExist extends ModelCheckerTemplateActionV2<RefupowarchInfo, RefupowarchInfo> {
	
	public RefupowarchCheckExist(ModelCheckerOption option) {
		super(option, RefupowarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<RefupowarchInfo> buildActionHook(DeciTreeOption<RefupowarchInfo> option) {		
		ActionStdV1<RefupowarchInfo> select = new RootRefupowarchSelect(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_OWNER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_OWNER_SEARCH_NOT_FOUND;
	}
}
