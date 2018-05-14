package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.decisionTree.StoreEmpActionSelect;
import br.com.gda.business.store.model.decisionTree.StoreEmpRootDelete;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionResultHelper;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class EmpActionDeleteStoreEmp implements DecisionAction<EmpInfo> {
	private final boolean FAILED = false;
	private final boolean THERE_IS_RESULTSET = true;
	
	private DecisionAction<StoreEmpInfo> actionStarter;
	private DecisionTree<StoreEmpInfo> treeHelper;
	
	
	
	public EmpActionDeleteStoreEmp(DecisionTreeOption<EmpInfo> option) {
		buildActionStarter(option);
		executeActionStater();
		buildDecisionTree(option);
	}
	
	
	
	private void buildActionStarter(DecisionTreeOption<EmpInfo> option) {
		List<StoreEmpInfo> translatedInfos;
		DecisionTreeOption<StoreEmpInfo> translatedOption;
		
		translatedInfos = translateRecordInfos(option.recordInfos);
		translatedOption = translateOption(option, translatedInfos);
		
		actionStarter = new StoreEmpActionSelect(translatedOption);
	}
	
	
	
	private List<StoreEmpInfo> translateRecordInfos(List<EmpInfo> recordInfos) {
		List<StoreEmpInfo> translatedInfos = new ArrayList<>();
		
		for (EmpInfo eachRecord : recordInfos) {
			translatedInfos.add(eachRecord.toStoreEmpInfo());
		}
		
		return translatedInfos;
	}
	
	
	
	private DecisionTreeOption<StoreEmpInfo> translateOption(DecisionTreeOption<EmpInfo> option, List<StoreEmpInfo> recordInfos) {
		DecisionTreeOption<StoreEmpInfo> newOption = new DecisionTreeOption<>();
		newOption.conn = option.conn;
		newOption.schemaName = option.schemaName;
		newOption.recordInfos = recordInfos;
		return newOption;
	}
	
	
	
	private void executeActionStater() {
		if ( actionStarter.executeAction() == FAILED) 
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
	}
	
	
	
	private void buildDecisionTree(DecisionTreeOption<EmpInfo> option) {
		List<StoreEmpInfo> recordInfos;
		DecisionTreeOption<StoreEmpInfo> translatedOption;
		
		recordInfos = actionStarter.getDecisionResult().getResultset();
		translatedOption = translateOption(option, recordInfos);
		
		treeHelper = new StoreEmpRootDelete(translatedOption);
	}
	
		
	
	@Override public boolean executeAction() {	
		treeHelper.makeDecision();
		return treeHelper.getDecisionResult().hasSuccessfullyFinished();
	}
	
	
	
	@Override public DecisionResult<EmpInfo> getDecisionResult() {
		return translateDecisionResult(treeHelper.getDecisionResult());
	}
	
	
	
	private DecisionResult<EmpInfo> translateDecisionResult(DecisionResult<StoreEmpInfo> decisionResult) {
		DecisionResultHelper<EmpInfo> translatedResult = new DecisionResultHelper<>();
		
		translatedResult.finishedWithSuccess = decisionResult.hasSuccessfullyFinished();
		
		if (decisionResult.hasSuccessfullyFinished() == FAILED) {
			translatedResult.failureCode = decisionResult.getFailureCode();
			translatedResult.failureMessage = decisionResult.getFailureMessage();
		}
		
		
		translatedResult.hasResultset = decisionResult.hasResultset();
		
		if (decisionResult.hasResultset() == THERE_IS_RESULTSET) {
			EmpInfo emptyInfo = new EmpInfo();
			translatedResult.resultset = new ArrayList<>();
			translatedResult.resultset.add(emptyInfo);
		}
		
		return translatedResult;
	} 
}
