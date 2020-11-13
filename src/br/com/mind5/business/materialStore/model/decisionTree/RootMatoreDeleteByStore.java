package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeMatorarch;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootDelete;
import br.com.mind5.business.materialStore.model.action.StdMatoreEnforceStoreKey;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckDeleteByStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootMatoreDeleteByStore extends DeciTreeTemplateWrite<MatoreInfo> {
	
	public RootMatoreDeleteByStore(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatoreCheckDeleteByStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatoreInfo> enforceStoreKey = new StdMatoreEnforceStoreKey(option);
		ActionLazy<MatoreInfo> mergeMatorarch = new LazyMatoreMergeMatorarch(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> delete = new LazyMatoreRootDelete(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(mergeMatorarch);
		mergeMatorarch.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
