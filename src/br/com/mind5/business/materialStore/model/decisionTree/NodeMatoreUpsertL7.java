package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreEnforceLChanged;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeUsername;
import br.com.mind5.business.materialStore.model.action.LazyMatoreNodeSnapshot;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootSelect;
import br.com.mind5.business.materialStore.model.action.StdMatoreMergeToUpdate;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatoreUpsertL7 extends DeciTreeWriteTemplate<MatoreInfo> {
	
	public NodeMatoreUpsertL7(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildDecisionCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
	
		checker = new MatoreCheckDummy();
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
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
