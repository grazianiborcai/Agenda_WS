package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdRootInsertSilent;
import br.com.mind5.security.userPassword.model.action.LazyUpswdSuccess;
import br.com.mind5.security.userPassword.model.action.StdUpswdEnforcePasswordAnonymous;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckWriteAnonymous;

public final class RootUpswdInsertAnonymous extends DeciTreeTemplateWriteV2<UpswdInfo> {
	
	public RootUpswdInsertAnonymous(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UpswdInfo> buildCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelCheckerV1<UpswdInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UpswdInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UpswdCheckWriteAnonymous(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStdV1<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UpswdInfo> enforcePassword = new StdUpswdEnforcePasswordAnonymous(option);
		ActionLazy<UpswdInfo> insert = new LazyUpswdRootInsertSilent(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> success = new LazyUpswdSuccess(option.conn, option.schemaName);
		
		enforcePassword.addPostAction(insert);
		insert.addPostAction(success);
		
		actions.add(enforcePassword);	
		return actions;
	}
}
