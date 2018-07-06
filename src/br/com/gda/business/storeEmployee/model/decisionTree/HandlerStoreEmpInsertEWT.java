package br.com.gda.business.storeEmployee.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpWTimeInsert;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.ActionStoreWTimeSelect;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerStoreEmpInsertEWT extends DeciActionHandlerTemplate<StoreEmpInfo, EmpWTimeInfo> {
	private Connection conn;
	private String schemaName;
	
	
	public HandlerStoreEmpInsertEWT(Connection conn, String schemaName) {
		super(conn, schemaName);
		this.conn = conn;
		this.schemaName = schemaName;
	}
	
	
	
	@Override protected List<EmpWTimeInfo> translateRecordInfosHook(List<StoreEmpInfo> recordInfos) {
		List<StoreWTimeInfo> storeWTs = getStoreWTime(recordInfos);
		return merge(recordInfos, storeWTs);
	}
	
	
	
	private List<StoreWTimeInfo> getStoreWTime(List<StoreEmpInfo> recordInfos) {
		DeciAction<StoreWTimeInfo> actionSelect = new ActionStoreWTimeSelect(makeStoreWTOption(recordInfos));
		actionSelect.executeAction();
		return actionSelect.getDecisionResult().getResultset();
	}
	
	
	
	private DeciTreeOption<StoreWTimeInfo> makeStoreWTOption(List<StoreEmpInfo> recordInfos) {
		DeciTreeOption<StoreWTimeInfo> option = new DeciTreeOption<>();
		option.conn = this.conn;
		option.schemaName = this.schemaName;
		option.recordInfos = StoreWTimeInfo.copyFrom(recordInfos);		
		return option;
	}
	
	
	
	private List<EmpWTimeInfo> merge(List<StoreEmpInfo> storeEmps, List<StoreWTimeInfo> storeWTs) {
		List<EmpWTimeInfo> mergedRecord = new ArrayList<>();
		
		for (StoreWTimeInfo eachStoreWT : storeWTs) {
			EmpWTimeInfo target = EmpWTimeInfo.copyFrom(eachStoreWT);
			
			for (StoreEmpInfo eachStoreEmp : storeEmps) {
				if (eachStoreWT.codOwner == eachStoreEmp.codOwner &&
					eachStoreWT.codStore == eachStoreEmp.codStore) {
					
					target.codEmployee = eachStoreEmp.codEmployee;
					mergedRecord.add(target);
				}
			}
		}
		
		return mergedRecord;
	}
	
	
	
	@Override protected  DeciAction<EmpWTimeInfo> getInstanceOfActionHook(DeciTreeOption<EmpWTimeInfo> option) {
		return new RootEmpWTimeInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoreEmpInfo> translateResultHook(DeciResult<EmpWTimeInfo> result) {
		DeciResultHelper<StoreEmpInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		List<StoreEmpInfo> emptyResultset = new ArrayList<>();
		emptyResultset.add(new StoreEmpInfo());
		
		resultHelper.resultset = emptyResultset;
		
		return resultHelper;
	}
}
