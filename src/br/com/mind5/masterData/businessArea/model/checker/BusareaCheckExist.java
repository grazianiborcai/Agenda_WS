package br.com.mind5.masterData.businessArea.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.action.StdBusareaDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BusareaCheckExist extends ModelCheckerTemplateAction<BusareaInfo, BusareaInfo> {
	
	public BusareaCheckExist(ModelCheckerOption option) {
		super(option, BusareaInfo.class);
	}
	
	
	
	@Override protected ActionStd<BusareaInfo> buildActionHook(DeciTreeOption<BusareaInfo> option) {
		ActionStd<BusareaInfo> select = new StdBusareaDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.BUSINESS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BUSINESS_NOT_FOUND;
	}
}
