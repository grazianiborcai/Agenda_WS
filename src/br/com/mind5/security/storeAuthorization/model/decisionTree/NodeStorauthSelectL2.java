package br.com.mind5.security.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.action.StdStorauthMergeToSelect;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckDummy;

public final class NodeStorauthSelectL2 extends DeciTreeTemplateWriteV1<StorauthInfo> {
	
	public NodeStorauthSelectL2(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorauthInfo> buildCheckerHook(DeciTreeOption<StorauthInfo> option) {
		List<ModelCheckerV1<StorauthInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorauthInfo> checker;
		
		checker = new StorauthCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStdV1<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorauthInfo> select = new StdStorauthMergeToSelect(option);
			
		actions.add(select);		
		return actions;
	}
}
