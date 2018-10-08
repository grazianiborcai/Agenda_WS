package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStoreWTimeSelect implements DeciTree<StoreWTimeInfo> {
	private DeciTree<StoreWTimeInfo> tree;
	
	
	public RootStoreWTimeSelect(DeciTreeOption<StoreWTimeInfo> option) {
		DeciTreeHelperOption<StoreWTimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreWTimeInfo> buildDecisionChecker() {
		List<ModelChecker<StoreWTimeInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreWTimeInfo> checker;
		
		checker = new StoreWTimeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StoreWTimeInfo>> buildActionsOnPassed(DeciTreeOption<StoreWTimeInfo> option) {
		List<ActionStd<StoreWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionStoreWTimeSelect(option));
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
	
	
	
	@Override public ActionStd<StoreWTimeInfo> toAction() {
		return tree.toAction();
	}
}
