package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.action.StdMatTypeSelect;
import br.com.gda.business.masterData.model.checker.MatTypeCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatTypeSelect implements DeciTree<MatTypeInfo> {
	private DeciTree<MatTypeInfo> tree;
	
	
	public RootMatTypeSelect(DeciTreeOption<MatTypeInfo> option) {
		DeciTreeHelperOption<MatTypeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatTypeInfo> buildDecisionChecker() {
		List<ModelChecker<MatTypeInfo>> queue = new ArrayList<>();		
		ModelChecker<MatTypeInfo> checker;
		
		checker = new MatTypeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatTypeInfo>> buildActionsOnPassed(DeciTreeOption<MatTypeInfo> option) {
		List<ActionStd<MatTypeInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMatTypeSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatTypeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatTypeInfo> toAction() {
		return tree.toAction();
	}
}
