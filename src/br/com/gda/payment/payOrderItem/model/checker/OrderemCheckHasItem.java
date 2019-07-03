package br.com.gda.payment.payOrderItem.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemSelect;
import br.com.gda.payment.payOrderItem.model.action.StdOrderemEnforceKey;

public final class OrderemCheckHasItem extends ModelCheckerTemplateAction<PayordemInfo> {
	
	public OrderemCheckHasItem(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<PayordemInfo> buildActionHook(PayordemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayordemInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayordemInfo> actionSelect = new StdOrderemEnforceKey(option);
		actionSelect.addPostAction(new LazyOrderemSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PayordemInfo> buildActionOption(PayordemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayordemInfo> option = new DeciTreeOption<>();
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
