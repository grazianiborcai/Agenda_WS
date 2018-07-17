package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatEmpSelect implements DeciTree<MatEmpInfo> {
	private DeciTree<MatEmpInfo> tree;
	
	
	public RootMatEmpSelect(DeciTreeOption<MatEmpInfo> option) {
		DeciTreeHelperOption<MatEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatEmpInfo> buildDecisionChecker(DeciTreeOption<MatEmpInfo> option) {
		List<ModelChecker<MatEmpInfo>> queue = new ArrayList<>();		
		ModelChecker<MatEmpInfo> checker;
		
		checker = new MatEmpCheckRead();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<MatEmpInfo>> buildActionsOnPassed(DeciTreeOption<MatEmpInfo> option) {
		List<DeciAction<MatEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionMatEmpSelectAll(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatEmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<MatEmpInfo> toAction() {
		return tree.toAction();
	}
}
