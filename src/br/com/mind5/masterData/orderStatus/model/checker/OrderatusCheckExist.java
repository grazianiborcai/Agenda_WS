package br.com.mind5.masterData.orderStatus.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.action.StdOrderatusDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderatusCheckExist extends ModelCheckerTemplateAction<OrderatusInfo, OrderatusInfo> {
	
	public OrderatusCheckExist(ModelCheckerOption option) {
		super(option, OrderatusInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrderatusInfo> buildActionHook(DeciTreeOption<OrderatusInfo> option) {
		ActionStd<OrderatusInfo> select = new StdOrderatusDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_STATUS_NOT_FOUND;
	}
}
