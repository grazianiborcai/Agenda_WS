package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatUpsertMatext;
import br.com.mind5.business.material.model.action.StdMatEnforceMatextKey;
import br.com.mind5.business.material.model.checker.MatCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class NodeMatUpsertMatext extends DeciTreeTemplateWriteV1<MatInfo> {
	
	public NodeMatUpsertMatext(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelCheckerV1<MatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatInfo> checker;
		
		checker = new MatCheckDummy();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV1<MatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatInfo> enforceMatextKey = new StdMatEnforceMatextKey(option);
		ActionLazyV1<MatInfo> upsertMatext = new LazyMatUpsertMatext(option.conn, option.schemaName);
		
		enforceMatextKey.addPostAction(upsertMatext);

		actions.add(enforceMatextKey);
		return actions;
	}
}
