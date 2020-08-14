package br.com.mind5.masterData.businessArea.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.action.StdBusareaDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BusareaCheckExist extends ModelCheckerTemplateActionV2<BusareaInfo, BusareaInfo> {
	
	public BusareaCheckExist(ModelCheckerOption option) {
		super(option, BusareaInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<BusareaInfo> buildActionHook(DeciTreeOption<BusareaInfo> option) {
		ActionStdV1<BusareaInfo> select = new StdBusareaDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.BUSINESS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BUSINESS_NOT_FOUND;
	}
}
