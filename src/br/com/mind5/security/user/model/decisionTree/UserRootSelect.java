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
import br.com.mind5.security.user.model.action.UserVisiNodePerson;
import br.com.mind5.security.user.model.action.UserVisiMergeAddress;
import br.com.mind5.security.user.model.action.UserVisiMergeAuthgrole;
import br.com.mind5.security.user.model.action.UserVisiMergeCuspar;
import br.com.mind5.security.user.model.action.UserVisiMergeFimist;
import br.com.mind5.security.user.model.action.UserVisiMergePhone;
import br.com.mind5.security.user.model.action.UserVisiMergeToSelect;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckRead;

public final class UserRootSelect extends DeciTreeTemplateWrite<UserInfo> {
	
	public UserRootSelect(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UserCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> mergeToSelect = new ActionStdCommom<UserInfo>(option, UserVisiMergeToSelect.class);
		ActionLazy<UserInfo> mergePerson = new ActionLazyCommom<UserInfo>(option, UserVisiNodePerson.class);
		ActionLazy<UserInfo> mergeAddress = new ActionLazyCommom<UserInfo>(option, UserVisiMergeAddress.class);
		ActionLazy<UserInfo> mergePhone = new ActionLazyCommom<UserInfo>(option, UserVisiMergePhone.class);
		ActionLazy<UserInfo> mergeAuthgrole = new ActionLazyCommom<UserInfo>(option, UserVisiMergeAuthgrole.class);
		ActionLazy<UserInfo> mergeCuspar = new ActionLazyCommom<UserInfo>(option, UserVisiMergeCuspar.class);
		ActionLazy<UserInfo> mergeFimist = new ActionLazyCommom<UserInfo>(option, UserVisiMergeFimist.class);
		
		mergeToSelect.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeAuthgrole);
		mergeAuthgrole.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(mergeFimist);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
