package br.com.mind5.business.refundPolicyStore.model.checker;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeCheckExist extends ModelCheckerTemplateActionV2<RefuporeInfo, RefuporeInfo> {
	
	public RefuporeCheckExist(ModelCheckerOption option) {
		super(option, RefuporeInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<RefuporeInfo> buildActionHook(DeciTreeOption<RefuporeInfo> option) {
		ActionStdV1<RefuporeInfo> select = new StdRefuporeDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_STORE_NOT_FOUND;
	}
}
