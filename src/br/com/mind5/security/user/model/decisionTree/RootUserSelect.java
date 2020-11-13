package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserMergeAddress;
import br.com.mind5.security.user.model.action.LazyUserMergeAuthgrole;
import br.com.mind5.security.user.model.action.LazyUserMergeCuspar;
import br.com.mind5.security.user.model.action.LazyUserMergeFimist;
import br.com.mind5.security.user.model.action.LazyUserNodePerson;
import br.com.mind5.security.user.model.action.LazyUserMergePhone;
import br.com.mind5.security.user.model.action.StdUserMergeToSelect;
import br.com.mind5.security.user.model.checker.UserCheckOwner;
import br.com.mind5.security.user.model.checker.UserCheckRead;

public final class RootUserSelect extends DeciTreeTemplateWriteV2<UserInfo> {
	
	public RootUserSelect(DeciTreeOption<UserInfo> option) {
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
		checker = new UserCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UserCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UserInfo> mergeToSelect = new StdUserMergeToSelect(option);
		ActionLazy<UserInfo> mergePerson = new LazyUserNodePerson(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAddress = new LazyUserMergeAddress(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergePhone = new LazyUserMergePhone(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeAuthgrole = new LazyUserMergeAuthgrole(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeCuspar = new LazyUserMergeCuspar(option.conn, option.schemaName);
		ActionLazy<UserInfo> mergeFimist = new LazyUserMergeFimist(option.conn, option.schemaName);
		
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
