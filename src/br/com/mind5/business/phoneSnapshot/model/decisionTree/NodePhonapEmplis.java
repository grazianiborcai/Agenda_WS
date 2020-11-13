package br.com.mind5.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.action.StdPhonapMergeEmplis;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckHasEmployee;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodePhonapEmplis extends DeciTreeTemplateReadV2<PhonapInfo> {
	
	public NodePhonapEmplis(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PhonapInfo> buildCheckerHook(DeciTreeOption<PhonapInfo> option) {
		List<ModelCheckerV1<PhonapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PhonapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonapCheckHasEmployee(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PhonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStdV2<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<PhonapInfo> mergeEmplis = new StdPhonapMergeEmplis(option);	
		
		actions.add(mergeEmplis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<PhonapInfo>> buildActionsOnFailedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStdV2<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<PhonapInfo> nodeCuslis = new NodePhonapCuslis(option).toAction();	
		
		actions.add(nodeCuslis);			
		return actions;
	}
}
