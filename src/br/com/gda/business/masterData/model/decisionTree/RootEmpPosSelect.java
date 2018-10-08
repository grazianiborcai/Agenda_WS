package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.business.masterData.model.checker.EmpPosCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
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
		List<ModelChecker<EmpPosInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpPosInfo> checker;
		
		checker = new EmpPosCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmpPosInfo>> buildActionsOnPassed(DeciTreeOption<EmpPosInfo> option) {
		List<ActionStd<EmpPosInfo>> actions = new ArrayList<>();
		
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
	
	
	
	@Override public ActionStd<EmpPosInfo> toAction() {
		return tree.toAction();
	}
}
