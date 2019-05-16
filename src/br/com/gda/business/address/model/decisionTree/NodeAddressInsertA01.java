package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressInsertAddresnap;
import br.com.gda.business.address.model.action.LazyAddressUpdate;
import br.com.gda.business.address.model.action.StdAddressInsert;
import br.com.gda.business.address.model.checker.AddressCheckState;
import br.com.gda.business.address.model.checker.AddressCheckWriteA01;
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

public final class NodeAddressInsertA01 implements DeciTree<AddressInfo> {
	private DeciTree<AddressInfo> tree;
	
	
	public NodeAddressInsertA01(DeciTreeOption<AddressInfo> option) {
		DeciTreeHelperOption<AddressInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AddressInfo> buildDecisionChecker(DeciTreeOption<AddressInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;

		checker = new AddressCheckWriteA01();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new AddressCheckState(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<AddressInfo>> buildActionsOnPassed(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();
		
		ActionStd<AddressInfo> insert = new StdAddressInsert(option);	
		ActionLazy<AddressInfo> insertAddresnap = new LazyAddressInsertAddresnap(option.conn, option.schemaName);
		ActionLazy<AddressInfo> update = new LazyAddressUpdate(option.conn, option.schemaName);

		insert.addPostAction(insertAddresnap);
		insertAddresnap.addPostAction(update);
		
		actions.add(insert);		
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
