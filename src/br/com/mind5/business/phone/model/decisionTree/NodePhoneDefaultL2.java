package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.LazyPhoneDaoUpdate;
import br.com.mind5.business.phone.model.action.LazyPhoneEnforceDefaultOff;
import br.com.mind5.business.phone.model.action.LazyPhoneEnforceLChanged;
import br.com.mind5.business.phone.model.action.LazyPhoneMergeToSelect;
import br.com.mind5.business.phone.model.action.LazyPhoneMergeUsername;
import br.com.mind5.business.phone.model.action.StdPhoneMergePhonault;
import br.com.mind5.business.phone.model.action.StdPhoneSuccess;
import br.com.mind5.business.phone.model.checker.PhoneCheckPhonault;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodePhoneDefaultL2 extends DeciTreeTemplateWrite<PhoneInfo> {
	
	public NodePhoneDefaultL2(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckPhonault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();
		
		ActionStd<PhoneInfo> mergePhonault = new StdPhoneMergePhonault(option);
		ActionLazy<PhoneInfo> mergeToSelect = new LazyPhoneMergeToSelect(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> enforceLChanged = new LazyPhoneEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> enforceLChangedBy = new LazyPhoneMergeUsername(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> enforceDefaultOff = new LazyPhoneEnforceDefaultOff(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> update = new LazyPhoneDaoUpdate(option.conn, option.schemaName);
		ActionStd<PhoneInfo> success = new StdPhoneSuccess(option);	
		
		mergePhonault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergePhonault);
		actions.add(success);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();

		ActionStd<PhoneInfo> success = new StdPhoneSuccess(option);		
		actions.add(success);
		
		return actions;
	}
}
