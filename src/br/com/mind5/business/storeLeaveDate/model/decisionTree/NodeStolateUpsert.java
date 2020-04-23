package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateDaoInsert;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateDaoUpdate;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStolateUpsert extends DeciTreeTemplateWriteV2<StolateInfo> {
	
	public NodeStolateUpsert(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StolateInfo> buildCheckerHook(DeciTreeOption<StolateInfo> option) {
		List<ModelCheckerV1<StolateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StolateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StolateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStdV1<StolateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StolateInfo> insert = new StdStolateDaoInsert(option);
		
		actions.add(insert);				
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StolateInfo>> buildActionsOnFailedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStdV1<StolateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StolateInfo> update = new StdStolateDaoUpdate(option);
		
		actions.add(update);				
		return actions;
	}
}
