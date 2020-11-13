package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerDaoInsert;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceCreatedBy;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceCreatedOn;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceLChangedBy;
import br.com.mind5.business.owner.model.action.LazyOwnerUserInsertAnonymous;
import br.com.mind5.business.owner.model.action.LazyOwnerUserInsertDaemon;
import br.com.mind5.business.owner.model.action.LazyOwnerSysonfigInsert;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOwnerInsert extends DeciTreeTemplateWriteV2<OwnerInfo> {
	
	public NodeOwnerInsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelCheckerV1<OwnerInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnerInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerInfo> enforceLChanged = new StdOwnerEnforceLChanged(option);
		ActionLazy<OwnerInfo> enforceCreatedOn = new LazyOwnerEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertOwner = new LazyOwnerDaoInsert(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertDaemon = new LazyOwnerUserInsertDaemon(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> insertAnonymous = new LazyOwnerUserInsertAnonymous(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertSysonfig = new LazyOwnerSysonfigInsert(option.conn, option.schemaName);		
		ActionLazy<OwnerInfo> enforceLChangedBy = new LazyOwnerEnforceLChangedBy(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> enforceCreatedBy = new LazyOwnerEnforceCreatedBy(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertOwner);
		insertOwner.addPostAction(insertDaemon);
		insertDaemon.addPostAction(insertAnonymous);
		insertAnonymous.addPostAction(insertSysonfig);
		insertSysonfig.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
