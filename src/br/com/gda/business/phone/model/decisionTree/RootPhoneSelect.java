package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazymapPhoneMergeCountryPhone;
import br.com.gda.business.phone.model.action.LazymapPhoneMergeForm;
import br.com.gda.business.phone.model.action.StdPhoneSelect;
import br.com.gda.business.phone.model.checker.PhoneCheckRead;
import br.com.gda.business.phone.model.checker.PhoneCheckRef;
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

public final class RootPhoneSelect implements DeciTree<PhoneInfo> {
	private DeciTree<PhoneInfo> tree;
	
	
	public RootPhoneSelect(DeciTreeOption<PhoneInfo> option) {
		DeciTreeHelperOption<PhoneInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PhoneInfo> buildDecisionChecker(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		
		checker = new PhoneCheckRead();
		queue.add(checker);
		
		checker = new PhoneCheckRef();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PhoneInfo>> buildActionsOnPassed(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> select = new StdPhoneSelect(option);	
		ActionLazy<PhoneInfo> mergeCountryPhone = new LazymapPhoneMergeCountryPhone(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> mergeForm = new LazymapPhoneMergeForm(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<PhoneInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PhoneInfo> toAction() {
		return tree.toAction();
	}
}
