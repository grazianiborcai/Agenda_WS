package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.StdEmposDeleteEmplevate;
import br.com.mind5.business.employeePosition.model.action.StdEmposSuccess;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckEmplarch;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeEmposDeleteEmplate extends DeciTreeWriteTemplate<EmposInfo> {
	
	public NodeEmposDeleteEmplate(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmposCheckEmplarch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> deleteEmpwotm = new StdEmposDeleteEmplevate(option);
		
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
