package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.model.decisionTree.RootRefugritarchSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugritarchCheckExist extends ModelCheckerTemplateActionV2<RefugritarchInfo, RefugritarchInfo> {
	
	public RefugritarchCheckExist(ModelCheckerOption option) {
		super(option, RefugritarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<RefugritarchInfo> buildActionHook(DeciTreeOption<RefugritarchInfo> option) {
		ActionStdV2<RefugritarchInfo> select = new RootRefugritarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_GR_ITM_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_ITM_SEARCH_NOT_FOUND;
	}
}
