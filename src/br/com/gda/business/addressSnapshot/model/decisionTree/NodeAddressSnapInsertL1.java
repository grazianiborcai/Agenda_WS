package br.com.gda.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.action.LazyAddressSnapInsert;
import br.com.gda.business.addressSnapshot.model.action.LazyAddressSnapMergeAddress;
import br.com.gda.business.addressSnapshot.model.action.StdAddressSnapMergeSnap;
import br.com.gda.business.addressSnapshot.model.checker.AddressSnapCheckHasSnap;
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

public final class NodeAddressSnapInsertL1 implements DeciTree<AddressSnapInfo> {
	private DeciTree<AddressSnapInfo> tree;
	
	
	public NodeAddressSnapInsertL1(DeciTreeOption<AddressSnapInfo> option) {
		DeciTreeHelperOption<AddressSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AddressSnapInfo> buildDecisionChecker(DeciTreeOption<AddressSnapInfo> option) {
		List<ModelChecker<AddressSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressSnapInfo> checker;	
		
		checker = new AddressSnapCheckHasSnap();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<AddressSnapInfo>> buildActionsOnPassed(DeciTreeOption<AddressSnapInfo> option) {
		List<ActionStd<AddressSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddressSnapInfo> nodeL2 = new NodeAddressSnapInsertL2(option).toAction();	
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	private List<ActionStd<AddressSnapInfo>> buildActionsOnFailed(DeciTreeOption<AddressSnapInfo> option) {
		List<ActionStd<AddressSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddressSnapInfo> mergeSnap = new StdAddressSnapMergeSnap(option);	
		ActionLazy<AddressSnapInfo> mergeAddress = new LazyAddressSnapMergeAddress(option.conn, option.schemaName);	
		ActionLazy<AddressSnapInfo> insert = new LazyAddressSnapInsert(option.conn, option.schemaName);
		
		mergeSnap.addPostAction(mergeAddress);
		mergeAddress.addPostAction(insert);
		
		actions.add(mergeSnap);
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
