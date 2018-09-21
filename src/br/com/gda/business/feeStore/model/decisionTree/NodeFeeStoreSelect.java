package br.com.gda.business.feeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.checker.FeeStoreCheckExist;
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
	
	
	
	private List<DeciAction<FeeStoreInfo>> buildActionsOnPassed(DeciTreeOption<FeeStoreInfo> option) {
		List<DeciAction<FeeStoreInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionFeeStoreSelect(option));
		return actions;
	}
	
	
	
	private List<DeciAction<FeeStoreInfo>> buildActionsOnFailed(DeciTreeOption<FeeStoreInfo> option) {
		List<DeciAction<FeeStoreInfo>> actions = new ArrayList<>();
		
		DeciAction<FeeStoreInfo> mergeStore = new ActionFeeStoreMergeStore(option);
		DeciActionHandler<FeeStoreInfo> mergeDefault = new HandlerFeeStoreMergeDefault(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciAction<FeeStoreInfo> toAction() {
		return tree.toAction();
	}
}
