package br.com.gda.business.feeStore.model.decisionTree;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.info.FeeStoreMerger;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreSelect;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisitorFeeStoreMergeStore implements DeciActionTransVisitor<FeeStoreInfo> {
	private DeciTreeOption<StoreInfo> selOption;
	
	
	public VisitorFeeStoreMergeStore(Connection conn, String schemaName) {
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
		List<StoreInfo> stores = selectStore();
		
		if (stores.isEmpty())
			return Collections.emptyList();
		
		return merge(recordInfos, stores);
	}	
	
	
	
	private void addRecordToOption(List<FeeStoreInfo> recordInfos) {
		selOption.recordInfos = StoreInfo.copyFrom(recordInfos);
	}
	
	
	
	private List<StoreInfo> selectStore() {
		DeciAction<StoreInfo> mainAction = new RootStoreSelect(selOption).toAction();
		mainAction.executeAction();
		
		if (mainAction.getDecisionResult().hasResultset())		
			return mainAction.getDecisionResult().getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private List<FeeStoreInfo> merge(List<FeeStoreInfo> fees, List<StoreInfo> stores) {
		return new FeeStoreMerger().merge(stores, fees);
	}
}
