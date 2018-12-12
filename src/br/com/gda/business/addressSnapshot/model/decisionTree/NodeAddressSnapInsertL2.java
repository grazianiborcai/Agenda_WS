package br.com.gda.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.action.LazyAddressSnapInsert;
import br.com.gda.business.addressSnapshot.model.action.StdAddressSnapMergeAddress;
import br.com.gda.business.addressSnapshot.model.checker.AddressSnapCheckExist;
import br.com.gda.business.addressSnapshot.model.checker.AddressSnapCheckSnap;
import br.com.gda.model.action.ActionLazy;
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

public final class NodeAddressSnapInsertL2 implements DeciTree<AddressSnapInfo> {
	private DeciTree<AddressSnapInfo> tree;
	
	
	public NodeAddressSnapInsertL2(DeciTreeOption<AddressSnapInfo> option) {
		DeciTreeHelperOption<AddressSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AddressSnapInfo> buildDecisionChecker(DeciTreeOption<AddressSnapInfo> option) {
		final boolean EXIST = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<AddressSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new AddressSnapCheckSnap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;	
		checker = new AddressSnapCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<AddressSnapInfo>> buildActionsOnPassed(DeciTreeOption<AddressSnapInfo> option) {
		List<ActionStd<AddressSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddressSnapInfo> mergeAddress = new StdAddressSnapMergeAddress(option);	
		ActionLazy<AddressSnapInfo> insert = new LazyAddressSnapInsert(option.conn, option.schemaName);
		
		mergeAddress.addPostAction(insert);
		
		actions.add(mergeAddress);
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
