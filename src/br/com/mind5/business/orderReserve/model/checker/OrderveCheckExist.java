package br.com.mind5.business.orderReserve.model.checker;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.decisionTree.OrderveRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderveCheckExist extends ModelCheckerTemplateAction<OrderveInfo, OrderveInfo> {
	
	public OrderveCheckExist(ModelCheckerOption option) {
		super(option, OrderveInfo.class);
	}
	

	
	@Override protected ActionStd<OrderveInfo> buildActionHook(DeciTreeOption<OrderveInfo> option) {
		ActionStd<OrderveInfo> select = new OrderveRootSelect(option).toAction();
		return select;
	}
	
	
		
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_RESERVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_RESERVE_NOT_FOUND;
	}
}
