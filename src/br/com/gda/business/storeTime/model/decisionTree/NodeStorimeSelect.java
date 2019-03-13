package br.com.gda.business.storeTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeTime.info.StorimeInfo;
import br.com.gda.business.storeTime.model.action.StdStorimeSuccess;
import br.com.gda.business.storeTime.model.checker.StorimeCheckDataFound;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;


public final class NodeStorimeSelect implements DeciTree<StorimeInfo> {
	private DeciTree<StorimeInfo> tree;
	
	
	public NodeStorimeSelect(DeciTreeOption<StorimeInfo> option) {
		DeciTreeHelperOption<StorimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StorimeInfo> buildDecisionChecker(DeciTreeOption<StorimeInfo> option) {
		List<ModelChecker<StorimeInfo>> queue = new ArrayList<>();		
		ModelChecker<StorimeInfo> checker;
			
		checker = new StorimeCheckDataFound();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StorimeInfo>> buildActionsOnPassed(DeciTreeOption<StorimeInfo> option) {
		List<ActionStd<StorimeInfo>> actions = new ArrayList<>();

		ActionStd<StorimeInfo> success = new StdStorimeSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StorimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StorimeInfo> toAction() {
		return tree.toAction();
	}
}
