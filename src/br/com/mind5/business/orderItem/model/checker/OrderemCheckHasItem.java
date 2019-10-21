package br.com.mind5.business.orderItem.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemSelect;
import br.com.mind5.business.orderItem.model.action.StdOrderemEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemCheckHasItem extends ModelCheckerTemplateAction_<OrderemInfo> {
	
	public OrderemCheckHasItem(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<OrderemInfo> buildActionHook(OrderemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrderemInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<OrderemInfo> actionSelect = new StdOrderemEnforceKey(option);
		actionSelect.addPostAction(new LazyOrderemSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<OrderemInfo> buildActionOption(OrderemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrderemInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.ORDER_HAVE_ITEM)
			return SystemMessage.ORDER_HAVE_ITEM;
		
		return SystemMessage.ORDER_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.ORDER_HAVE_ITEM;	
		
		return SystemCode.ORDER_IS_EMPTY;
	}
}
