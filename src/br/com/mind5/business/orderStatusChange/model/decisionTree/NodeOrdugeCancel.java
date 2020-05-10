package br.com.mind5.business.orderStatusChange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.model.action.StdOrdugeEnforceCancelled;
import br.com.mind5.business.orderStatusChange.model.action.StdOrdugeEnforceRefunding;
import br.com.mind5.business.orderStatusChange.model.checker.OrdugeCheckHasPayord;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeOrdugeCancel extends DeciTreeTemplateReadV2<OrdugeInfo> {
	
	public NodeOrdugeCancel(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdugeInfo> buildCheckerHook(DeciTreeOption<OrdugeInfo> option) {
		List<ModelCheckerV1<OrdugeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdugeInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdugeCheckHasPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdugeInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdugeInfo> option) {
		List<ActionStdV1<OrdugeInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<OrdugeInfo> enforceStatus = new StdOrdugeEnforceRefunding(option);
		
		actions.add(enforceStatus);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<OrdugeInfo>> buildActionsOnFailedHook(DeciTreeOption<OrdugeInfo> option) {
		List<ActionStdV1<OrdugeInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<OrdugeInfo> enforceStatus = new StdOrdugeEnforceCancelled(option);
		
		actions.add(enforceStatus);			
		return actions;
	}
}
