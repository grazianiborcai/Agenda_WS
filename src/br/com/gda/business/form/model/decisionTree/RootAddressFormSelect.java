package br.com.gda.business.form.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.business.form.model.checker.AddressFormCheckCountry;
import br.com.gda.business.form.model.checker.AddressFormCheckRead;
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

public final class RootAddressFormSelect implements DeciTree<AddressFormInfo> {
	private DeciTree<AddressFormInfo> tree;
	
	
	public RootAddressFormSelect(DeciTreeOption<AddressFormInfo> option) {
		DeciTreeHelperOption<AddressFormInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AddressFormInfo> buildDecisionChecker(DeciTreeOption<AddressFormInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<AddressFormInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressFormInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new AddressFormCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new AddressFormCheckCountry(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<AddressFormInfo>> buildActionsOnPassed(DeciTreeOption<AddressFormInfo> option) {
		List<ActionStd<AddressFormInfo>> actions = new ArrayList<>();
		
		actions.add(new NodeAddressFormSelect(option).toAction());
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<AddressFormInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<AddressFormInfo> toAction() {
		return tree.toAction();
	}
}
