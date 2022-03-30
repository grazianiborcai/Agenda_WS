package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.PhoneVisiDaoUpdate;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceDefaultOff;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceLChanged;
import br.com.mind5.business.phone.model.action.PhoneVisiMergePhonault;
import br.com.mind5.business.phone.model.action.PhoneVisiMergeToSelect;
import br.com.mind5.business.phone.model.action.PhoneVisiMergeUsername;
import br.com.mind5.business.phone.model.checker.PhoneCheckPhonault;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhoneNodeDefaultL2 extends DeciTreeTemplateWrite<PhoneInfo> {
	
	public PhoneNodeDefaultL2(DeciTreeOption<PhoneInfo> option) {
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
		
		ActionStd<PhoneInfo> mergePhonault = new ActionStdCommom<PhoneInfo>(option, PhoneVisiMergePhonault.class);
		ActionLazy<PhoneInfo> mergeToSelect = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiMergeToSelect.class);
		ActionLazy<PhoneInfo> enforceLChanged = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiEnforceLChanged.class);	
		ActionLazy<PhoneInfo> enforceLChangedBy = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiMergeUsername.class);
		ActionLazy<PhoneInfo> enforceDefaultOff = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiEnforceDefaultOff.class);
		ActionLazy<PhoneInfo> update = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiDaoUpdate.class);
		ActionStd<PhoneInfo> success = new ActionStdSuccessCommom<PhoneInfo>(option);
		
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

		ActionStd<PhoneInfo> success = new ActionStdSuccessCommom<PhoneInfo>(option);	
		actions.add(success);
		
		return actions;
	}
}
