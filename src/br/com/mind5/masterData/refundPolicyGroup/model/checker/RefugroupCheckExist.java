package br.com.mind5.masterData.refundPolicyGroup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.action.StdRefugroupDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugroupCheckExist extends ModelCheckerTemplateAction<RefugroupInfo, RefugroupInfo> {
	
	public RefugroupCheckExist(ModelCheckerOption option) {
		super(option, RefugroupInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefugroupInfo> buildActionHook(DeciTreeOption<RefugroupInfo> option) {
		ActionStd<RefugroupInfo> select = new StdRefugroupDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_GR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_NOT_FOUND;
	}
}
