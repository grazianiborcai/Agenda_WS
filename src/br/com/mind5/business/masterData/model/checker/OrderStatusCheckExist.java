package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.masterData.model.action.StdOrderStatusSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderStatusCheckExist extends ModelCheckerTemplateActionV2<OrderStatusInfo, OrderStatusInfo> {
	
	public OrderStatusCheckExist(ModelCheckerOption option) {
		super(option, OrderStatusInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<OrderStatusInfo> buildActionHook(DeciTreeOption<OrderStatusInfo> option) {
		ActionStdV1<OrderStatusInfo> select = new StdOrderStatusSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_STATUS_NOT_FOUND;
	}
}
