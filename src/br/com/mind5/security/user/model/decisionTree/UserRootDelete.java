package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.UserVisiNodeAddressDelete;
import br.com.mind5.security.user.model.action.UserVisiNodePhoneDelete;
import br.com.mind5.security.user.model.action.UserVisiDaoDelete;
import br.com.mind5.security.user.model.action.UserVisiDaoUpdate;
import br.com.mind5.security.user.model.action.UserVisiEnforceLChanged;
import br.com.mind5.security.user.model.action.UserVisiMergeToDelete;
import br.com.mind5.security.user.model.action.UserVisiMergeUsername;
import br.com.mind5.security.user.model.action.UserVisiPersonDelete;
import br.com.mind5.security.user.model.action.UserVisiUpswdDelete;
import br.com.mind5.security.user.model.checker.UserCheckDelete;
import br.com.mind5.security.user.model.checker.UserCheckExist;
import br.com.mind5.security.user.model.checker.UserCheckOwner;

public final class UserRootDelete extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserRootDelete(DeciTreeOption<UserInfo> option) {
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
		
		ActionStd<UserInfo> enforceLChangedBy = new ActionStdCommom<UserInfo>(option, UserVisiMergeUsername.class);	
		ActionLazy<UserInfo> mergeToDelete = new ActionLazyCommom<UserInfo>(option, UserVisiMergeToDelete.class);	
		ActionLazy<UserInfo> enforceLChanged = new ActionLazyCommom<UserInfo>(option, UserVisiEnforceLChanged.class);		
		ActionLazy<UserInfo> updateUser = new ActionLazyCommom<UserInfo>(option, UserVisiDaoUpdate.class);
		ActionLazy<UserInfo> deleteAddress = new ActionLazyCommom<UserInfo>(option, UserVisiNodeAddressDelete.class);
		ActionLazy<UserInfo> deletePhone = new ActionLazyCommom<UserInfo>(option, UserVisiNodePhoneDelete.class);
		ActionLazy<UserInfo> deleteUser = new ActionLazyCommom<UserInfo>(option, UserVisiDaoDelete.class);	
		ActionLazy<UserInfo> deletePassword = new ActionLazyCommom<UserInfo>(option, UserVisiUpswdDelete.class);	
		ActionLazy<UserInfo> deletePerson = new ActionLazyCommom<UserInfo>(option, UserVisiPersonDelete.class);
		
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
