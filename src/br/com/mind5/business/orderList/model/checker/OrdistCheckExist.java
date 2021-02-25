package br.com.mind5.business.orderList.model.checker;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.StdOrdistDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistCheckExist extends ModelCheckerTemplateAction<OrdistInfo, OrdistInfo> {
	
	public OrdistCheckExist(ModelCheckerOption option) {
		super(option, OrdistInfo.class);
	}
	

	
	@Override protected ActionStd<OrdistInfo> buildActionHook(DeciTreeOption<OrdistInfo> option) {		
		ActionStd<OrdistInfo> select = new StdOrdistDaoSelect(option);			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_LIST_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_LIST_NOT_FOUND;
	}
}
