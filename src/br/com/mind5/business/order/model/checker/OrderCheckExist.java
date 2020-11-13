package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.StdOrderDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderCheckExist extends ModelCheckerTemplateActionV2<OrderInfo, OrderInfo> {
	
	public OrderCheckExist(ModelCheckerOption option) {
		super(option, OrderInfo.class);
	}
	

	
	@Override protected ActionStdV2<OrderInfo> buildActionHook(DeciTreeOption<OrderInfo> option) {		
		ActionStdV2<OrderInfo> select = new StdOrderDaoSelect(option);			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_HEADER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_HEADER_NOT_FOUND;
	}
}
