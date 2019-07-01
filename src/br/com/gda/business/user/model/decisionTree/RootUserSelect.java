package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserMergeAddress;
import br.com.gda.business.user.model.action.LazyUserMergeAuthGrRole;
import br.com.gda.business.user.model.action.LazyUserMergeCuspar;
import br.com.gda.business.user.model.action.LazyUserMergePerson;
import br.com.gda.business.user.model.action.LazyUserMergePersonCus;
import br.com.gda.business.user.model.action.LazyUserMergePhone;
import br.com.gda.business.user.model.action.StdUserMergeToSelect;
import br.com.gda.business.user.model.checker.UserCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootUserSelect extends DeciTreeReadTemplate<UserInfo> {
	
	public RootUserSelect(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		
		checker = new UserCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> select = new StdUserMergeToSelect(option);
		ActionLazy<UserInfo> mergePerson = new LazyUserMergePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAddress = new LazyUserMergeAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergePhone = new LazyUserMergePhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergePersonCus = new LazyUserMergePersonCus(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAuthGrRole = new LazyUserMergeAuthGrRole(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeCuspar = new LazyUserMergeCuspar(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergePersonCus);
		mergePersonCus.addPostAction(mergeAuthGrRole);
		mergeAuthGrRole.addPostAction(mergeCuspar);
		
		actions.add(select);
		return actions;
	}
}
