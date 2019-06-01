package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserEnforceLChanged;
import br.com.gda.business.user.model.action.LazyUserInsertUserap;
import br.com.gda.business.user.model.action.LazyUserMergeUsername;
import br.com.gda.business.user.model.action.LazyUserNodeUpdatePerson;
import br.com.gda.business.user.model.action.LazyUserNodeUpsertAddress;
import br.com.gda.business.user.model.action.LazyUserNodeUpsertPhone;
import br.com.gda.business.user.model.action.LazyUserUpdate;
import br.com.gda.business.user.model.action.StdUserMergeToUpdate;
import br.com.gda.business.user.model.checker.UserCheckAuthGroup;
import br.com.gda.business.user.model.checker.UserCheckExist;
import br.com.gda.business.user.model.checker.UserCheckOwner;
import br.com.gda.business.user.model.checker.UserCheckUpdate;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootUserUpdate extends DeciTreeWriteTemplate<UserInfo> {
	
	public RootUserUpdate(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new UserCheckUpdate();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckAuthGroup(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		//TODO: permitir alterar codAuthGroup por aqui ou criar um endpoint para isso ?
		ActionStd<UserInfo> mergeToUpdate = new StdUserMergeToUpdate(option);
		ActionLazy<UserInfo> enforceLChanged = new LazyUserEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<UserInfo> enforceLChangedBy = new LazyUserMergeUsername(option.conn, option.schemaName);		
		ActionLazy<UserInfo> updateUser = new LazyUserUpdate(option.conn, option.schemaName);
		ActionLazy<UserInfo> updatePerson = new LazyUserNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertSnapshot = new LazyUserInsertUserap(option.conn, option.schemaName);		
		ActionLazy<UserInfo> upsertAddress = new LazyUserNodeUpsertAddress(option.conn, option.schemaName);	
		ActionLazy<UserInfo> upsertPhone = new LazyUserNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<UserInfo> select = new RootUserSelect(option).toAction();		
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);		
		enforceLChangedBy.addPostAction(updatePerson);		
		updatePerson.addPostAction(insertSnapshot);
		insertSnapshot.addPostAction(updateUser);		
		updateUser.addPostAction(upsertAddress);		
		updateUser.addPostAction(upsertPhone);
		
		actions.add(mergeToUpdate);
		actions.add(select);	
		return actions;
	}
}
