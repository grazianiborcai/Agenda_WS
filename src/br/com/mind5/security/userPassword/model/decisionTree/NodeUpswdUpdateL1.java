package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdNodeUpdateL2;
import br.com.mind5.security.userPassword.model.action.LazyUpswdOtperasAuthenticate;
import br.com.mind5.security.userPassword.model.action.LazyUpswdSuccess;
import br.com.mind5.security.userPassword.model.action.StdUpswdMergeUsername;
import br.com.mind5.security.userPassword.model.action.StdUpswdSuccess;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckUsername;

public final class NodeUpswdUpdateL1 extends DeciTreeTemplateWriteV2<UpswdInfo> {
	
	public NodeUpswdUpdateL1(DeciTreeOption<UpswdInfo> option) {
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
		checker = new UpswdCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStdV1<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UpswdInfo> mergeUsername = new StdUpswdMergeUsername(option);
		ActionLazyV1<UpswdInfo> otperasAuthenticate = new LazyUpswdOtperasAuthenticate(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> nodeL2 = new LazyUpswdNodeUpdateL2(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> success = new LazyUpswdSuccess(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(otperasAuthenticate);
		otperasAuthenticate.addPostAction(nodeL2);
		nodeL2.addPostAction(success);
		
		actions.add(mergeUsername);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<UpswdInfo>> buildActionsOnFailedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStdV1<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UpswdInfo> success = new StdUpswdSuccess(option);

		actions.add(success);	
		return actions;
	}
}
