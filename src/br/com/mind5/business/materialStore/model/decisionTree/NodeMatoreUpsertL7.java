package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreEnforceLChanged;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeUsername;
import br.com.mind5.business.materialStore.model.action.LazyMatoreNodeSnapshot;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootSelect;
import br.com.mind5.business.materialStore.model.action.StdMatoreMergeToUpdate;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatoreUpsertL7 extends DeciTreeTemplateWriteV2<MatoreInfo> {
	
	public NodeMatoreUpsertL7(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelCheckerV1<MatoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoreInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatoreInfo> mergeToUpdate = new StdMatoreMergeToUpdate(option);
		ActionLazyV1<MatoreInfo> enforceLChanged = new LazyMatoreEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> snapshot = new LazyMatoreNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> select = new LazyMatoreRootSelect(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(snapshot);
		snapshot.addPostAction(select);

		actions.add(mergeToUpdate);

		return actions;
	}
}
