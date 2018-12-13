package br.com.gda.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.action.LazymapPhoneSnapMergeCountryPhone;
import br.com.gda.business.phoneSnapshot.model.action.LazymapPhoneSnapMergeForm;
import br.com.gda.business.phoneSnapshot.model.action.StdPhoneSnapSelect;
import br.com.gda.business.phoneSnapshot.model.checker.PhoneSnapCheckRead;
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

public final class RootPhoneSnapSelect implements DeciTree<PhoneSnapInfo> {
	private DeciTree<PhoneSnapInfo> tree;
	
	
	public RootPhoneSnapSelect(DeciTreeOption<PhoneSnapInfo> option) {
		DeciTreeHelperOption<PhoneSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PhoneSnapInfo> buildDecisionChecker(DeciTreeOption<PhoneSnapInfo> option) {
		List<ModelChecker<PhoneSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneSnapInfo> checker;	
		
		checker = new PhoneSnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PhoneSnapInfo>> buildActionsOnPassed(DeciTreeOption<PhoneSnapInfo> option) {
		List<ActionStd<PhoneSnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneSnapInfo> select = new StdPhoneSnapSelect(option);	
		ActionLazy<PhoneSnapInfo> mergeCountryPhone = new LazymapPhoneSnapMergeCountryPhone(option.conn, option.schemaName);
		ActionLazy<PhoneSnapInfo> mergeForm = new LazymapPhoneSnapMergeForm(option.conn, option.schemaName);

		select.addPostAction(mergeCountryPhone);	
		mergeCountryPhone.addPostAction(mergeForm);
		
		actions.add(select);
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PhoneSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PhoneSnapInfo> toAction() {
		return tree.toAction();
	}
}
