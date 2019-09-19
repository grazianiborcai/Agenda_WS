package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.masterData.model.action.StdOrderStatusSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OrderStatusCheckExist extends ModelCheckerTemplateAction_<OrderStatusInfo> {
	
	public OrderStatusCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<OrderStatusInfo> buildActionHook(OrderStatusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrderStatusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<OrderStatusInfo> actionSelect = new StdOrderStatusSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<OrderStatusInfo> buildActionOption(OrderStatusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrderStatusInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.ORDER_STATUS_ALREADY_EXIST)
			return SystemMessage.ORDER_STATUS_ALREADY_EXIST;
		
		return SystemMessage.ORDER_STATUS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.ORDER_STATUS_ALREADY_EXIST;	
			
		return SystemCode.ORDER_STATUS_NOT_FOUND;
	}
}
