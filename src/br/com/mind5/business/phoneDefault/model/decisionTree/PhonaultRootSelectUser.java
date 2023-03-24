package br.com.mind5.business.phoneDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.action.PhonaultVisiEnforceUserKey;
import br.com.mind5.business.phoneDefault.model.action.PhonaultVisiRootSelect;
import br.com.mind5.business.phoneDefault.model.checker.PhonaultCheckReadUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhonaultRootSelectUser extends DeciTreeTemplateWrite<PhonaultInfo> {
	
	public PhonaultRootSelectUser(DeciTreeOption<PhonaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonaultInfo> buildCheckerHook(DeciTreeOption<PhonaultInfo> option) {
		List<ModelChecker<PhonaultInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonaultInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonaultCheckReadUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhonaultInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonaultInfo> option) {
		List<ActionStd<PhonaultInfo>> actions = new ArrayList<>();		
		
		ActionStd <PhonaultInfo> enforceUserKey = new ActionStdCommom <PhonaultInfo>(option, PhonaultVisiEnforceUserKey.class);
		ActionLazy<PhonaultInfo> select         = new ActionLazyCommom<PhonaultInfo>(option, PhonaultVisiRootSelect.class);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);			
		return actions;
	}
}
