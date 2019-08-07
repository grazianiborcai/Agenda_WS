package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.business.masterData.model.action.StdSysEnvironSelect;
import br.com.gda.business.masterData.model.checker.SysEnvironCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootSysEnvironSelect implements DeciTree<SysEnvironInfo> {
	private DeciTree<SysEnvironInfo> tree;
	
	
	public RootSysEnvironSelect(DeciTreeOption<SysEnvironInfo> option) {
		DeciTreeHelperOption<SysEnvironInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<SysEnvironInfo> buildDecisionChecker() {
		List<ModelChecker<SysEnvironInfo>> queue = new ArrayList<>();		
		ModelChecker<SysEnvironInfo> checker;
		
		checker = new SysEnvironCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<SysEnvironInfo>> buildActionsOnPassed(DeciTreeOption<SysEnvironInfo> option) {
		List<ActionStd<SysEnvironInfo>> actions = new ArrayList<>();
		
		ActionStd<SysEnvironInfo> select = new StdSysEnvironSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<SysEnvironInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<SysEnvironInfo> toAction() {
		return tree.toAction();
	}
}
