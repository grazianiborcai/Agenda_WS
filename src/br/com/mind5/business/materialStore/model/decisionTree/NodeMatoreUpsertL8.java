package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreEnforceCreatedBy;
import br.com.mind5.business.materialStore.model.action.LazyMatoreEnforceCreatedOn;
import br.com.mind5.business.materialStore.model.action.LazyMatoreDaoInsert;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeUsername;
import br.com.mind5.business.materialStore.model.action.LazyMatoreNodeSnapshot;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootSelect;
import br.com.mind5.business.materialStore.model.action.LazyMatoreDaoUpdate;
import br.com.mind5.business.materialStore.model.action.StdMatoreEnforceLChanged;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatoreUpsertL8 extends DeciTreeTemplateWriteV2<MatoreInfo> {
	
	public NodeMatoreUpsertL8(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelCheckerV1<MatoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new MatoreCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV2<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatoreInfo> enforceLChanged = new StdMatoreEnforceLChanged(option);
		ActionLazy<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> enforceCreatedOn = new LazyMatoreEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazy<MatoreInfo> enforceCreatedBy = new LazyMatoreEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> insert = new LazyMatoreDaoInsert(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> snapshot = new LazyMatoreNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> select = new LazyMatoreRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<MatoreInfo>> buildActionsOnFailedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV2<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatoreInfo> enforceLChanged = new StdMatoreEnforceLChanged(option);
		ActionLazy<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> enforceCreatedOn = new LazyMatoreEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazy<MatoreInfo> enforceCreatedBy = new LazyMatoreEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> update = new LazyMatoreDaoUpdate(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> snapshot = new LazyMatoreNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> select = new LazyMatoreRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(update);
		update.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
