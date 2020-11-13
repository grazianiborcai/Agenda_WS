package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.StdOrderemDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemCheckExist extends ModelCheckerTemplateActionV2<OrderemInfo, OrderemInfo> {
	
	public OrderemCheckExist(ModelCheckerOption option) {
		super(option, OrderemInfo.class);
	}
	

	
	@Override protected ActionStdV2<OrderemInfo> buildActionHook(DeciTreeOption<OrderemInfo> option) {
		ActionStdV2<OrderemInfo> select = new StdOrderemDaoSelect(option);
		return select;
	}
	
	
		
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_ITEM_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_ITEM_NOT_FOUND;
	}
}
