package br.com.mind5.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.action.StdPhonapMergeUselis;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckHasUser;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class NodePhonapUselis extends DeciTreeReadTemplate<PhonapInfo> {
	
	public NodePhonapUselis(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonapInfo> buildDecisionCheckerHook(DeciTreeOption<PhonapInfo> option) {
		List<ModelChecker<PhonapInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonapCheckHasUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
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
