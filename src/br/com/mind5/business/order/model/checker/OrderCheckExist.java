package br.com.mind5.business.order.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderSelect;
import br.com.mind5.business.order.model.action.StdOrderEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
