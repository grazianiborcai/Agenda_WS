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

public final class CartCheckExistServ extends ModelCheckerTemplateSimple<CartInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NOT_FOUND = false;
	
	
	public CartCheckExistServ(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartInfo recordInfo, Connection conn, String schemaName) {	
		try {
			return checkExistServ(recordInfo, conn, schemaName);
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private boolean checkExistServ(CartInfo recordInfo, Connection conn, String schemaName) {
		List<CartInfo> cartItens = selectCartItem(recordInfo, conn, schemaName);
		
		if (cartItens == null || cartItens.isEmpty())
			return NOT_FOUND;
		
		
		for (CartInfo eachItem : cartItens) {
			if (isEqual(recordInfo, eachItem) == RECORD_EXIST)
				return RECORD_EXIST;
		}		
		
		return NOT_FOUND;
	}
	
	
	
	private boolean isEqual(CartInfo recordOne, CartInfo recordTwo) {
		
		return (recordOne.codOwner    == recordTwo.codOwner    	&&
				recordOne.codCustomer == recordTwo.codCustomer 	&&
				recordOne.codStore    == recordTwo.codStore    	&&
				recordOne.codMat      == recordTwo.codMat      	&&
				recordOne.date.isEqual(recordTwo.date)			&&
				recordOne.beginTime.equals(recordTwo.beginTime) &&
				recordOne.endTime.equals(recordTwo.endTime));
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
