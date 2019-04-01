package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.action.StdMatDeleteMatore;
import br.com.gda.business.material.model.checker.MatCheckMatore;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatDeleteL1 extends DeciTreeWriteTemplate<MatInfo> {
	
	public NodeMatDeleteL1(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildDecisionCheckerHook(DeciTreeOption<MatInfo> option) {
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;		
		checker = new MatCheckMatore(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> nodeL2 = new NodeMatDeleteL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnFailedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> deleteMatore = new StdMatDeleteMatore(option);
		ActionStd<MatInfo> nodeL2 = new NodeMatDeleteL2(option).toAction();
		
		actions.add(deleteMatore);
		actions.add(nodeL2);
		return actions;
	}
}
