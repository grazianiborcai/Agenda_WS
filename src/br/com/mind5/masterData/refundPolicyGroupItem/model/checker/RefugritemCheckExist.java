package br.com.mind5.masterData.refundPolicyGroupItem.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.RefugritemVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugritemCheckExist extends ModelCheckerTemplateAction<RefugritemInfo, RefugritemInfo> {
	
	public RefugritemCheckExist(ModelCheckerOption option) {
		super(option, RefugritemInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefugritemInfo> buildActionHook(DeciTreeOption<RefugritemInfo> option) {
		ActionStd<RefugritemInfo> select = new ActionStdCommom<RefugritemInfo>(option, RefugritemVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_GR_ITM_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_ITM_NOT_FOUND;
	}
}
