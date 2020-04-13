package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeMatorarch;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootDelete;
import br.com.mind5.business.materialStore.model.action.StdMatoreEnforceStoreKey;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckDeleteByStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootMatoreDeleteByStore extends DeciTreeTemplateWriteV1<MatoreInfo> {
	
	public RootMatoreDeleteByStore(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelCheckerV1<MatoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatoreCheckDeleteByStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatoreInfo> enforceStoreKey = new StdMatoreEnforceStoreKey(option);
		ActionLazyV1<MatoreInfo> mergeMatorarch = new LazyMatoreMergeMatorarch(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> delete = new LazyMatoreRootDelete(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(mergeMatorarch);
		mergeMatorarch.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
