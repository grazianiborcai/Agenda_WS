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
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

final class NodeStowotmInsert extends DeciTreeTemplateWrite<StowotmInfo> {
	
	public NodeStowotmInsert(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StowotmCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceLChanged = new StdStowotmEnforceLChanged(option);
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
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnFailedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceLChanged = new StdStowotmEnforceLChanged(option);
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
