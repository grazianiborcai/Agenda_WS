package br.com.gda.business.cart.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.ActionCartEnforceKey;
import br.com.gda.business.cart.model.decisionTree.HandlerCartSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartCheckExistHdr extends ModelCheckerTemplateAction<CartInfo> {
	
	public CartCheckExistHdr(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<CartInfo> buildActionHook(CartInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		DeciAction<CartInfo> actionSelect = new ActionCartEnforceKey(option);
		actionSelect.addPostAction(new HandlerCartSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CartInfo> buildActionOption(CartInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CART_ALREADY_EXIST)
			return SystemMessage.CUS_ALREADY_EXIST;
		
		return SystemMessage.CART_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.CART_ALREADY_EXIST;	
			
		return SystemCode.CART_NOT_FOUND;
	}
}
