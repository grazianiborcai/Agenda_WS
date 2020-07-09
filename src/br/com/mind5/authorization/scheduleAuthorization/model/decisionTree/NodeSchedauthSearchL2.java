package br.com.mind5.authorization.scheduleAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.model.action.LazySchedauthMergeSotarch;
import br.com.mind5.authorization.scheduleAuthorization.model.action.LazySchedauthObfuscateUser;
import br.com.mind5.authorization.scheduleAuthorization.model.action.StdSchedauthMergeUsername;
import br.com.mind5.authorization.scheduleAuthorization.model.checker.SchedauthCheckAuthManager;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedauthSearchL2 extends DeciTreeTemplateWriteV2<SchedauthInfo> {
	
	public NodeSchedauthSearchL2(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedauthInfo> buildCheckerHook(DeciTreeOption<SchedauthInfo> option) {
		List<ModelCheckerV1<SchedauthInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedauthInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedauthCheckAuthManager(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedauthInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedauthInfo> option) {
		List<ActionStdV1<SchedauthInfo>> actions = new ArrayList<>();		

		ActionStdV1<SchedauthInfo> mergeUsername = new StdSchedauthMergeUsername(option);
		ActionLazyV1<SchedauthInfo> mergeSotarch = new LazySchedauthMergeSotarch(option.conn, option.schemaName);
		ActionLazyV1<SchedauthInfo> obfuscateUser = new LazySchedauthObfuscateUser(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(mergeSotarch);
		mergeSotarch.addPostAction(obfuscateUser);
		
		actions.add(mergeUsername);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SchedauthInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedauthInfo> option) {
		List<ActionStdV1<SchedauthInfo>> actions = new ArrayList<>();		
	
		ActionStdV1<SchedauthInfo> nodeL3 = new NodeSchedauthSearchL3(option).toAction();	
		
		actions.add(nodeL3);		
		return actions;
	}
}
