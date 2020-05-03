package br.com.mind5.business.orderItemSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.action.StdOrdemrapMergeEmplis;
import br.com.mind5.business.orderItemSnapshot.model.action.StdOrdemrapSuccess;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckHasEmp;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrdemrapEmp extends DeciTreeTemplateWriteV2<OrdemrapInfo> {
	
	public NodeOrdemrapEmp(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdemrapInfo> buildCheckerHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ModelCheckerV1<OrdemrapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdemrapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdemrapCheckHasEmp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdemrapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStdV1<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrdemrapInfo> mergeEmplis = new StdOrdemrapMergeEmplis(option);
		
		actions.add(mergeEmplis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<OrdemrapInfo>> buildActionsOnFailedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStdV1<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrdemrapInfo> success = new StdOrdemrapSuccess(option);
		
		actions.add(success);
		return actions;
	}	
}
