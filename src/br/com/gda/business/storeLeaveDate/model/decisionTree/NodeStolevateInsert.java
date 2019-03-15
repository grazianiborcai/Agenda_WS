package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateInsert;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateMergeUsername;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateRootSelect;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateUpdate;
import br.com.gda.business.storeLeaveDate.model.action.StdStolevateEnforceLChanged;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckSoftDelete;
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

final class NodeStolevateInsert implements DeciTree<StolevateInfo> {
	private DeciTree<StolevateInfo> tree;
	
	
	public NodeStolevateInsert(DeciTreeOption<StolevateInfo> option) {
		DeciTreeHelperOption<StolevateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StolevateInfo> buildDecisionChecker(DeciTreeOption<StolevateInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<StolevateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolevateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new StolevateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StolevateInfo>> buildActionsOnPassed(DeciTreeOption<StolevateInfo> option) {
		List<ActionStd<StolevateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolevateInfo> enforceLChanged = new StdStolevateEnforceLChanged(option);
		ActionLazy<StolevateInfo> enforceLChangedBy = new LazyStolevateMergeUsername(option.conn, option.schemaName);
		ActionLazy<StolevateInfo> insert = new LazyStolevateInsert(option.conn, option.schemaName);
		ActionLazy<StolevateInfo> select = new LazyStolevateRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
	
	
	
	private List<ActionStd<StolevateInfo>> buildActionsOnFailed(DeciTreeOption<StolevateInfo> option) {
		List<ActionStd<StolevateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolevateInfo> enforceLChanged = new StdStolevateEnforceLChanged(option);
		ActionLazy<StolevateInfo> enforceLChangedBy = new LazyStolevateMergeUsername(option.conn, option.schemaName);
		ActionLazy<StolevateInfo> update = new LazyStolevateUpdate(option.conn, option.schemaName);
		ActionLazy<StolevateInfo> select = new LazyStolevateRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(enforceLChanged);				
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
