package br.com.gda.business.storeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.checker.StoreCoCheckHasCoDb;
import br.com.gda.business.storeWorkTimeConflict.model.checker.StoreCoCheckRead;
import br.com.gda.business.storeWorkTimeConflict.model.checker.StoreCoCheckWTime;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStoreCoSelect implements DeciTree<StoreCoInfo> {
	private DeciTree<StoreCoInfo> tree;
	
	
	public RootStoreCoSelect(DeciTreeOption<StoreCoInfo> option) {
		DeciTreeHelperOption<StoreCoInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreCoInfo> buildDecisionChecker(DeciTreeOption<StoreCoInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoreCoInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreCoInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new StoreCoCheckRead();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCoCheckWTime(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCoCheckHasCoDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerQueue<>(stack);
	}
	
	
	
	@Override public DeciAction<StoreCoInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<DeciAction<StoreCoInfo>> buildActionsOnPassed(DeciTreeOption<StoreCoInfo> option) {
		List<DeciAction<StoreCoInfo>> actions = new ArrayList<>();
		
		DeciAction<StoreCoInfo> actionRange = new ActionStoreCoRange(option);
		DeciActionHandler<StoreCoInfo> actionSelect = new HandlerStoreCoSelect(option.conn, option.schemaName);
		actionRange.addPostAction(actionSelect);
		
		actions.add(actionRange);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreCoInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
