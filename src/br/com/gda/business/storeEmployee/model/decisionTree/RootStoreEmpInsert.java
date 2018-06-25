package br.com.gda.business.storeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeEmployee.model.checker.StoreEmpCheckEmp;
import br.com.gda.business.storeEmployee.model.checker.StoreEmpCheckEmpPos;
import br.com.gda.business.storeEmployee.model.checker.StoreEmpCheckExist;
import br.com.gda.business.storeEmployee.model.checker.StoreEmpCheckStore;
import br.com.gda.business.storeEmployee.model.checker.StoreEmpCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStoreEmpInsert implements DeciTree<StoreEmpInfo> {
	private DeciTree<StoreEmpInfo> tree;
	
	
	public RootStoreEmpInsert(DeciTreeOption<StoreEmpInfo> option) {
		DeciTreeHelperOption<StoreEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker(DeciTreeOption<StoreEmpInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<StoreEmpInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new StoreEmpCheckWrite();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new StoreEmpCheckExist(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreEmpCheckEmpPos(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreEmpCheckStore(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreEmpCheckEmp(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerQueue<>(stack);
	}
	
	
	
	private List<DeciAction<StoreEmpInfo>> buildActionsOnPassed(DeciTreeOption<StoreEmpInfo> option) {
		List<DeciAction<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new NodeStoreEmpInsert(option).toAction());	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<StoreEmpInfo> toAction() {
		return tree.toAction();
	}
}
