package br.com.gda.business.cart.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.ActionCartRemoveItemNum;
import br.com.gda.business.cart.model.decisionTree.HandlerCartSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartCheckExistMat extends ModelCheckerTemplateSimple<CartInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public CartCheckExistMat(ModelCheckerOption option) {
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
		
		DeciAction<CartInfo> removeItemNum = new ActionCartRemoveItemNum(option);
		DeciActionHandlerTemplate<CartInfo, CartInfo> selectCartItem = new HandlerCartSelect(conn, schemaName);
		
		removeItemNum.addPostAction(selectCartItem);
		removeItemNum.executeAction();
		
		if (removeItemNum.getDecisionResult().hasResultset())
			return removeItemNum.getDecisionResult().getResultset();
		
		return Collections.emptyList();		
	}
	
	
	
	private DeciTreeOption<CartInfo> buildOption(CartInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartInfo> newOption = new DeciTreeOption<>();
		
		newOption.recordInfos = new ArrayList<>();
		newOption.recordInfos.add(recordInfo);
		newOption.conn = conn;
		newOption.schemaName = schemaName;
		
		return newOption;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CART_MAT_ALREADY_EXIST)
			return SystemMessage.CART_MAT_ALREADY_EXIST;
		
		return SystemMessage.CART_MAT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.CART_MAT_ALREADY_EXIST;	
			
		return SystemCode.CART_MAT_NOT_FOUND;
	}
}
