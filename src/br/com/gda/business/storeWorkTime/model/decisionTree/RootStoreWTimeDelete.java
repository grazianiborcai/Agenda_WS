package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckExist;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckKey;
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

public final class RootStoreWTimeDelete implements DeciTree<StoreWTimeInfo> {
	private DeciTree<StoreWTimeInfo> tree;
	
	
	public RootStoreWTimeDelete(DeciTreeOption<StoreWTimeInfo> option) {
		DeciTreeHelperOption<StoreWTimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreWTimeInfo> buildDecisionChecker(DeciTreeOption<StoreWTimeInfo> option) {
		List<ModelChecker<StoreWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreWTimeInfo> checker;
		ModelCheckerOption checkerOption;
			
		checker = new StoreWTimeCheckKey();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreWTimeCheckExist(checkerOption);
		stack.add(checker);		
		
		 return new ModelCheckerQueue<StoreWTimeInfo>(stack);
	}
	
	
	
	private List<DeciAction<StoreWTimeInfo>> buildActionsOnPassed(DeciTreeOption<StoreWTimeInfo> option) {
		List<DeciAction<StoreWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionStoreWTimeDelete(option));
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
	
	
	
	@Override public DeciAction<StoreWTimeInfo> toAction() {
		return tree.toAction();
	}
}
