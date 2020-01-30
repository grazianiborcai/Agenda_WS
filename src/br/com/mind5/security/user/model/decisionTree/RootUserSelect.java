package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserMergeAddress;
import br.com.mind5.security.user.model.action.LazyUserMergeAuthGrRole;
import br.com.mind5.security.user.model.action.LazyUserMergeCuspar;
import br.com.mind5.security.user.model.action.LazyUserMergeFimist;
import br.com.mind5.security.user.model.action.LazyUserMergePerson;
import br.com.mind5.security.user.model.action.LazyUserMergePhone;
import br.com.mind5.security.user.model.action.LazyUserMergeToSelect;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckRead;
import br.com.mind5.security.user.model.checker.UserCheckUsername;

public final class RootUserSelect extends DeciTreeReadTemplate<UserInfo> {
	
	public RootUserSelect(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UserCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> nodeUsername = new NodeUserUsername(option).toAction();
		ActionLazy<UserInfo> select = new LazyUserMergeToSelect(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergePerson = new LazyUserMergePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAddress = new LazyUserMergeAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergePhone = new LazyUserMergePhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAuthGrRole = new LazyUserMergeAuthGrRole(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeCuspar = new LazyUserMergeCuspar(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeFimist = new LazyUserMergeFimist(option.conn, option.schemaName);
		
		nodeUsername.addPostAction(select);
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeAuthGrRole);
		mergeAuthGrRole.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(mergeFimist);
		
		actions.add(nodeUsername);
		return actions;
	}
}
