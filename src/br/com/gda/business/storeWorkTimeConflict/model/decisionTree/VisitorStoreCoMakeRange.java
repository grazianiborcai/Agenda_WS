package br.com.gda.business.storeWorkTimeConflict.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStoreWTimeSelect;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.common.TimeRange;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisitorStoreCoMakeRange implements DeciActionTransVisitor<StoreCoInfo> {
	private Connection conn; 
	private String schemaName;
	private List<StoreCoInfo> storeWTRanges = new ArrayList<>();
	
	
	public VisitorStoreCoMakeRange(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		
		this.conn = conn;
		this.schemaName = schemaName;
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override public List<StoreCoInfo> executeTransformation(List<StoreCoInfo> recordInfos) {
		buildRange(recordInfos);			
		return storeWTRanges;
	}	
	
	
	
	private void buildRange(List<StoreCoInfo> recordInfos) {		
		for (StoreCoInfo eachRecord : recordInfos) {			
			StoreWTimeInfo storeWTime = getStoreWTime(eachRecord);
			
			TimeRange timeRange = new TimeRange(storeWTime.beginTime, storeWTime.endTime);
			List<TimeRange> timeRanges = timeRange.getMissingRanges(eachRecord.beginTime, eachRecord.endTime);
			
			for (TimeRange eachTime : timeRanges) {
				StoreCoInfo clonedRecord = makeDefensiveCopy(eachRecord);
				clonedRecord.beginTime = eachTime.getBeginTime();
				clonedRecord.endTime = eachTime.getEndTime();
				storeWTRanges.add(clonedRecord);
			}
		}
	}
	
	
	
	private StoreCoInfo makeDefensiveCopy(StoreCoInfo recordInfo) {
		try {
			return (StoreCoInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private StoreWTimeInfo getStoreWTime(StoreCoInfo recordInfo) {
		DeciTreeOption<StoreWTimeInfo> option = new DeciTreeOption<>();
		option.conn = conn;
		option.schemaName = schemaName;
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(StoreWTimeInfo.copyFrom(recordInfo));
		
		DeciTree<StoreWTimeInfo> select = new RootStoreWTimeSelect(option);	
		select.makeDecision();
		List<StoreWTimeInfo> resultset = select.getDecisionResult().getResultset();
		
		checkResultset(resultset);		
		return resultset.get(0);
	}
	
	
	
	private void checkResultset(List<StoreWTimeInfo> resultset) {
		if (resultset.isEmpty())
			throw new IllegalStateException(SystemMessage.STORE_WTIME_NOT_FOUND);
		
		if (resultset.size() > 1)
			throw new IllegalStateException(SystemMessage.MULTIPLE_RECORDS);
	}
}
