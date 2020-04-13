package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposEnforceCreatedBy;
import br.com.mind5.business.employeePosition.model.action.LazyEmposEnforceCreatedOn;
import br.com.mind5.business.employeePosition.model.action.LazyEmposInsert;
import br.com.mind5.business.employeePosition.model.action.LazyEmposMergeUsername;
import br.com.mind5.business.employeePosition.model.action.LazyEmposUpdate;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceLChanged;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckSoftDelete;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class NodeEmposUpsert extends DeciTreeTemplateWriteV1<EmposInfo> {
	
	public NodeEmposUpsert(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelCheckerV1<EmposInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmposInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmposCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> enforceLChanged = new StdEmposEnforceLChanged(option);
		ActionLazyV1<EmposInfo> enforceLChangedBy = new LazyEmposMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> enforceCreatedBy = new LazyEmposEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> enforceCreatedOn = new LazyEmposEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> insert = new LazyEmposInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnFailedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> enforceLChanged = new StdEmposEnforceLChanged(option);
		ActionLazyV1<EmposInfo> enforceLChangedBy = new LazyEmposMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> enforceCreatedBy = new LazyEmposEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> enforceCreatedOn = new LazyEmposEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> update = new LazyEmposUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(update);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
