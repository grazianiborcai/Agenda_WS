package br.com.gda.business.feeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.action.StdFeeStoreMergeStore;
import br.com.gda.business.feeStore.model.action.StdFeeStoreSelect;
import br.com.gda.business.feeStore.model.action.LazyFeeStoreMergeDefault;
import br.com.gda.business.feeStore.model.checker.FeeStoreCheckExist;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class NodeFeeStoreSelect implements DeciTree<FeeStoreInfo> {
	private DeciTree<FeeStoreInfo> tree;
	
	
	public NodeFeeStoreSelect(DeciTreeOption<FeeStoreInfo> option) {
		DeciTreeHelperOption<FeeStoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeeStoreInfo> buildDecisionChecker(DeciTreeOption<FeeStoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<FeeStoreInfo>> queue = new ArrayList<>();		
		ModelChecker<FeeStoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new FeeStoreCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<FeeStoreInfo>> buildActionsOnPassed(DeciTreeOption<FeeStoreInfo> option) {
		List<ActionStd<FeeStoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFeeStoreSelect(option));
		return actions;
	}
	
	
	
	private List<ActionStd<FeeStoreInfo>> buildActionsOnFailed(DeciTreeOption<FeeStoreInfo> option) {
		List<ActionStd<FeeStoreInfo>> actions = new ArrayList<>();
		
		ActionStd<FeeStoreInfo> mergeStore = new StdFeeStoreMergeStore(option);
		ActionLazy<FeeStoreInfo> mergeDefault = new LazyFeeStoreMergeDefault(option.conn, option.schemaName);
		
		mergeStore.addPostAction(mergeDefault);
		
		actions.add(mergeStore);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FeeStoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FeeStoreInfo> toAction() {
		return tree.toAction();
	}
}
