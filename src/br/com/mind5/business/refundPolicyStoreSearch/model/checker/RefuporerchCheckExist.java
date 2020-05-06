package br.com.mind5.business.refundPolicyStoreSearch.model.checker;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.model.decisionTree.RootRefuporerchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporerchCheckExist extends ModelCheckerTemplateActionV2<RefuporerchInfo, RefuporerchInfo> {
	
	public RefuporerchCheckExist(ModelCheckerOption option) {
		super(option, RefuporerchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<RefuporerchInfo> buildActionHook(DeciTreeOption<RefuporerchInfo> option) {
		ActionStdV1<RefuporerchInfo> select = new RootRefuporerchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_STORE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_STORE_SEARCH_NOT_FOUND;
	}
}
