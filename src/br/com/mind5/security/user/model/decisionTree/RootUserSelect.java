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
import br.com.mind5.security.user.model.action.LazyUserMergePerson;
import br.com.mind5.security.user.model.action.LazyUserMergePhone;
import br.com.mind5.security.user.model.action.StdUserMergeToSelect;
import br.com.mind5.security.user.model.checker.UserCheckRead;

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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> select = new StdUserMergeToSelect(option);
		ActionLazy<UserInfo> mergePerson = new LazyUserMergePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAddress = new LazyUserMergeAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergePhone = new LazyUserMergePhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAuthGrRole = new LazyUserMergeAuthGrRole(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeCuspar = new LazyUserMergeCuspar(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeAuthGrRole);
		mergeAuthGrRole.addPostAction(mergeCuspar);
		
		actions.add(select);
		return actions;
	}
}
