package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreDaoUpdate;
import br.com.mind5.business.materialStore.model.action.StdMatoreInsertMatorap;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatoreSnapshot extends DeciTreeTemplateWriteV2<MatoreInfo> {
	
	public NodeMatoreSnapshot(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelCheckerV1<MatoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV2<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatoreInfo> insertMatorap = new StdMatoreInsertMatorap(option);
		ActionLazy<MatoreInfo> update = new LazyMatoreDaoUpdate(option.conn, option.schemaName);
		
		insertMatorap.addPostAction(update);
		
		actions.add(insertMatorap);
		return actions;
	}
}
