package br.com.gda.business.cart.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.StdCartEnforceKey;
import br.com.gda.business.cart.model.action.LazyCartSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartCheckHasItem extends ModelCheckerTemplateSimple<CartInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public CartCheckHasItem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<CartInfo> cartItens = selectCartItem(recordInfo, conn, schemaName);
			
			if (cartItens == null || cartItens.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<CartInfo> selectCartItem(CartInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartInfo> option = buildOption(recordInfo, conn, schemaName);		
		List<CartInfo> resultset = executeAction(option);
		return resultset;
	}
	
	
	
	private DeciTreeOption<CartInfo> buildOption(CartInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartInfo> newOption = new DeciTreeOption<>();
		
		newOption.recordInfos = new ArrayList<>();
		newOption.recordInfos.add(recordInfo);
		newOption.conn = conn;
		newOption.schemaName = schemaName;
		
		return newOption;
	}
	
	
	
	private List<CartInfo> executeAction(DeciTreeOption<CartInfo> option) {	
		ActionStd<CartInfo> action = buildAction(option);		
		action.executeAction();
		
		if (action.getDecisionResult().hasResultset())
			return action.getDecisionResult().getResultset();
		
		return Collections.emptyList();		
	}
	
	
	
	private ActionStd<CartInfo> buildAction(DeciTreeOption<CartInfo> option) {	
		ActionStd<CartInfo> enforceKey = new StdCartEnforceKey(option);
		ActionLazyTemplate<CartInfo, CartInfo> selectCartItem = new LazyCartSelect(option.conn, option.schemaName);
		
		enforceKey.addPostAction(selectCartItem);
		return enforceKey;	
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CART_HAVE_ITEM)
			return SystemMessage.CART_HAVE_ITEM;
		
		return SystemMessage.CART_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.CART_HAVE_ITEM;	
			
		return SystemCode.CART_IS_EMPTY;
	}
}
