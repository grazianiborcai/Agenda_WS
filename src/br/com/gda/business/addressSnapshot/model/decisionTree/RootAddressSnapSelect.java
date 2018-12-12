package br.com.gda.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.action.LazymapAddressSnapMergeForm;
import br.com.gda.business.addressSnapshot.model.action.StdAddressSnapSelect;
import br.com.gda.business.addressSnapshot.model.checker.AddressSnapCheckRead;
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

public final class RootAddressSnapSelect implements DeciTree<AddressSnapInfo> {
	private DeciTree<AddressSnapInfo> tree;
	
	
	public RootAddressSnapSelect(DeciTreeOption<AddressSnapInfo> option) {
		DeciTreeHelperOption<AddressSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AddressSnapInfo> buildDecisionChecker(DeciTreeOption<AddressSnapInfo> option) {
		List<ModelChecker<AddressSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressSnapInfo> checker;	
		
		checker = new AddressSnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<AddressSnapInfo>> buildActionsOnPassed(DeciTreeOption<AddressSnapInfo> option) {
		List<ActionStd<AddressSnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressSnapInfo> select = new StdAddressSnapSelect(option);		
		ActionLazy<AddressSnapInfo> mergeForm = new LazymapAddressSnapMergeForm(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<AddressSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<AddressSnapInfo> toAction() {
		return tree.toAction();
	}
}
