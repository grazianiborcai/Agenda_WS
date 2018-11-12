package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressNodeUpsertdelL3;
import br.com.gda.business.address.model.action.LazyAddressRootInsert;
import br.com.gda.business.address.model.action.StdAddressFilterNew;
import br.com.gda.business.address.model.action.StdAddressFilterOld;
import br.com.gda.business.address.model.checker.AddressCheckNewRecord;
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

public final class NodeAddressUpsertdelL2 implements DeciTree<AddressInfo> {
	private DeciTree<AddressInfo> tree;
	
	
	public NodeAddressUpsertdelL2(DeciTreeOption<AddressInfo> option) {
		DeciTreeHelperOption<AddressInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AddressInfo> buildDecisionChecker(DeciTreeOption<AddressInfo> option) {
		final boolean ONLY_OLD_RECORD = false;
		
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ONLY_OLD_RECORD;	
		checker = new AddressCheckNewRecord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<AddressInfo>> buildActionsOnPassed(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> nodeL3 = new NodeAddressUpsertdelL3(option).toAction();
		
		actions.add(nodeL3);	
		return actions;
	}
	
	
	
	private List<ActionStd<AddressInfo>> buildActionsOnFailed(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> filterOld = new StdAddressFilterOld(option);			
		ActionLazy<AddressInfo> nodeL3 = new LazyAddressNodeUpsertdelL3(option.conn, option.schemaName);
		ActionStd<AddressInfo> filterNew = new StdAddressFilterNew(option);			
		ActionLazy<AddressInfo> insert = new LazyAddressRootInsert(option.conn, option.schemaName);
		
		//ActionStd<AddressInfo> select = new RootAddressSelect(option).toAction();	//TODO: temp

		
		filterOld.addPostAction(nodeL3);
		filterNew.addPostAction(insert);
		
		//TODO: MERGE resultado
		
		actions.add(filterOld);		
		actions.add(filterNew);	
		//actions.add(select);	
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
