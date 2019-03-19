package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.action.LazyMatoreInsert;
import br.com.gda.business.materialStore.model.action.LazyMatoreMergeUsername;
import br.com.gda.business.materialStore.model.action.LazyMatoreSelect;
import br.com.gda.business.materialStore.model.action.LazyMatoreUpdate;
import br.com.gda.business.materialStore.model.action.StdMatoreEnforceLChanged;
import br.com.gda.business.materialStore.model.checker.MatoreCheckSoftDelete;
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

final class NodeMatoreInsert implements DeciTree<MatoreInfo> {
	private DeciTree<MatoreInfo> tree;
	
	
	public NodeMatoreInsert(DeciTreeOption<MatoreInfo> option) {
		DeciTreeHelperOption<MatoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatoreInfo> buildDecisionChecker(DeciTreeOption<MatoreInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new MatoreCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatoreInfo>> buildActionsOnPassed(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> enforceLChanged = new StdMatoreEnforceLChanged(option);
		ActionLazy<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> insert = new LazyMatoreInsert(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> select = new LazyMatoreSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
	
	
	
	private List<ActionStd<MatoreInfo>> buildActionsOnFailed(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> enforceLChanged = new StdMatoreEnforceLChanged(option);
		ActionLazy<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> update = new LazyMatoreUpdate(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> select = new LazyMatoreSelect(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<MatoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatoreInfo> toAction() {
		return tree.toAction();
	}
}
