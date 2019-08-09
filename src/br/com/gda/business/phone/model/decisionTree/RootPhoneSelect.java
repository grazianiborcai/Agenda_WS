package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazymapPhoneMergeCountryPhone;
import br.com.gda.business.phone.model.action.LazymapPhoneMergeForm;
import br.com.gda.business.phone.model.action.StdPhoneMergeToSelect;
import br.com.gda.business.phone.model.checker.PhoneCheckRead;
import br.com.gda.business.phone.model.checker.PhoneCheckRefRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootPhoneSelect extends DeciTreeReadTemplate<PhoneInfo> {
	
	public RootPhoneSelect(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		
		checker = new PhoneCheckRead();
		queue.add(checker);
		
		checker = new PhoneCheckRefRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> select = new StdPhoneMergeToSelect(option);	
		ActionLazy<PhoneInfo> mergeCountryPhone = new LazymapPhoneMergeCountryPhone(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> mergeForm = new LazymapPhoneMergeForm(option.conn, option.schemaName);

		select.addPostAction(mergeCountryPhone);	
		mergeCountryPhone.addPostAction(mergeForm);
		
		actions.add(select);
		
		return actions;
	}
}
