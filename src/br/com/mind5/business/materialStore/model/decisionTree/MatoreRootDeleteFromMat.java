package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.MatoreVisiRootDelete;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceMatKey;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeMatorarch;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckDeleteFromMat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoreRootDeleteFromMat extends DeciTreeTemplateWrite<MatoreInfo> {
	
	public MatoreRootDeleteFromMat(DeciTreeOption<MatoreInfo> option) {
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
		checker = new MatoreCheckDeleteFromMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatoreInfo> enforceMatKey = new ActionStdCommom<MatoreInfo>(option, MatoreVisiEnforceMatKey.class);
		ActionLazy<MatoreInfo> mergeMatorarch = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiMergeMatorarch.class);
		ActionLazy<MatoreInfo> delete = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiRootDelete.class);
		
		enforceMatKey.addPostAction(mergeMatorarch);
		mergeMatorarch.addPostAction(delete);
		
		actions.add(enforceMatKey);
		return actions;
	}
}
