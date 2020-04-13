package br.com.mind5.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.action.StdPhonapMergeUselis;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckHasUser;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class NodePhonapUselis extends DeciTreeTemplateReadV1<PhonapInfo> {
	
	public NodePhonapUselis(DeciTreeOption<PhonapInfo> option) {
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
		checker = new PhonapCheckHasUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PhonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStdV1<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PhonapInfo> mergeUselis = new StdPhonapMergeUselis(option);	
		
		actions.add(mergeUselis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<PhonapInfo>> buildActionsOnFailedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStdV1<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PhonapInfo> nodeEmp = new NodePhonapEmplis(option).toAction();	
		
		actions.add(nodeEmp);			
		return actions;
	}
}
