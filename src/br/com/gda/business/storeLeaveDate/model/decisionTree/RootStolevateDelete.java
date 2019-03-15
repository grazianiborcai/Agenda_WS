package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateDelete;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateEnforceLChanged;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateMergeUsername;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateUpdate;
import br.com.gda.business.storeLeaveDate.model.action.StdStolevateMergeToDelete;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckExist;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckStorauth;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckDelete;
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

public final class RootStolevateDelete implements DeciTree<StolevateInfo> {
	private DeciTree<StolevateInfo> tree;
	
	
	public RootStolevateDelete(DeciTreeOption<StolevateInfo> option) {
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
			
		checker = new StolevateCheckDelete();
		queue.add(checker);		
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StolevateCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StolevateCheckStorauth(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<StolevateInfo>(queue);
	}
	
	
	
	private List<ActionStd<StolevateInfo>> buildActionsOnPassed(DeciTreeOption<StolevateInfo> option) {
		List<ActionStd<StolevateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolevateInfo> mergeToDelete = new StdStolevateMergeToDelete(option);
		ActionLazy<StolevateInfo> enforceLChanged = new LazyStolevateEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StolevateInfo> enforceLChangedBy = new LazyStolevateMergeUsername(option.conn, option.schemaName);
		ActionLazy<StolevateInfo> update = new LazyStolevateUpdate(option.conn, option.schemaName);
		ActionLazy<StolevateInfo> delete = new LazyStolevateDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
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
