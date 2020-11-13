package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateDaoInsert;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateDaoUpdate;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmplateInsert extends DeciTreeTemplateWriteV2<EmplateInfo> {
	
	public NodeEmplateInsert(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmplateInfo> buildCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelCheckerV1<EmplateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmplateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmplateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStdV2<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmplateInfo> insert = new StdEmplateDaoInsert(option);		
		actions.add(insert);				
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<EmplateInfo>> buildActionsOnFailedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStdV2<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmplateInfo> update = new StdEmplateDaoUpdate(option);		
		actions.add(update);	
		
		return actions;
	}
}
