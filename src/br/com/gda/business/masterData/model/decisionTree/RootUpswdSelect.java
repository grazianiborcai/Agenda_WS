package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.RolurInfo;
import br.com.gda.business.masterData.model.action.StdRolurSelect;
import br.com.gda.business.masterData.model.checker.RolurCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootUpswdSelect implements DeciTree<RolurInfo> {
	private DeciTree<RolurInfo> tree;
	
	
	public RootUpswdSelect(DeciTreeOption<RolurInfo> option) {
		DeciTreeHelperOption<RolurInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<RolurInfo> buildDecisionChecker() {
		List<ModelChecker<RolurInfo>> queue = new ArrayList<>();		
		ModelChecker<RolurInfo> checker;
		
		checker = new RolurCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<RolurInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<RolurInfo>> buildActionsOnPassed(DeciTreeOption<RolurInfo> option) {
		List<ActionStd<RolurInfo>> actions = new ArrayList<>();
		
		ActionStd<RolurInfo> select = new StdRolurSelect(option);
		
		actions.add(select);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<RolurInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
