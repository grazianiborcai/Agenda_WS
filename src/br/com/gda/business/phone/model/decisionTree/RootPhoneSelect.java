package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazyPhoneMergeCountryPhone;
import br.com.gda.business.phone.model.action.LazyPhoneMergeForm;
import br.com.gda.business.phone.model.action.StdPhoneMergeToSelect;
import br.com.gda.business.phone.model.checker.PhoneCheckLangu;
import br.com.gda.business.phone.model.checker.PhoneCheckOwner;
import br.com.gda.business.phone.model.checker.PhoneCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPhoneSelect extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public RootPhoneSelect(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> select = new StdPhoneMergeToSelect(option);	
		ActionLazy<PhoneInfo> mergeCountryPhone = new LazyPhoneMergeCountryPhone(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> mergeForm = new LazyPhoneMergeForm(option.conn, option.schemaName);

		select.addPostAction(mergeCountryPhone);	
		mergeCountryPhone.addPostAction(mergeForm);
		
		actions.add(select);
		
		return actions;
	}
}
