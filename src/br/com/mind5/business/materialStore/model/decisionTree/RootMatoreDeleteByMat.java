package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeMatorarch;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootDelete;
import br.com.mind5.business.materialStore.model.action.StdMatoreEnforceMatKey;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckDeleteByMat;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatoreDeleteByMat extends DeciTreeWriteTemplate<MatoreInfo> {
	
	public RootMatoreDeleteByMat(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildDecisionCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatoreCheckDeleteByMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatoreInfo> enforceMatKey = new StdMatoreEnforceMatKey(option);
		ActionLazyV1<MatoreInfo> mergeMatorarch = new LazyMatoreMergeMatorarch(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> delete = new LazyMatoreRootDelete(option.conn, option.schemaName);
		
		enforceMatKey.addPostAction(mergeMatorarch);
		mergeMatorarch.addPostAction(delete);
		
		actions.add(enforceMatKey);
		return actions;
	}
}
