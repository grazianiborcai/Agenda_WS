package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiEnforceMatextKey;
import br.com.mind5.business.material.model.action.MatVisiMatextUpsert;
import br.com.mind5.business.material.model.checker.MatCheckHasMatext;
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

public final class MatNodeMatextUpsert extends DeciTreeTemplateWrite<MatInfo> {
	
	public MatNodeMatextUpsert(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCheckHasMatext(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> enforceMatextKey = new ActionStdCommom<MatInfo>(option, MatVisiEnforceMatextKey.class);
		ActionLazy<MatInfo> upsertMatext = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMatextUpsert.class);
		
		enforceMatextKey.addPostAction(upsertMatext);

		actions.add(enforceMatextKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnFailedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatInfo> success = new ActionStdSuccessCommom<MatInfo>(option);	
		
		actions.add(success);		
		return actions;
	}
}
