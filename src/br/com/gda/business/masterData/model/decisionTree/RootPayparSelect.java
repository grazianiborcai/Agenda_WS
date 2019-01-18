package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.action.StdPayparSelect;
import br.com.gda.business.masterData.model.checker.PayparCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootPayparSelect implements DeciTree<PayparInfo> {
	private DeciTree<PayparInfo> tree;
	
	
	public RootPayparSelect(DeciTreeOption<PayparInfo> option) {
		DeciTreeHelperOption<PayparInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayparInfo> buildDecisionChecker() {
		List<ModelChecker<PayparInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparInfo> checker;
		
		checker = new PayparCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<PayparInfo>> buildActionsOnPassed(DeciTreeOption<PayparInfo> option) {
		List<ActionStd<PayparInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPayparSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PayparInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayparInfo> toAction() {
		return tree.toAction();
	}
}
