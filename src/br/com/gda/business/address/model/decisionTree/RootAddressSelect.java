package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazymapAddressMergeForm;
import br.com.gda.business.address.model.action.StdAddressSelect;
import br.com.gda.business.address.model.checker.AddressCheckRead;
import br.com.gda.business.address.model.checker.AddressCheckRefRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAddressSelect implements DeciTree<AddressInfo> {
	private DeciTree<AddressInfo> tree;
	
	
	public RootAddressSelect(DeciTreeOption<AddressInfo> option) {
		DeciTreeHelperOption<AddressInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AddressInfo> buildDecisionChecker(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		
		checker = new AddressCheckRead();
		queue.add(checker);
		
		checker = new AddressCheckRefRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<AddressInfo>> buildActionsOnPassed(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> select = new StdAddressSelect(option);		
		ActionLazy<AddressInfo> mergeForm = new LazymapAddressMergeForm(option.conn, option.schemaName);
		
		select.addPostAction(mergeForm);		
		actions.add(select);	
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<AddressInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<AddressInfo> toAction() {
		return tree.toAction();
	}
}
