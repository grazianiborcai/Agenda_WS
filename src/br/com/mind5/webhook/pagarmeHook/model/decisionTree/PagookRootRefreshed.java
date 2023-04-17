package br.com.mind5.webhook.pagarmeHook.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiDaoUpdate;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiEnforceIsRefreshedOn;
import br.com.mind5.webhook.pagarmeHook.model.checker.PagookCheckExist;
import br.com.mind5.webhook.pagarmeHook.model.checker.PagookCheckUpdate;

public final class PagookRootRefreshed extends DeciTreeTemplateWrite<PagookInfo> {
	
	public PagookRootRefreshed(DeciTreeOption<PagookInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PagookInfo> buildCheckerHook(DeciTreeOption<PagookInfo> option) {	
		List<ModelChecker<PagookInfo>> queue = new ArrayList<>();		
		ModelChecker<PagookInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PagookCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PagookCheckExist(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PagookInfo>> buildActionsOnPassedHook(DeciTreeOption<PagookInfo> option) {
		List<ActionStd<PagookInfo>> actions = new ArrayList<>();	
		
		ActionStd <PagookInfo> select               = new PagookRootSelect(option).toAction();
		ActionLazy<PagookInfo> enforceIsRefreshedOn = new ActionLazyCommom<PagookInfo>(option, PagookVisiEnforceIsRefreshedOn.class);
		ActionLazy<PagookInfo> update               = new ActionLazyCommom<PagookInfo>(option, PagookVisiDaoUpdate.class);
		
		select.addPostAction(enforceIsRefreshedOn);
		enforceIsRefreshedOn.addPostAction(update);
		
		actions.add(select);		
		return actions;
	}
}
