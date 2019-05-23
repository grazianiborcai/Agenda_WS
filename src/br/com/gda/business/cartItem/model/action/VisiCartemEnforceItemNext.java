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

final class VisiCartemEnforceItemNext implements ActionVisitorEnforce<CartemInfo> {
	private DeciTreeOption<CartemInfo> selOption;
	private int maxItem;
	
	
	public VisiCartemEnforceItemNext(Connection conn, String schemaName) {
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
		computeMaxItemNum();
		
		CartemInfo enforcedRecord = makeClone(recordInfo);
		enforcedRecord.itemNumber = maxItem;
		return enforcedRecord;
	}
	
	
	
	private void computeMaxItemNum() {
		if (maxItem == 0) 
			getMaxItemNum();
		
		maxItem = maxItem + 1;
	}
	
	
	
	private int getMaxItemNum() {
		List<CartemInfo> cartItems = selectCart();
		
		for (CartemInfo eachItem: cartItems) {
			if (eachItem.itemNumber > maxItem)
				maxItem = eachItem.itemNumber;
		}
		
		return maxItem;
	}
	
	
	
	private List<CartemInfo> selectCart() {
		ActionStd<CartemInfo> mainAction = new StdCartemEnforceKey(selOption);
		ActionLazy<CartemInfo> selectCart = new LazyCartemSelect(selOption.conn, selOption.schemaName);
		
		mainAction.addPostAction(selectCart);
		mainAction.executeAction();
		
		if (mainAction.getDecisionResult().hasResultset())		
			return mainAction.getDecisionResult().getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
