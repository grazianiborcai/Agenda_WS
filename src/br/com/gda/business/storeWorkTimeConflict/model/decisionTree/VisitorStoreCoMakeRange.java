package br.com.gda.business.storeWorkTimeConflict.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.common.TimeRange;
import br.com.gda.model.action.ActionVisitorEnforce;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisitorStoreCoMakeRange implements ActionVisitorEnforce<StoreCoInfo> {
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
			StowotmInfo storeWTime = getStoreWTime(eachRecord);
			
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
	
	
	
	private StowotmInfo getStoreWTime(StoreCoInfo recordInfo) {
		DeciTreeOption<StowotmInfo> option = new DeciTreeOption<>();
		option.conn = conn;
		option.schemaName = schemaName;
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(StowotmInfo.copyFrom(recordInfo));
		
		DeciTree<StowotmInfo> select = new RootStowotmSelect(option);	
		select.makeDecision();
		List<StowotmInfo> resultset = select.getDecisionResult().getResultset();
		
		checkResultset(resultset);		
		return resultset.get(0);
	}
	
	
	
	private void checkResultset(List<StowotmInfo> resultset) {
		if (resultset.isEmpty())
			throw new IllegalStateException(SystemMessage.STORE_WTIME_NOT_FOUND);
		
		if (resultset.size() > 1)
			throw new IllegalStateException(SystemMessage.MULTIPLE_RECORDS);
	}
}
