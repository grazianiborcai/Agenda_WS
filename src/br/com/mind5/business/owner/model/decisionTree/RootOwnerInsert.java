package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceCreatedBy;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceCreatedOn;
import br.com.mind5.business.owner.model.action.LazyOwnerEnforceLChangedBy;
import br.com.mind5.business.owner.model.action.LazyOwnerInsert;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeInsertComp;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeInsertPerson;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeInsertUser;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeSnapshot;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeUpsertAddress;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeUpsertPhone;
import br.com.mind5.business.owner.model.action.LazyOwnerRootSelect;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceLChanged;
import br.com.mind5.business.owner.model.checker.OwnerCheckInsert;
import br.com.mind5.business.owner.model.checker.OwnerCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOwnerInsert extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public RootOwnerInsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnerCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceLChanged = new StdOwnerEnforceLChanged(option);
		ActionLazy<OwnerInfo> enforceCreatedOn = new LazyOwnerEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertOwner = new LazyOwnerInsert(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertUser = new LazyOwnerNodeInsertUser(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> enforceLChangedBy = new LazyOwnerEnforceLChangedBy(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> enforceCreatedBy = new LazyOwnerEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertPerson = new LazyOwnerNodeInsertPerson(option.conn, option.schemaName);			
		ActionLazy<OwnerInfo> insertComp = new LazyOwnerNodeInsertComp(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> snapshot = new LazyOwnerNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> select = new LazyOwnerRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertOwner);
		insertOwner.addPostAction(insertUser);
		insertUser.addPostAction(enforceLChangedBy);	
		enforceLChangedBy.addPostAction(enforceCreatedBy);	
		enforceCreatedBy.addPostAction(insertPerson);	
		insertPerson.addPostAction(insertComp);		
		insertComp.addPostAction(snapshot);	
		snapshot.addPostAction(upsertAddress);		
		snapshot.addPostAction(upsertPhone);			
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
