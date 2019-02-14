package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.AuthGroupInfo;
import br.com.gda.business.masterData.model.action.StdAuthGroupSelect;
import br.com.gda.business.masterData.model.checker.AuthGroupCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAuthGroupSelect implements DeciTree<AuthGroupInfo> {
	private DeciTree<AuthGroupInfo> tree;
	
	
	public RootAuthGroupSelect(DeciTreeOption<AuthGroupInfo> option) {
		DeciTreeHelperOption<AuthGroupInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AuthGroupInfo> buildDecisionChecker() {
		List<ModelChecker<AuthGroupInfo>> queue = new ArrayList<>();		
		ModelChecker<AuthGroupInfo> checker;
		
		checker = new AuthGroupCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<AuthGroupInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<AuthGroupInfo>> buildActionsOnPassed(DeciTreeOption<AuthGroupInfo> option) {
		List<ActionStd<AuthGroupInfo>> actions = new ArrayList<>();
		
		ActionStd<AuthGroupInfo> select = new StdAuthGroupSelect(option);
		
		actions.add(select);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<AuthGroupInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
