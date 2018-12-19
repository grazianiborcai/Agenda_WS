package br.com.gda.business.cart.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.StdCartEnforceKey;
import br.com.gda.business.cart.model.action.LazyCartSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartCheckHasItem extends ModelCheckerTemplateAction<CartInfo> {
	
	public CartCheckHasItem(ModelCheckerOption option) {
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
		if (makeFailCodeHook(checkerResult) == SystemCode.CART_HAVE_ITEM)
			return SystemMessage.CART_HAVE_ITEM;
		
		return SystemMessage.CART_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.CART_HAVE_ITEM;	
		
		return SystemCode.CART_IS_EMPTY;
	}
}
