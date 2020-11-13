package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.model.decisionTree.RootRefugritarchSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugritarchCheckExist extends ModelCheckerTemplateAction<RefugritarchInfo, RefugritarchInfo> {
	
	public RefugritarchCheckExist(ModelCheckerOption option) {
		super(option, RefugritarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefugritarchInfo> buildActionHook(DeciTreeOption<RefugritarchInfo> option) {
		ActionStd<RefugritarchInfo> select = new RootRefugritarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.REFUPOL_GR_ITM_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_ITM_SEARCH_NOT_FOUND;
	}
}
