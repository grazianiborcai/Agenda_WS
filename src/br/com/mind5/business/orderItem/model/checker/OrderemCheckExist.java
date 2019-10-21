package br.com.mind5.business.orderItem.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.StdOrderemSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemCheckExist extends ModelCheckerTemplateAction_<OrderemInfo> {
	
	public OrderemCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<OrderemInfo> buildActionHook(OrderemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrderemInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<OrderemInfo> actionSelect = new StdOrderemSelect(option);
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
		if (makeFailCodeHook(checkerResult) == SystemCode.ORDER_ITEM_ALREADY_EXIST)
			return SystemMessage.ORDER_ITEM_ALREADY_EXIST;
		
		return SystemMessage.ORDER_ITEM_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.ORDER_ITEM_ALREADY_EXIST;	
		
		return SystemCode.ORDER_ITEM_NOT_FOUND;
	}
}
