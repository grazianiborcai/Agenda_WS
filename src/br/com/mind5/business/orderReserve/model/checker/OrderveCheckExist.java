package br.com.mind5.business.orderReserve.model.checker;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.decisionTree.RootOrderveSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderveCheckExist extends ModelCheckerTemplateActionV2<OrderveInfo, OrderveInfo> {
	
	public OrderveCheckExist(ModelCheckerOption option) {
		super(option, OrderveInfo.class);
	}
	

	
	@Override protected ActionStdV1<OrderveInfo> buildActionHook(DeciTreeOption<OrderveInfo> option) {
		ActionStdV1<OrderveInfo> select = new RootOrderveSelect(option).toAction();
		return select;
	}
	
	
		
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_RESERVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_RESERVE_NOT_FOUND;
	}
}
