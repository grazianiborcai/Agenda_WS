package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceCreatedBy;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceCreatedOn;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceLChangedBy;
import br.com.mind5.business.owner.model.action.LazyOwnerInsert;
import br.com.mind5.business.owner.model.action.LazyOwnerInsertUserDaemon;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceLChanged;
import br.com.mind5.business.owner.model.checker.OwnerCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOwnerInsert extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public NodeOwnerInsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;

		checker = new OwnerCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerInfo> enforceLChanged = new StdOwnerEnforceLChanged(option);
		ActionLazyV1<OwnerInfo> enforceCreatedOn = new LazyOwnerEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> insertOwner = new LazyOwnerInsert(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> insertDaemon = new LazyOwnerInsertUserDaemon(option.conn, option.schemaName);	
		ActionLazyV1<OwnerInfo> enforceLChangedBy = new LazyOwnerEnforceLChangedBy(option.conn, option.schemaName);	
		ActionLazyV1<OwnerInfo> enforceCreatedBy = new LazyOwnerEnforceCreatedBy(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertOwner);
		insertOwner.addPostAction(insertDaemon);
		insertDaemon.addPostAction(enforceLChangedBy);	
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
