package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserDelete;
import br.com.mind5.security.user.model.action.LazyUserDeletePerson;
import br.com.mind5.security.user.model.action.LazyUserDeleteUpswd;
import br.com.mind5.security.user.model.action.LazyUserEnforceLChanged;
import br.com.mind5.security.user.model.action.LazyUserMergeToDelete;
import br.com.mind5.security.user.model.action.LazyUserNodeDeleteAddress;
import br.com.mind5.security.user.model.action.LazyUserNodeDeletePhone;
import br.com.mind5.security.user.model.action.LazyUserUpdate;
import br.com.mind5.security.user.model.action.StdUserMergeUsername;
import br.com.mind5.security.user.model.checker.UserCheckDelete;
import br.com.mind5.security.user.model.checker.UserCheckExist;
import br.com.mind5.security.user.model.checker.UserCheckOwner;

public final class RootUserDelete extends DeciTreeTemplateWriteV1<UserInfo> {
	
	public RootUserDelete(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelCheckerV1<UserInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserInfo> checker;
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

		return new ModelCheckerHelperQueueV2<UserInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UserInfo> enforceLChangedBy = new StdUserMergeUsername(option);	
		ActionLazyV1<UserInfo> mergeToDelete = new LazyUserMergeToDelete(option.conn, option.schemaName);	
		ActionLazyV1<UserInfo> enforceLChanged = new LazyUserEnforceLChanged(option.conn, option.schemaName);		
		ActionLazyV1<UserInfo> updateUser = new LazyUserUpdate(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> deleteAddress = new LazyUserNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> deletePhone = new LazyUserNodeDeletePhone(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> deleteUser = new LazyUserDelete(option.conn, option.schemaName);	
		ActionLazyV1<UserInfo> deletePassword = new LazyUserDeleteUpswd(option.conn, option.schemaName);	
		ActionLazyV1<UserInfo> deletePerson = new LazyUserDeletePerson(option.conn, option.schemaName);
		
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
