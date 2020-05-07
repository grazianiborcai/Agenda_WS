package br.com.mind5.masterData.refundPolicyGroupHeader.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;
import br.com.mind5.masterData.refundPolicyGroupHeader.model.action.StdRefugraderDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugraderCheckExist extends ModelCheckerTemplateActionV2<RefugraderInfo, RefugraderInfo> {
	
	public RefugraderCheckExist(ModelCheckerOption option) {
		super(option, RefugraderInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<RefugraderInfo> buildActionHook(DeciTreeOption<RefugraderInfo> option) {
		ActionStdV1<RefugraderInfo> select = new StdRefugraderDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_GR_HDR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_HDR_NOT_FOUND;
	}
}
