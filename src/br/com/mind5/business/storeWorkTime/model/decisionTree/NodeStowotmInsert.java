package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmEnforceCreatedBy;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmEnforceCreatedOn;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmInsert;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmMergeUsername;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmRootSelect;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmUpdate;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmEnforceLChanged;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckSoftDelete;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

final class NodeStowotmInsert extends DeciTreeWriteTemplate<StowotmInfo> {
	
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStdV1<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StowotmInfo> enforceLChanged = new StdStowotmEnforceLChanged(option);
		ActionLazyV1<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> enforceCreatedOn = new LazyStowotmEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> enforceCreatedBy = new LazyStowotmEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> insert = new LazyStowotmInsert(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
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
		ActionLazyV1<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> enforceCreatedOn = new LazyStowotmEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> enforceCreatedBy = new LazyStowotmEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> update = new LazyStowotmUpdate(option.conn, option.schemaName);
		ActionLazyV1<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
}
