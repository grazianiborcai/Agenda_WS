package br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.action.StdSytotauhSuccess;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckAuthOwner;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSytotauhSelectL3 extends DeciTreeTemplateWriteV2<SytotauhInfo> {
	
	public NodeSytotauhSelectL3(DeciTreeOption<SytotauhInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SytotauhInfo> buildCheckerHook(DeciTreeOption<SytotauhInfo> option) {
		List<ModelCheckerV1<SytotauhInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SytotauhInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;			
		checker = new SytotauhCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SytotauhInfo>> buildActionsOnPassedHook(DeciTreeOption<SytotauhInfo> option) {
		List<ActionStdV1<SytotauhInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SytotauhInfo> success = new StdSytotauhSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SytotauhInfo>> buildActionsOnFailedHook(DeciTreeOption<SytotauhInfo> option) {
		List<ActionStdV1<SytotauhInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SytotauhInfo> nodeL4 = new NodeSytotauhSelectL4(option).toAction();
		
		actions.add(nodeL4);
		return actions;
	}
}
