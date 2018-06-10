package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckExist;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckOwner;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckStore;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckTime;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckWeekday;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStoreWTimeInsert implements DeciTree<StoreWTimeInfo> {
	private DeciTree<StoreWTimeInfo> tree;
	
	
	public RootStoreWTimeInsert(DeciTreeOption<StoreWTimeInfo> option) {
		DeciTreeHelperOption<StoreWTimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreWTimeInfo> buildDecisionChecker(DeciTreeOption<StoreWTimeInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<StoreWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreWTimeInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new StoreWTimeCheckWrite();
		stack.add(checker);
		
		checker = new StoreWTimeCheckTime();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreWTimeCheckOwner(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreWTimeCheckStore(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreWTimeCheckWeekday(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new StoreWTimeCheckExist(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<StoreWTimeInfo>> buildActionsOnPassed(DeciTreeOption<StoreWTimeInfo> option) {
		List<DeciAction<StoreWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new NodeStoreWTimeInsert(option).getAsAction());	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreWTimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<StoreWTimeInfo> getAsAction() {
		return tree.getAsAction();
	}
}
