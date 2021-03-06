package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserDaoDelete;
import br.com.mind5.security.user.model.action.LazyUserPersonDelete;
import br.com.mind5.security.user.model.action.LazyUserUpswdDelete;
import br.com.mind5.security.user.model.action.LazyUserEnforceLChanged;
import br.com.mind5.security.user.model.action.LazyUserMergeToDelete;
import br.com.mind5.security.user.model.action.LazyUserNodeDeleteAddress;
import br.com.mind5.security.user.model.action.LazyUserNodeDeletePhone;
import br.com.mind5.security.user.model.action.LazyUserDaoUpdate;
import br.com.mind5.security.user.model.action.StdUserMergeUsername;
import br.com.mind5.security.user.model.checker.UserCheckDelete;
import br.com.mind5.security.user.model.checker.UserCheckExist;
import br.com.mind5.security.user.model.checker.UserCheckOwner;

public final class RootUserDelete extends DeciTreeTemplateWrite<UserInfo> {
	
	public RootUserDelete(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new UserCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckExist(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<UserInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> enforceLChangedBy = new StdUserMergeUsername(option);	
		ActionLazy<UserInfo> mergeToDelete = new LazyUserMergeToDelete(option.conn, option.schemaName);	
		ActionLazy<UserInfo> enforceLChanged = new LazyUserEnforceLChanged(option.conn, option.schemaName);		
		ActionLazy<UserInfo> updateUser = new LazyUserDaoUpdate(option.conn, option.schemaName);
		ActionLazy<UserInfo> deleteAddress = new LazyUserNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> deletePhone = new LazyUserNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> deleteUser = new LazyUserDaoDelete(option.conn, option.schemaName);	
		ActionLazy<UserInfo> deletePassword = new LazyUserUpswdDelete(option.conn, option.schemaName);	
		ActionLazy<UserInfo> deletePerson = new LazyUserPersonDelete(option.conn, option.schemaName);
		
		enforceLChangedBy.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(enforceLChanged);		
		enforceLChanged.addPostAction(updateUser);
		updateUser.addPostAction(deleteAddress);		
		updateUser.addPostAction(deletePhone);
		updateUser.addPostAction(deleteUser);
		updateUser.addPostAction(deletePassword);
		updateUser.addPostAction(deletePerson);
		//TODO: delete token ? Ou colocar dentro de password ? 
		//TODO: enviar email ao usuario informando que sua conta foi eliminada
		actions.add(enforceLChangedBy);
		
		return actions;
	}
}
