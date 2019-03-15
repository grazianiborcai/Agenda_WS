package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmMergeToDelete;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmRootDelete;
import br.com.gda.business.storeWorkTime.model.action.StdStowotmEnforceStoreKey;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckHasItem;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckDeleteAll;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStowotmDeleteAll implements DeciTree<StowotmInfo> {
	private DeciTree<StowotmInfo> tree;
	
	
	public RootStowotmDeleteAll(DeciTreeOption<StowotmInfo> option) {
		DeciTreeHelperOption<StowotmInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StowotmInfo> buildDecisionChecker(DeciTreeOption<StowotmInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;
			
		checker = new StowotmCheckDeleteAll();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StowotmCheckHasItem(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<StowotmInfo>(queue);
	}
	
	
	
	private List<ActionStd<StowotmInfo>> buildActionsOnPassed(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceStoreKey = new StdStowotmEnforceStoreKey(option);
		ActionLazy<StowotmInfo> mergeToDelete = new LazyStowotmMergeToDelete(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> delete = new LazyStowotmRootDelete(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StowotmInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StowotmInfo> toAction() {
		return tree.toAction();
	}
}
