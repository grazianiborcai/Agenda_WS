package br.com.mind5.authorization.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.action.StdStorauthMergeToSelect;
import br.com.mind5.authorization.storeAuthorization.model.action.StdStorauthSuccess;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthOwner;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorauthAuthorization extends DeciTreeTemplateWriteV2<StorauthInfo> {
	
	public NodeStorauthAuthorization(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorauthInfo> buildCheckerHook(DeciTreeOption<StorauthInfo> option) {
		List<ModelCheckerV1<StorauthInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorauthInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StorauthCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStdV2<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StorauthInfo> success = new StdStorauthSuccess(option);			
		actions.add(success);		
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<StorauthInfo>> buildActionsOnFailedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStdV2<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StorauthInfo> select = new StdStorauthMergeToSelect(option);
			
		actions.add(select);		
		return actions;
	}
}
