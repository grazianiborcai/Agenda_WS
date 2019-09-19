package br.com.gda.business.order.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderSelect;
import br.com.gda.business.order.model.action.StdOrderEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OrderCheckExist extends ModelCheckerTemplateAction_<OrderInfo> {
	
	public OrderCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<OrderInfo> buildActionHook(OrderInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrderInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<OrderInfo> enforceKey = new StdOrderEnforceKey(option);	
		ActionLazy<OrderInfo> select = new LazyOrderSelect(conn, schemaName);
		
		enforceKey.addPostAction(select);
		
		return enforceKey;
	}
	
	
	
	private DeciTreeOption<OrderInfo> buildActionOption(OrderInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrderInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.ORDER_ALREADY_EXIST)
			return SystemMessage.ORDER_ALREADY_EXIST;
		
		return SystemMessage.ORDER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.ORDER_ALREADY_EXIST;	
		
		return SystemCode.ORDER_NOT_FOUND;
	}
}
