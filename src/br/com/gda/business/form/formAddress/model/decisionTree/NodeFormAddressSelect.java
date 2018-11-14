package br.com.gda.business.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.model.action.StdFormAddressEnforceDefault;
import br.com.gda.business.form.formAddress.model.action.StdFormAddressSelect;
import br.com.gda.business.form.formAddress.model.checker.FormAddressCheckExist;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeFormAddressSelect implements DeciTree<FormAddressInfo> {
	private DeciTree<FormAddressInfo> tree;
	
	
	public NodeFormAddressSelect(DeciTreeOption<FormAddressInfo> option) {
		DeciTreeHelperOption<FormAddressInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FormAddressInfo> buildDecisionChecker(DeciTreeOption<FormAddressInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<FormAddressInfo>> queue = new ArrayList<>();		
		ModelChecker<FormAddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new FormAddressCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<FormAddressInfo>> buildActionsOnPassed(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStd<FormAddressInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFormAddressSelect(option));
		return actions;
	}
	
	
	
	private List<ActionStd<FormAddressInfo>> buildActionsOnFailed(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStd<FormAddressInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFormAddressEnforceDefault(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FormAddressInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FormAddressInfo> toAction() {
		return tree.toAction();
	}
}
