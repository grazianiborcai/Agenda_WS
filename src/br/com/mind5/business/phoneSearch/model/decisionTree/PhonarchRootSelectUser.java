package br.com.mind5.business.phoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.action.PhonarchVisiEnforceUserKey;
import br.com.mind5.business.phoneSearch.model.action.PhonarchVisiRootSelect;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckReadUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhonarchRootSelectUser extends DeciTreeTemplateWrite<PhonarchInfo> {
	
	public PhonarchRootSelectUser(DeciTreeOption<PhonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonarchInfo> buildCheckerHook(DeciTreeOption<PhonarchInfo> option) {
		List<ModelChecker<PhonarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhonarchCheckReadUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhonarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonarchInfo> option) {
		List<ActionStd<PhonarchInfo>> actions = new ArrayList<>();		
		
		ActionStd <PhonarchInfo> enforceUserKey = new ActionStdCommom <PhonarchInfo>(option, PhonarchVisiEnforceUserKey.class);
		ActionLazy<PhonarchInfo> select         = new ActionLazyCommom<PhonarchInfo>(option, PhonarchVisiRootSelect.class);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);		
		return actions;
	}
}
