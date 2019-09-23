package br.com.gda.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.model.action.StdPhonapMergeUselis;
import br.com.gda.business.phoneSnapshot.model.checker.PhonapCheckHasUser;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

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
	
	
	
	@Override protected List<ActionStd<PhonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStd<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonapInfo> mergeUselis = new StdPhonapMergeUselis(option);	
		
		actions.add(mergeUselis);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PhonapInfo>> buildActionsOnFailedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStd<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonapInfo> nodeEmp = new NodePhonapEmplis(option).toAction();	
		
		actions.add(nodeEmp);			
		return actions;
	}
}
