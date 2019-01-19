package br.com.gda.payService.payCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusMergeAddress;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusMergePerson;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusMergePhone;
import br.com.gda.payService.payCustomer.model.action.StdPaycusSelect;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckRead;

public final class RootPaycusSelect implements DeciTree<PaycusInfo> {
	private DeciTree<PaycusInfo> tree;
	
	
	public RootPaycusSelect(DeciTreeOption<PaycusInfo> option) {
		DeciTreeHelperOption<PaycusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PaycusInfo> buildDecisionChecker() {
		List<ModelChecker<PaycusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaycusInfo> checker;
		
		checker = new PaycusCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PaycusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PaycusInfo>> buildActionsOnPassed(DeciTreeOption<PaycusInfo> option) {
		List<ActionStd<PaycusInfo>> actions = new ArrayList<>();
		
		ActionStd<PaycusInfo> select = new StdPaycusSelect(option);
		ActionLazy<PaycusInfo> mergePerson = new LazyPaycusMergePerson(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> mergeAddress = new LazyPaycusMergeAddress(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> mergePhone = new LazyPaycusMergePhone(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PaycusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
