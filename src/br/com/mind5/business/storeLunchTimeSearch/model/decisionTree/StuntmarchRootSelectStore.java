package br.com.mind5.business.storeLunchTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSearch.model.action.StuntmarchVisiEnforceStoreKey;
import br.com.mind5.business.storeLunchTimeSearch.model.action.StuntmarchVisiRootSelect;
import br.com.mind5.business.storeLunchTimeSearch.model.checker.StuntmarchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StuntmarchRootSelectStore extends DeciTreeTemplateRead<StuntmarchInfo> {
	
	public StuntmarchRootSelectStore(DeciTreeOption<StuntmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmarchInfo> buildCheckerHook(DeciTreeOption<StuntmarchInfo> option) {
		List<ModelChecker<StuntmarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmarchInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StuntmarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmarchInfo> option) {
		List<ActionStd<StuntmarchInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmarchInfo> enforceStoreKey = new ActionStdCommom<StuntmarchInfo>(option, StuntmarchVisiEnforceStoreKey.class);
		ActionLazy<StuntmarchInfo> select = new ActionLazyCommom<StuntmarchInfo>(option, StuntmarchVisiRootSelect.class);
		
		enforceStoreKey.addPostAction(select);
		
		actions.add(enforceStoreKey);		
		return actions; 
	}
}
