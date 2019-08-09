package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazyPhoneEnforceLChanged;
import br.com.gda.business.phone.model.action.LazyPhoneNodeSnapshot;
import br.com.gda.business.phone.model.action.LazymapPhoneMergeForm;
import br.com.gda.business.phone.model.action.LazymapPhoneNodeInsert;
import br.com.gda.business.phone.model.action.StdPhoneMergeCountryPhone;
import br.com.gda.business.phone.model.checker.PhoneCheckCountryPhone;
import br.com.gda.business.phone.model.checker.PhoneCheckInsert;
import br.com.gda.business.phone.model.checker.PhoneCheckLength;
import br.com.gda.business.phone.model.checker.PhoneCheckLimit;
import br.com.gda.business.phone.model.checker.PhoneCheckOwner;
import br.com.gda.business.phone.model.checker.PhoneCheckRefMulti;
import br.com.gda.business.phone.model.checker.PhoneCheckRefWrite;
import br.com.gda.business.phone.model.checker.PhoneCheckTechField;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPhoneInsert extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public RootPhoneInsert(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PhoneCheckInsert();
		queue.add(checker);
		
		checker = new PhoneCheckTechField();
		queue.add(checker);
		
		checker = new PhoneCheckLength();
		queue.add(checker);
		
		checker = new PhoneCheckRefWrite();
		queue.add(checker);
		
		checker = new PhoneCheckRefMulti();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new PhoneCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new PhoneCheckCountryPhone(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checker = new PhoneCheckLimit(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();	
		
		ActionStd<PhoneInfo> mergeCountryPhone = new StdPhoneMergeCountryPhone(option);	
		ActionLazy<PhoneInfo> mergeForm = new LazymapPhoneMergeForm(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> enforceLChanged = new LazyPhoneEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> nodeInsert = new LazymapPhoneNodeInsert(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> nodeSnapshot = new LazyPhoneNodeSnapshot(option.conn, option.schemaName);	
		
		mergeCountryPhone.addPostAction(mergeForm);
		mergeForm.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(nodeInsert);
		nodeInsert.addPostAction(nodeSnapshot);
		
		actions.add(mergeCountryPhone);		
		return actions;
	}
}
