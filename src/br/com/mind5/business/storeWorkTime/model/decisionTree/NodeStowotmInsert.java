package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmEnforceCreatedBy;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmEnforceCreatedOn;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmDaoInsert;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmMergeUsername;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmRootSelect;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmDaoUpdate;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmEnforceLChanged;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

final class NodeStowotmInsert extends DeciTreeTemplateWriteV2<StowotmInfo> {
	
	public NodeStowotmInsert(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelCheckerV1<StowotmInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StowotmInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StowotmCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStdV1<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StowotmInfo> enforceLChanged = new StdStowotmEnforceLChanged(option);
		ActionLazy<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> enforceCreatedOn = new LazyStowotmEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> enforceCreatedBy = new LazyStowotmEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> insert = new LazyStowotmDaoInsert(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StowotmInfo>> buildActionsOnFailedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStdV1<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StowotmInfo> enforceLChanged = new StdStowotmEnforceLChanged(option);
		ActionLazy<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> enforceCreatedOn = new LazyStowotmEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> enforceCreatedBy = new LazyStowotmEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> update = new LazyStowotmDaoUpdate(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
}
