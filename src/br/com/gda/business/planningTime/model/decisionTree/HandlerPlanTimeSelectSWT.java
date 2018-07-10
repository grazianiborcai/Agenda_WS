package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeMerger;
import br.com.gda.business.planningTime.info.PlanTimeInfo;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStoreWTimeInsert;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStoreWTimeSelect;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanTimeSelectSWT extends DeciActionHandlerTemplate<PlanTimeInfo, StoreWTimeInfo> {
	private Connection conn;
	private String schemaName;
	
	
	public HandlerPlanTimeSelectSWT(Connection conn, String schemaName) {
		super(conn, schemaName);
		this.conn = conn;
		this.schemaName = schemaName;
	}
	
	
	
	@Override protected List<StoreWTimeInfo> translateRecordInfosHook(List<PlanTimeInfo> recordInfos) {
		return StoreWTimeInfo.copyFrom(recordInfos);
	}
	
	
	
	private List<StoreWTimeInfo> getStoreWTime(List<StoreEmpInfo> recordInfos) {
		DeciTree<StoreWTimeInfo> treeSelect = new RootStoreWTimeSelect(makeStoreWTOption(recordInfos));
		treeSelect.makeDecision();
		return treeSelect.getDecisionResult().getResultset();
	}
	
	
	
	private DeciTreeOption<StoreWTimeInfo> makeStoreWTOption(List<StoreEmpInfo> recordInfos) {
		DeciTreeOption<StoreWTimeInfo> option = new DeciTreeOption<>();
		option.conn = this.conn;
		option.schemaName = this.schemaName;
		option.recordInfos = StoreWTimeInfo.copyFrom(recordInfos);		
		return option;
	}
	
	
	
	private List<EmpWTimeInfo> merge(List<StoreEmpInfo> storeEmps, List<StoreWTimeInfo> storeWTs) {
		return new EmpWTimeMerger().merge(storeEmps, storeWTs);
	}
	
	
	
	@Override protected  DeciAction<StoreWTimeInfo> getInstanceOfActionHook(DeciTreeOption<StoreWTimeInfo> option) {
		return new RootStoreWTimeInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanTimeInfo> translateResultHook(DeciResult<StoreWTimeInfo> result) {
		DeciResultHelper<PlanTimeInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		List<PlanTimeInfo> emptyResultset = new ArrayList<>();
		emptyResultset.add(new PlanTimeInfo());
		
		resultHelper.resultset = emptyResultset;
		
		return resultHelper;
	}
}
