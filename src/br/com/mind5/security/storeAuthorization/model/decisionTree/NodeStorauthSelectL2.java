package br.com.mind5.security.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.action.StdStorauthMergeToSelect;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckDummy;

public final class NodeStorauthSelectL2 extends DeciTreeWriteTemplate<StorauthInfo> {
	
	public NodeStorauthSelectL2(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorauthInfo> buildDecisionCheckerHook(DeciTreeOption<StorauthInfo> option) {
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		
		checker = new StorauthCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStdV1<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorauthInfo> select = new StdStorauthMergeToSelect(option);
			
		actions.add(select);		
		return actions;
	}
}
