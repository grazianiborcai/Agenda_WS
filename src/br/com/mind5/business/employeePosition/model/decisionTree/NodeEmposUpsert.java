package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposEnforceCreatedBy;
import br.com.mind5.business.employeePosition.model.action.LazyEmposEnforceCreatedOn;
import br.com.mind5.business.employeePosition.model.action.LazyEmposDaoInsert;
import br.com.mind5.business.employeePosition.model.action.LazyEmposMergeUsername;
import br.com.mind5.business.employeePosition.model.action.LazyEmposDaoUpdate;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceLChanged;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmposUpsert extends DeciTreeTemplateWrite<EmposInfo> {
	
	public NodeEmposUpsert(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmposCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> enforceLChanged = new StdEmposEnforceLChanged(option);
		ActionLazy<EmposInfo> enforceLChangedBy = new LazyEmposMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmposInfo> enforceCreatedBy = new LazyEmposEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<EmposInfo> enforceCreatedOn = new LazyEmposEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<EmposInfo> insert = new LazyEmposDaoInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnFailedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> enforceLChanged = new StdEmposEnforceLChanged(option);
		ActionLazy<EmposInfo> enforceLChangedBy = new LazyEmposMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmposInfo> enforceCreatedBy = new LazyEmposEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<EmposInfo> enforceCreatedOn = new LazyEmposEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<EmposInfo> update = new LazyEmposDaoUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(update);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
