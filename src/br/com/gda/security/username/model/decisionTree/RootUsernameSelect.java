package br.com.gda.security.username.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.action.StdUsernameSelect;
import br.com.gda.security.username.model.checker.UsernameCheckRead;

public final class RootUsernameSelect implements DeciTree<UsernameInfo> {
	private DeciTree<UsernameInfo> tree;
	
	
	public RootUsernameSelect(DeciTreeOption<UsernameInfo> option) {
		DeciTreeHelperOption<UsernameInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UsernameInfo> buildDecisionChecker() {
		List<ModelChecker<UsernameInfo>> queue = new ArrayList<>();		
		ModelChecker<UsernameInfo> checker;
		
		checker = new UsernameCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<UsernameInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<UsernameInfo>> buildActionsOnPassed(DeciTreeOption<UsernameInfo> option) {
		List<ActionStd<UsernameInfo>> actions = new ArrayList<>();
		
		ActionStd<UsernameInfo> select = new StdUsernameSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UsernameInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
