package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreEnforceCreatedBy;
import br.com.mind5.business.materialStore.model.action.LazyMatoreEnforceCreatedOn;
import br.com.mind5.business.materialStore.model.action.LazyMatoreInsert;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeUsername;
import br.com.mind5.business.materialStore.model.action.LazyMatoreNodeSnapshot;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootSelect;
import br.com.mind5.business.materialStore.model.action.LazyMatoreUpdate;
import br.com.mind5.business.materialStore.model.action.StdMatoreEnforceLChanged;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckSoftDelete;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatoreUpsertL8 extends DeciTreeWriteTemplate<MatoreInfo> {
	
	public NodeMatoreUpsertL8(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new MatoreCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatoreInfo> enforceLChanged = new StdMatoreEnforceLChanged(option);
		ActionLazyV1<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> enforceCreatedOn = new LazyMatoreEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazyV1<MatoreInfo> enforceCreatedBy = new LazyMatoreEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> insert = new LazyMatoreInsert(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> snapshot = new LazyMatoreNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> select = new LazyMatoreRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnFailedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatoreInfo> enforceLChanged = new StdMatoreEnforceLChanged(option);
		ActionLazyV1<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> enforceCreatedOn = new LazyMatoreEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazyV1<MatoreInfo> enforceCreatedBy = new LazyMatoreEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> update = new LazyMatoreUpdate(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> snapshot = new LazyMatoreNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> select = new LazyMatoreRootSelect(option.conn, option.schemaName);
		
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
