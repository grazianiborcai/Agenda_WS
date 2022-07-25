package br.com.mind5.masterData.refundPolicy.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicy.model.action.RefupoVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupoCheckExist extends ModelCheckerTemplateAction<RefupoInfo, RefupoInfo> {
	
	public RefupoCheckExist(ModelCheckerOption option) {
		super(option, RefupoInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefupoInfo> buildActionHook(DeciTreeOption<RefupoInfo> option) {
		ActionStd<RefupoInfo> select = new ActionStdCommom<RefupoInfo>(option, RefupoVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUND_POLICY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_POLICY_NOT_FOUND;
	}
}
