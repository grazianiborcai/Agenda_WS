package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatDaoUpdate;
import br.com.mind5.business.material.model.action.StdMatMatsnapInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatSnapshot extends DeciTreeTemplateWriteV2<MatInfo> {
	
	public NodeMatSnapshot(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelCheckerV1<MatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV1<MatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatInfo> insertMatsnap = new StdMatMatsnapInsert(option);
		ActionLazy<MatInfo> update = new LazyMatDaoUpdate(option.conn, option.schemaName);
		
		insertMatsnap.addPostAction(update);
		
		actions.add(insertMatsnap);
		return actions;
	}
}
