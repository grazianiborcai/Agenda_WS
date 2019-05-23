package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionVisitorEnforce;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCartemEnforceItmNumDB implements ActionVisitorEnforce<CartemInfo> {
	private DeciTreeOption<CartemInfo> selOption;
	
	
	public VisiCartemEnforceItmNumDB(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		makeOption(conn, schemaName);
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
	
	
		
	@Override public List<CartemInfo> executeTransformation(List<CartemInfo> recordInfos) {
		addRecordToOption(recordInfos);
		List<CartemInfo> resultRecords = new ArrayList<>();		
		
		for (CartemInfo eachRecord : recordInfos) {			
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private void addRecordToOption(List<CartemInfo> recordInfos) {
		selOption.recordInfos = recordInfos;
	}
	
	
	
	private CartemInfo enforce(CartemInfo recordInfo) {
		CartemInfo enforcedRecord = makeClone(recordInfo);
		enforcedRecord.itemNumber = GetItemNum();
		return enforcedRecord;
	}
	
	
	
	private int GetItemNum() {
		List<CartemInfo> cartItems = selectCart();
		checkCart(cartItems);
		
		return cartItems.get(0).itemNumber;
	}
	
	
	
	private List<CartemInfo> selectCart() {
		ActionStd<CartemInfo> mainAction = new StdCartemRemoveItemNum(selOption);
		ActionLazy<CartemInfo> selectCart = new LazyCartemSelect(selOption.conn, selOption.schemaName);
		
		mainAction.addPostAction(selectCart);
		mainAction.executeAction();
		
		if (mainAction.getDecisionResult().hasResultset())		
			return mainAction.getDecisionResult().getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private void checkCart(List<CartemInfo> cartItems) {
		if (cartItems.isEmpty())
			throw new IllegalArgumentException(SystemMessage.DATA_NOT_FOUND);
		
		if (cartItems.size() > 1)
			throw new IllegalArgumentException(SystemMessage.MULTIPLE_RECORDS);			
	}
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
