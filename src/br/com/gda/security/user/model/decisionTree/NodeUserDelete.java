package br.com.gda.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.model.action.LazyUserDelete;
import br.com.gda.security.user.model.action.LazyUserDeletePerson;
import br.com.gda.security.user.model.action.LazyUserDeleteUpswd;
import br.com.gda.security.user.model.action.LazyUserEnforceLChanged;
import br.com.gda.security.user.model.action.LazyUserNodeDeleteAddress;
import br.com.gda.security.user.model.action.LazyUserNodeDeletePhone;
import br.com.gda.security.user.model.action.LazyUserUpdate;
import br.com.gda.security.user.model.action.StdUserMergeToDelete;
import br.com.gda.security.user.model.checker.UserCheckExist;

public final class NodeUserDelete extends DeciTreeWriteTemplate<UserInfo> {
	
	public NodeUserDelete(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UserCheckExist(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<UserInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		//TODO: permitir eliminar Owner e Store Manager ?
		ActionStd<UserInfo> mergeToDelete = new StdUserMergeToDelete(option);	
		ActionLazy<UserInfo> enforceLChanged = new LazyUserEnforceLChanged(option.conn, option.schemaName);		
		ActionLazy<UserInfo> updateUser = new LazyUserUpdate(option.conn, option.schemaName);
		ActionLazy<UserInfo> deleteAddress = new LazyUserNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> deletePhone = new LazyUserNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> deleteUser = new LazyUserDelete(option.conn, option.schemaName);	
		ActionLazy<UserInfo> deletePassword = new LazyUserDeleteUpswd(option.conn, option.schemaName);	
		ActionLazy<UserInfo> deletePerson = new LazyUserDeletePerson(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);		
		enforceLChanged.addPostAction(updateUser);
		updateUser.addPostAction(deleteAddress);		
		updateUser.addPostAction(deletePhone);
		updateUser.addPostAction(deleteUser);
		updateUser.addPostAction(deletePassword);
		updateUser.addPostAction(deletePerson);
		//TODO: delete token ? Ou colocar dentro de password ? 
		//TODO: enviar email ao usuario informando que sua conta foi eliminada
		actions.add(mergeToDelete);
		
		return actions;
	}
}
