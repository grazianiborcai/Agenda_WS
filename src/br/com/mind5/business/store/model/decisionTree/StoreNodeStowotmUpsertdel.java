package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiEnforceStowotmKey;
import br.com.mind5.business.store.model.action.StoreVisiStowotmUpsertdel;
import br.com.mind5.business.store.model.checker.StoreCheckHasStowotm;
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

public final class StoreNodeStowotmUpsertdel extends DeciTreeTemplateWrite<StoreInfo> {
	
	public StoreNodeStowotmUpsertdel(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckHasStowotm(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> enforceStowotmKey = new ActionStdCommom<StoreInfo>(option, StoreVisiEnforceStowotmKey.class);
		ActionLazy<StoreInfo> upsertdelStowotm = new  ActionLazyCommom<StoreInfo>(option, StoreVisiStowotmUpsertdel.class);	
		
		enforceStowotmKey.addPostAction(upsertdelStowotm);
		
		actions.add(enforceStowotmKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnFailedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> sucess = new ActionStdSuccessCommom<StoreInfo>(option);		
		
		actions.add(sucess);		
		return actions;
	}
}
