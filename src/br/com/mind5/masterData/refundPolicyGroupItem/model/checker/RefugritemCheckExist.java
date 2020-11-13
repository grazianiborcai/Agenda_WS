package br.com.mind5.masterData.refundPolicyGroupItem.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.StdRefugritemDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugritemCheckExist extends ModelCheckerTemplateActionV2<RefugritemInfo, RefugritemInfo> {
	
	public RefugritemCheckExist(ModelCheckerOption option) {
		super(option, RefugritemInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<RefugritemInfo> buildActionHook(DeciTreeOption<RefugritemInfo> option) {
		ActionStdV2<RefugritemInfo> select = new StdRefugritemDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_GR_ITM_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_ITM_NOT_FOUND;
	}
}
