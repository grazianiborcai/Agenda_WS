package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.OwnerVisiNodeCompInsert;
import br.com.mind5.business.owner.model.action.OwnerVisiNodePersonInsert;
import br.com.mind5.business.owner.model.action.OwnerVisiNodeSnapshot;
import br.com.mind5.business.owner.model.action.OwnerVisiNodeAddressUpsert;
import br.com.mind5.business.owner.model.action.OwnerVisiNodePhoneUpsert;
import br.com.mind5.business.owner.model.action.OwnerVisiRootSelect;
import br.com.mind5.business.owner.model.action.OwnerVisiUserInsert;
import br.com.mind5.business.owner.model.checker.OwnerCheckBusarea;
import br.com.mind5.business.owner.model.checker.OwnerCheckInsert;
import br.com.mind5.business.owner.model.checker.OwnerCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OwnerRootInsert extends DeciTreeTemplateWrite<OwnerInfo> {
	
	public OwnerRootInsert(DeciTreeOption<OwnerInfo> option) {
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerCheckBusarea(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> insertOwner = new OwnerNodeInsert(option).toAction();
		ActionLazy<OwnerInfo> insertPerson = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodePersonInsert.class);			
		ActionLazy<OwnerInfo> insertComp = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodeCompInsert.class);	
		ActionLazy<OwnerInfo> insertUser = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiUserInsert.class);	
		ActionLazy<OwnerInfo> snapshot = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodeSnapshot.class);
		ActionLazy<OwnerInfo> upsertAddress = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodeAddressUpsert.class);
		ActionLazy<OwnerInfo> upsertPhone = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiNodePhoneUpsert.class);	
		ActionLazy<OwnerInfo> select = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiRootSelect.class);	
		
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
