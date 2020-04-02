package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.StdEmposDeleteEmpwotm;
import br.com.mind5.business.employeePosition.model.action.StdEmposSuccess;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckEmpwotarch;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeEmposDeleteEmpwotm extends DeciTreeWriteTemplate<EmposInfo> {
	
	public NodeEmposDeleteEmpwotm(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildDecisionCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckEmpwotarch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> deleteEmpwotm = new StdEmposDeleteEmpwotm(option);
		
		actions.add(deleteEmpwotm);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnFailedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> success = new StdEmposSuccess(option);
		
		actions.add(success);		
		return actions;
	}
}
