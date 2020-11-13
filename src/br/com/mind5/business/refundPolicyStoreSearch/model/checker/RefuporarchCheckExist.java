package br.com.mind5.business.refundPolicyStoreSearch.model.checker;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.model.decisionTree.RootRefuporarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporarchCheckExist extends ModelCheckerTemplateActionV2<RefuporarchInfo, RefuporarchInfo> {
	
	public RefuporarchCheckExist(ModelCheckerOption option) {
		super(option, RefuporarchInfo.class);
	}
	

	
	@Override protected ActionStdV2<RefuporarchInfo> buildActionHook(DeciTreeOption<RefuporarchInfo> option) {		
		ActionStdV2<RefuporarchInfo> select = new RootRefuporarchSelect(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_STORE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_STORE_SEARCH_NOT_FOUND;
	}
}
