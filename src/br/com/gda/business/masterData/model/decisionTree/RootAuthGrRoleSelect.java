package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.masterData.model.action.StdAuthGrRoleSelect;
import br.com.gda.business.masterData.model.checker.AuthGrRoleCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAuthGrRoleSelect implements DeciTree<AuthGrRoleInfo> {
	private DeciTree<AuthGrRoleInfo> tree;
	
	
	public RootAuthGrRoleSelect(DeciTreeOption<AuthGrRoleInfo> option) {
		DeciTreeHelperOption<AuthGrRoleInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AuthGrRoleInfo> buildDecisionChecker() {
		List<ModelChecker<AuthGrRoleInfo>> queue = new ArrayList<>();		
		ModelChecker<AuthGrRoleInfo> checker;
		
		checker = new AuthGrRoleCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<AuthGrRoleInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<AuthGrRoleInfo>> buildActionsOnPassed(DeciTreeOption<AuthGrRoleInfo> option) {
		List<ActionStd<AuthGrRoleInfo>> actions = new ArrayList<>();
		
		ActionStd<AuthGrRoleInfo> select = new StdAuthGrRoleSelect(option);
		
		actions.add(select);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<AuthGrRoleInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
