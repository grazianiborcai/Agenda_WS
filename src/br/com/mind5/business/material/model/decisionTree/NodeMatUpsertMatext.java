package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatMatextUpsert;
import br.com.mind5.business.material.model.action.StdMatEnforceMatextKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatUpsertMatext extends DeciTreeTemplateWrite<MatInfo> {
	
	public NodeMatUpsertMatext(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> enforceMatextKey = new StdMatEnforceMatextKey(option);
		ActionLazy<MatInfo> upsertMatext = new LazyMatMatextUpsert(option.conn, option.schemaName);
		
		enforceMatextKey.addPostAction(upsertMatext);

		actions.add(enforceMatextKey);
		return actions;
	}
}
