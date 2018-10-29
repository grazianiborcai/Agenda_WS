package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.StdAddressDelete;
import br.com.gda.business.address.model.checker.AddressCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeDummy;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAddressDelete implements DeciTree<AddressInfo> {
	private DeciTree<AddressInfo> tree;
	
	
	public RootAddressDelete(DeciTreeOption<AddressInfo> option) {
		DeciTreeHelperOption<AddressInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AddressInfo> buildDecisionChecker(DeciTreeOption<AddressInfo> option) {		
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		
		checker = new AddressCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<AddressInfo>> buildActionsOnPassed(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> deleteHdr = new StdAddressDelete(option);		
		actions.add(deleteHdr);		
		
		return actions;
	}
	
	
	
	
	private List<ActionStd<AddressInfo>> buildActionsOnFailed(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> dummyAction = getDummyAction();		
		actions.add(dummyAction);		
		return actions;
	}
	
	
	
	private ActionStd<AddressInfo> getDummyAction() {
		List<AddressInfo> dummyResults = new ArrayList<>();
		AddressInfo dummyRecord = new AddressInfo();
		dummyResults.add(dummyRecord);
		
		DeciTreeDummy<AddressInfo> dummyTree = new DeciTreeDummy<>(dummyResults);
		return dummyTree.toAction();
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
