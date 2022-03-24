package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemCheckExist extends ModelCheckerTemplateAction<OrderemInfo, OrderemInfo> {
	
	public OrderemCheckExist(ModelCheckerOption option) {
		super(option, OrderemInfo.class);
	}
	

	
	@Override protected ActionStd<OrderemInfo> buildActionHook(DeciTreeOption<OrderemInfo> option) {
		ActionStd<OrderemInfo> select = new ActionStdCommom<OrderemInfo>(option, OrderemVisiDaoSelect.class);
		return select;
	}
	
	
		
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_ITEM_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_ITEM_NOT_FOUND;
	}
}
