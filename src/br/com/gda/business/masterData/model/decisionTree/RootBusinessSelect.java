package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.business.masterData.model.checker.BusinessCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
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
		List<ModelChecker<BusinessInfo>> stack = new ArrayList<>();		
		ModelChecker<BusinessInfo> checker;
		
		checker = new BusinessCheckRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<BusinessInfo>> buildActionsOnPassed(DeciTreeOption<BusinessInfo> option) {
		List<DeciAction<BusinessInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionBusinessSelect(option));
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
}
