package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeInsertComp;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeInsertPerson;
import br.com.mind5.business.owner.model.action.LazyOwnerInsertUser;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeSnapshot;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeUpsertAddress;
import br.com.mind5.business.owner.model.action.LazyOwnerNodeUpsertPhone;
import br.com.mind5.business.owner.model.action.LazyOwnerRootSelect;
import br.com.mind5.business.owner.model.checker.OwnerCheckInsert;
import br.com.mind5.business.owner.model.checker.OwnerCheckLangu;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOwnerInsert extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public RootOwnerInsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
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
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerInfo> insertOwner = new NodeOwnerInsert(option).toAction();
		ActionLazyV1<OwnerInfo> insertPerson = new LazyOwnerNodeInsertPerson(option.conn, option.schemaName);			
		ActionLazyV1<OwnerInfo> insertComp = new LazyOwnerNodeInsertComp(option.conn, option.schemaName);	
		ActionLazyV1<OwnerInfo> insertUser = new LazyOwnerInsertUser(option.conn, option.schemaName);	
		ActionLazyV1<OwnerInfo> snapshot = new LazyOwnerNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);	
		ActionLazyV1<OwnerInfo> select = new LazyOwnerRootSelect(option.conn, option.schemaName);	
		
		insertOwner.addPostAction(insertPerson);	
		insertPerson.addPostAction(insertComp);		
		insertComp.addPostAction(insertUser);	
		insertUser.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);		
		snapshot.addPostAction(upsertPhone);			
		snapshot.addPostAction(select);
		
		actions.add(insertOwner);	
		return actions;
	}
}
