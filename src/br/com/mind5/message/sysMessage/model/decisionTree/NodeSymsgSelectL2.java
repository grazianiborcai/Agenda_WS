package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.SymsgSymsgSuccess;
import br.com.mind5.message.sysMessage.model.checker.SymsgCheckNotFound;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSymsgSelectL2 extends DeciTreeTemplateWriteV2<SymsgInfo> {
	
	public NodeSymsgSelectL2(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SymsgInfo> buildCheckerHook(DeciTreeOption<SymsgInfo> option) {	
		List<ModelCheckerV1<SymsgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SymsgInfo> checker;	
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SymsgCheckNotFound(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStdV1<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<SymsgInfo> nodeFallback = new NodeSymsgFallback(option).toAction();
		
		actions.add(nodeFallback);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SymsgInfo>> buildActionsOnFailedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStdV1<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<SymsgInfo> success = new SymsgSymsgSuccess(option);
		
		actions.add(success);		
		return actions;
	}
}
