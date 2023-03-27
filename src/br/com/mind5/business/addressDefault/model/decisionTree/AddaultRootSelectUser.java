package br.com.mind5.business.addressDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.action.AddaultVisiEnforceUserKey;
import br.com.mind5.business.addressDefault.model.action.AddaultVisiRootSelect;
import br.com.mind5.business.addressDefault.model.checker.AddaultCheckReadUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddaultRootSelectUser extends DeciTreeTemplateWrite<AddaultInfo> {
	
	public AddaultRootSelectUser(DeciTreeOption<AddaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddaultInfo> buildCheckerHook(DeciTreeOption<AddaultInfo> option) {
		List<ModelChecker<AddaultInfo>> queue = new ArrayList<>();		
		ModelChecker<AddaultInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddaultCheckReadUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddaultInfo>> buildActionsOnPassedHook(DeciTreeOption<AddaultInfo> option) {
		List<ActionStd<AddaultInfo>> actions = new ArrayList<>();		
		
		ActionStd <AddaultInfo> enforceUserKey = new ActionStdCommom <AddaultInfo>(option, AddaultVisiEnforceUserKey.class);
		ActionLazy<AddaultInfo> select         = new ActionLazyCommom<AddaultInfo>(option, AddaultVisiRootSelect.class);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);			
		return actions;
	}
}
