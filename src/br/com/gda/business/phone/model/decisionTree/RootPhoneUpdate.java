package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazyPhoneEnforceLChanged;
import br.com.gda.business.phone.model.action.LazyPhoneMergeCountryPhone;
import br.com.gda.business.phone.model.action.LazyPhoneMergeForm;
import br.com.gda.business.phone.model.action.LazyPhoneMergeUsername;
import br.com.gda.business.phone.model.action.LazyPhoneNodeSnapshot;
import br.com.gda.business.phone.model.action.LazyPhoneNodeUpdate;
import br.com.gda.business.phone.model.action.StdPhoneMergeToUpdate;
import br.com.gda.business.phone.model.checker.PhoneCheckCountryPhone;
import br.com.gda.business.phone.model.checker.PhoneCheckExist;
import br.com.gda.business.phone.model.checker.PhoneCheckLangu;
import br.com.gda.business.phone.model.checker.PhoneCheckLength;
import br.com.gda.business.phone.model.checker.PhoneCheckOwner;
import br.com.gda.business.phone.model.checker.PhoneCheckRefMulti;
import br.com.gda.business.phone.model.checker.PhoneCheckRefWrite;
import br.com.gda.business.phone.model.checker.PhoneCheckUpdate;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPhoneUpdate extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public RootPhoneUpdate(DeciTreeOption<PhoneInfo> option) {
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
		checker = new PhoneCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhoneCheckLength(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhoneCheckRefWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhoneCheckRefMulti(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckCountryPhone(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> mergeToUpdate = new StdPhoneMergeToUpdate(option);	
		ActionLazy<PhoneInfo> mergeCountryPhone = new LazyPhoneMergeCountryPhone(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> mergeForm = new LazyPhoneMergeForm(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> mergeUsername = new LazyPhoneMergeUsername(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> enforceLChanged = new LazyPhoneEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> nodeUpdate = new LazyPhoneNodeUpdate(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> nodeSnapshot = new LazyPhoneNodeSnapshot(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(mergeCountryPhone);
		mergeCountryPhone.addPostAction(mergeForm);
		mergeForm.addPostAction(mergeUsername);		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(nodeSnapshot);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
}
