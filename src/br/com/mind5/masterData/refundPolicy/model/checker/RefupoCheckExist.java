package br.com.mind5.masterData.refundPolicy.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicy.model.action.StdRefupoDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupoCheckExist extends ModelCheckerTemplateActionV2<RefupoInfo, RefupoInfo> {
	
	public RefupoCheckExist(ModelCheckerOption option) {
		super(option, RefupoInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<RefupoInfo> buildActionHook(DeciTreeOption<RefupoInfo> option) {
		ActionStdV2<RefupoInfo> select = new StdRefupoDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUND_POLICY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_POLICY_NOT_FOUND;
	}
}
