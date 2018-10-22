package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.business.masterData.model.action.StdBusinessSelect;
import br.com.gda.business.masterData.model.checker.BusinessCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootBusinessSelect implements DeciTree<BusinessInfo> {
	private DeciTree<BusinessInfo> tree;
	
	
	public RootBusinessSelect(DeciTreeOption<BusinessInfo> option) {
		DeciTreeHelperOption<BusinessInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<BusinessInfo> buildDecisionChecker() {
		List<ModelChecker<BusinessInfo>> queue = new ArrayList<>();		
		ModelChecker<BusinessInfo> checker;
		
		checker = new BusinessCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<BusinessInfo>> buildActionsOnPassed(DeciTreeOption<BusinessInfo> option) {
		List<ActionStd<BusinessInfo>> actions = new ArrayList<>();
		
		actions.add(new StdBusinessSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<BusinessInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<BusinessInfo> toAction() {
		return tree.toAction();
	}
}
