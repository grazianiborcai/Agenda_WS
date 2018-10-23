package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionVisitorEnforce;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCartEnforceItemNext implements ActionVisitorEnforce<CartInfo> {
	private DeciTreeOption<CartInfo> selOption;
	private int maxItem;
	
	
	public VisiCartEnforceItemNext(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		makeOption(conn, schemaName);
		
		maxItem = 0;
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);		
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);		
	}
	
	
	
	private void makeOption(Connection conn, String schemaName) {
		selOption = new DeciTreeOption<>();
		selOption.conn = conn;
		selOption.schemaName = schemaName;
		selOption.recordInfos = null;
	}
	
	
		
	@Override public List<CartInfo> executeTransformation(List<CartInfo> recordInfos) {
		addRecordToOption(recordInfos);
		List<CartInfo> resultRecords = new ArrayList<>();		
		
		for (CartInfo eachRecord : recordInfos) {			
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private void addRecordToOption(List<CartInfo> recordInfos) {
		selOption.recordInfos = recordInfos;
	}
	
	
	
	private CartInfo enforce(CartInfo recordInfo) {
		computeMaxItemNum();
		
		CartInfo enforcedRecord = makeClone(recordInfo);
		enforcedRecord.itemNumber = maxItem;
		return enforcedRecord;
	}
	
	
	
	private void computeMaxItemNum() {
		if (maxItem == 0) 
			getMaxItemNum();
		
		maxItem = maxItem + 1;
	}
	
	
	
	private int getMaxItemNum() {
		List<CartInfo> cartItems = selectCart();
		
		for (CartInfo eachItem: cartItems) {
			if (eachItem.itemNumber > maxItem)
				maxItem = eachItem.itemNumber;
		}
		
		return maxItem;
	}
	
	
	
	private List<CartInfo> selectCart() {
		ActionStd<CartInfo> mainAction = new StdCartEnforceKey(selOption);
		ActionLazy<CartInfo> selectCart = new LazyCartSelect(selOption.conn, selOption.schemaName);
		
		mainAction.addPostAction(selectCart);
		mainAction.executeAction();
		
		if (mainAction.getDecisionResult().hasResultset())		
			return mainAction.getDecisionResult().getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
