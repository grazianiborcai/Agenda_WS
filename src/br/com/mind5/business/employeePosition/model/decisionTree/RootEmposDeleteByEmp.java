package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposRootDelete;
import br.com.mind5.business.employeePosition.model.action.StdEmposMergeEmposarch;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckDeleteByEmp;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmposDeleteByEmp extends DeciTreeTemplateWriteV2<EmposInfo> {
	
	public RootEmposDeleteByEmp(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelCheckerV1<EmposInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmposInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmposCheckDeleteByEmp(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> mergeEmposarch = new StdEmposMergeEmposarch(option);
		ActionLazyV1<EmposInfo> delete = new LazyEmposRootDelete(option.conn, option.schemaName);
		
		mergeEmposarch.addPostAction(delete);
		
		actions.add(mergeEmposarch);
		return actions;
	}
}
