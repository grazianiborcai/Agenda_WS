package br.com.mind5.security.userAuthentication.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.model.action.LazyUauthMergeUselis;
import br.com.mind5.security.userAuthentication.model.action.StdUauthAuthenticateUpswd;
import br.com.mind5.security.userAuthentication.model.checker.UauthCheckRead;

public final class RootUauthUpswd extends DeciTreeTemplateWriteV2<UauthInfo> {
	
	public RootUauthUpswd(DeciTreeOption<UauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UauthInfo> buildCheckerHook(DeciTreeOption<UauthInfo> option) {
		List<ModelCheckerV1<UauthInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UauthInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UauthCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UauthInfo>> buildActionsOnPassedHook(DeciTreeOption<UauthInfo> option) {
		List<ActionStdV1<UauthInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UauthInfo> authenticateUpswd = new StdUauthAuthenticateUpswd(option);
		ActionLazyV1<UauthInfo> mergeUselis = new LazyUauthMergeUselis(option.conn, option.schemaName);
		
		authenticateUpswd.addPostAction(mergeUselis);
		
		actions.add(authenticateUpswd);		
		return actions;
	}
}
