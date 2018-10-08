package br.com.gda.business.storeEmployee.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeMerger;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpWTimeDelete;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStoreWTimeSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerStoreEmpDeleteEWT extends ActionLazyTemplate<StoreEmpInfo, EmpWTimeInfo> {
	private Connection conn;
	private String schemaName;
	
	
	public HandlerStoreEmpDeleteEWT(Connection conn, String schemaName) {
		super(conn, schemaName);
		this.conn = conn;
		this.schemaName = schemaName;
	}
	
	
	
	@Override protected List<EmpWTimeInfo> translateRecordInfosHook(List<StoreEmpInfo> recordInfos) {
		List<StoreWTimeInfo> storeWTs = getStoreWTime(recordInfos);
		return merge(recordInfos, storeWTs);
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
	
	
	
	@Override protected  ActionStd<EmpWTimeInfo> getInstanceOfActionHook(DeciTreeOption<EmpWTimeInfo> option) {
		return new RootEmpWTimeDelete(option).toAction();
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
