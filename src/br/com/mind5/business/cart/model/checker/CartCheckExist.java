package br.com.mind5.business.cart.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartSelect;
import br.com.mind5.business.cart.model.action.StdCartEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartCheckExist extends ModelCheckerTemplateAction_<CartInfo> {
	
	public CartCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<CartInfo> buildActionHook(CartInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CartInfo> actionSelect = new StdCartEnforceKey(option);
		actionSelect.addPostAction(new LazyCartSelect(conn, schemaName));
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.CART_ALREADY_EXIST)
			return SystemMessage.CART_ALREADY_EXIST;
		
		return SystemMessage.CART_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.CART_ALREADY_EXIST;	
		
		return SystemCode.CART_NOT_FOUND;
	}
}
