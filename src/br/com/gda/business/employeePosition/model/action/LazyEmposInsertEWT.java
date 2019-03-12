package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeMerger;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckEWTC;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpWTimeInsert;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.common.DeciTreeDummy;

public final class LazyEmposInsertEWT extends ActionLazyTemplate<EmposInfo, EmpWTimeInfo> {
	private final boolean SUCCESS = true;
	private final boolean DONT_EXIST_ON_DB = false;
	
	private Connection conn;
	private String schemaName;
	private ModelChecker<EmpWTimeInfo> checker;	
	private List<EmpWTimeInfo> validRecords;
	
	
	public LazyEmposInsertEWT(Connection conn, String schemaName) {
		super(conn, schemaName);
		
		this.conn = conn;
		this.schemaName = schemaName;		
		validRecords = new ArrayList<>();
		
		buildConflictChecker();
	}
	
	
	
	
	private void buildConflictChecker() {
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checkerOption.conn = conn;
		checkerOption.schemaName = schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmpWTimeCheckEWTC(checkerOption);
	}
	
	
	
	@Override protected List<EmpWTimeInfo> translateRecordInfosHook(List<EmposInfo> recordInfos) {
		List<StowotmInfo> storeWTs = getStoreWTime(recordInfos);
		List<EmpWTimeInfo> mergedRecords = merge(recordInfos, storeWTs);
		return filterOutConflict(mergedRecords);
	}
	
	
	
	private List<StowotmInfo> getStoreWTime(List<EmposInfo> recordInfos) {
		DeciTree<StowotmInfo> treeSelect = new RootStowotmSelect(makeStoreWTOption(recordInfos));
		treeSelect.makeDecision();
		return treeSelect.getDecisionResult().getResultset();
	}
	
	
	
	private DeciTreeOption<StowotmInfo> makeStoreWTOption(List<EmposInfo> recordInfos) {
		DeciTreeOption<StowotmInfo> option = new DeciTreeOption<>();
		option.conn = this.conn;
		option.schemaName = this.schemaName;
		option.recordInfos = StowotmInfo.copyFrom(recordInfos);		
		return option;
	}
	
	
	
	private List<EmpWTimeInfo> merge(List<EmposInfo> storeEmps, List<StowotmInfo> storeWTs) {
		return new EmpWTimeMerger().merge(storeEmps, storeWTs);
	}
	
	
	
	private List<EmpWTimeInfo> filterOutConflict(List<EmpWTimeInfo> recordInfos) {
		for (EmpWTimeInfo eachRecord: recordInfos) {
			boolean checkResult = checker.check(eachRecord);
			
			if (checkResult == SUCCESS)
				validRecords.add(eachRecord);
		}		
		
		return validRecords;
	}
	
	
	
	@Override protected ActionStd<EmpWTimeInfo> getInstanceOfActionHook(DeciTreeOption<EmpWTimeInfo> option) {
		if (validRecords.isEmpty()) 
			return getDummyAction();
		
		
		return new RootEmpWTimeInsert(option).toAction();
	}
	
	
	
	private ActionStd<EmpWTimeInfo> getDummyAction() {		
		EmpWTimeInfo emptyRecord = new EmpWTimeInfo();
		List<EmpWTimeInfo> resultset = new ArrayList<>();
		resultset.add(emptyRecord);
		
		DeciTreeDummy<EmpWTimeInfo> dummyTree = new DeciTreeDummy<>(resultset);
		return dummyTree.toAction();
	}
	
	
	
	@Override protected DeciResult<EmposInfo> translateResultHook(DeciResult<EmpWTimeInfo> result) {
		DeciResultHelper<EmposInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		List<EmposInfo> emptyResultset = new ArrayList<>();
		emptyResultset.add(new EmposInfo());
		
		resultHelper.resultset = emptyResultset;
		
		return resultHelper;
	}
}
