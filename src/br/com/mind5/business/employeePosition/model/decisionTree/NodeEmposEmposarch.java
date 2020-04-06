package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposNodeDeleteEmplate;
import br.com.mind5.business.employeePosition.model.action.LazyEmposNodeDeleteEmpwotm;
import br.com.mind5.business.employeePosition.model.action.LazyEmposUniquify;
import br.com.mind5.business.employeePosition.model.action.StdEmposSuccess;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckEmposarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmposEmposarch extends DeciTreeTemplateWrite<EmposInfo> {
	
	public NodeEmposEmposarch(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelCheckerV1<EmposInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmposInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckEmposarch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> success = new StdEmposSuccess(option);
		
		actions.add(success);
		return actions;		
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnFailedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> schedage = new NodeEmposSchedage(option).toAction();
		ActionLazyV1<EmposInfo> deleteEmplate = new LazyEmposNodeDeleteEmplate(option.conn, option.schemaName);
		ActionLazyV1<EmposInfo> deleteEmpwotm = new LazyEmposNodeDeleteEmpwotm(option.conn, option.schemaName);		
		ActionLazyV1<EmposInfo> uniquify = new LazyEmposUniquify(option.conn, option.schemaName);
		
		schedage.addPostAction(deleteEmplate);
		schedage.addPostAction(deleteEmpwotm);
		deleteEmpwotm.addPostAction(uniquify);
		
		
		actions.add(schedage);
		return actions;		
	}
}
