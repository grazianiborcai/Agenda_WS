package br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.action.LazySytotauhNodeAuth;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSytotauhAuth extends DeciTreeTemplateWriteV2<SytotauhInfo> {
	
	public RootSytotauhAuth(DeciTreeOption<SytotauhInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SytotauhInfo> buildCheckerHook(DeciTreeOption<SytotauhInfo> option) {
		List<ModelCheckerV1<SytotauhInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SytotauhInfo> checker;
				
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SytotauhInfo>> buildActionsOnPassedHook(DeciTreeOption<SytotauhInfo> option) {
		List<ActionStdV1<SytotauhInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SytotauhInfo> select = new RootSytotauhSelect(option).toAction();
		ActionLazyV1<SytotauhInfo> nodeAuth = new LazySytotauhNodeAuth(option.conn, option.schemaName);
		
		select.addPostAction(nodeAuth);
		
		actions.add(select);
		return actions;
	}
}
