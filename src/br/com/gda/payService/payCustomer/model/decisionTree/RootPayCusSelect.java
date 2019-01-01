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
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusMergeAddress;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusMergePerson;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusMergePhone;
import br.com.gda.payService.payCustomer.model.action.StdPayCusSelect;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckRead;

public final class RootPayCusSelect implements DeciTree<PayCusInfo> {
	private DeciTree<PayCusInfo> tree;
	
	
	public RootPayCusSelect(DeciTreeOption<PayCusInfo> option) {
		DeciTreeHelperOption<PayCusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayCusInfo> buildDecisionChecker() {
		List<ModelChecker<PayCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PayCusInfo> checker;
		
		checker = new PayCusCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PayCusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PayCusInfo>> buildActionsOnPassed(DeciTreeOption<PayCusInfo> option) {
		List<ActionStd<PayCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PayCusInfo> select = new StdPayCusSelect(option);
		ActionLazy<PayCusInfo> mergePerson = new LazyPayCusMergePerson(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> mergeAddress = new LazyPayCusMergeAddress(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> mergePhone = new LazyPayCusMergePhone(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<PayCusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
