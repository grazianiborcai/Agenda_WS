package br.com.gda.business.feeStore.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeDefault.model.decisionTree.ActionFeeDefaultSelect;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitor;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisitorFeeStoreDefault implements ActionVisitor<FeeStoreInfo> {
	private DeciTreeOption<FeeDefaultInfo> selOption;
	
	
	public VisitorFeeStoreDefault(Connection conn, String schemaName) {
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
	
	
		
	@Override public List<FeeStoreInfo> executeTransformation(List<FeeStoreInfo> recordInfos) {
		addRecordToOption(recordInfos);
		return selectDefault();
	}	
	
	
	
	private void addRecordToOption(List<FeeStoreInfo> recordInfos) {
		selOption.recordInfos = new ArrayList<>();
		
		for (FeeStoreInfo eachRecord : recordInfos) {			
			selOption.recordInfos.add(FeeDefaultInfo.copyFrom(eachRecord));
		}
	}
	
	
	
	private List<FeeStoreInfo> selectDefault() {
		List<FeeDefaultInfo> defaults = selectFeeDefault();	
		
		if (defaults.isEmpty())
			return Collections.emptyList();
		
		
		List<FeeStoreInfo> results = new ArrayList<>();
		
		for (FeeDefaultInfo eachDefault : defaults) {
			results.add(FeeStoreInfo.copyFrom(eachDefault));
		}
		
		return results;
	}
	
	
	
	private List<FeeDefaultInfo> selectFeeDefault() {
		ActionStd<FeeDefaultInfo> mainAction = new ActionFeeDefaultSelect(selOption);
		mainAction.executeAction();
		
		if (mainAction.getDecisionResult().hasResultset())		
			return mainAction.getDecisionResult().getResultset();
		
		return Collections.emptyList();
	}
}
