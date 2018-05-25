package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.business.masterData.model.checker.EmpPosCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEmpPosSelect implements DeciTree<EmpPosInfo> {
	private DeciTree<EmpPosInfo> tree;
	
	
	public RootEmpPosSelect(DeciTreeOption<EmpPosInfo> option) {
		DeciTreeHelperOption<EmpPosInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpPosInfo> buildDecisionChecker() {
		List<ModelChecker<EmpPosInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpPosInfo> checker;
		
		checker = new EmpPosCheckRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<EmpPosInfo>> buildActionsOnPassed(DeciTreeOption<EmpPosInfo> option) {
		List<DeciAction<EmpPosInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionEmpPosSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpPosInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
