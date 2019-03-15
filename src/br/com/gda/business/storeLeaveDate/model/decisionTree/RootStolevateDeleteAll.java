package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateMergeToDelete;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateRootDelete;
import br.com.gda.business.storeLeaveDate.model.action.StdStolevateEnforceStoreKey;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckDeleteAll;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckHasItem;
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

public final class RootStolevateDeleteAll implements DeciTree<StolevateInfo> {
	private DeciTree<StolevateInfo> tree;
	
	
	public RootStolevateDeleteAll(DeciTreeOption<StolevateInfo> option) {
		DeciTreeHelperOption<StolevateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StolevateInfo> buildDecisionChecker(DeciTreeOption<StolevateInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StolevateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolevateInfo> checker;
		ModelCheckerOption checkerOption;
			
		checker = new StolevateCheckDeleteAll();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StolevateCheckHasItem(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<StolevateInfo>(queue);
	}
	
	
	
	private List<ActionStd<StolevateInfo>> buildActionsOnPassed(DeciTreeOption<StolevateInfo> option) {
		List<ActionStd<StolevateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolevateInfo> enforceStoreKey = new StdStolevateEnforceStoreKey(option);
		ActionLazy<StolevateInfo> mergeToDelete = new LazyStolevateMergeToDelete(option.conn, option.schemaName);
		ActionLazy<StolevateInfo> delete = new LazyStolevateRootDelete(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<StolevateInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StolevateInfo> toAction() {
		return tree.toAction();
	}
}
