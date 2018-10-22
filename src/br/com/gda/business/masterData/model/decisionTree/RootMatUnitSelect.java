package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.action.StdMatUnitSelect;
import br.com.gda.business.masterData.model.checker.MatUnitCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatUnitSelect implements DeciTree<MatUnitInfo> {
	private DeciTree<MatUnitInfo> tree;
	
	
	public RootMatUnitSelect(DeciTreeOption<MatUnitInfo> option) {
		DeciTreeHelperOption<MatUnitInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatUnitInfo> buildDecisionChecker() {
		List<ModelChecker<MatUnitInfo>> queue = new ArrayList<>();		
		ModelChecker<MatUnitInfo> checker;
		
		checker = new MatUnitCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatUnitInfo>> buildActionsOnPassed(DeciTreeOption<MatUnitInfo> option) {
		List<ActionStd<MatUnitInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMatUnitSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatUnitInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatUnitInfo> toAction() {
		return tree.toAction();
	}
}
