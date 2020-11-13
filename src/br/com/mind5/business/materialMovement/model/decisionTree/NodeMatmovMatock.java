package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovDaoUpdate;
import br.com.mind5.business.materialMovement.model.action.StdMatmovMatockUpsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatmovMatock extends DeciTreeTemplateWriteV2<MatmovInfo> {
	
	public NodeMatmovMatock(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelCheckerV1<MatmovInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatmovInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStdV2<MatmovInfo>> actions = new ArrayList<>();

		ActionStdV2<MatmovInfo> upsertStock = new StdMatmovMatockUpsert(option);
		ActionLazy<MatmovInfo> update = new LazyMatmovDaoUpdate(option.conn, option.schemaName);
		
		upsertStock.addPostAction(update);
		
		actions.add(upsertStock);	
		return actions;
	}
}
