package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.SymsgSymsgSuccess;
import br.com.mind5.message.sysMessage.model.checker.SymsgCheckNotFound;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSymsgSelectL2 extends DeciTreeWriteTemplate<SymsgInfo> {
	
	public NodeSymsgSelectL2(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SymsgInfo> buildDecisionCheckerHook(DeciTreeOption<SymsgInfo> option) {	
		List<ModelChecker<SymsgInfo>> queue = new ArrayList<>();		
		ModelChecker<SymsgInfo> checker;	
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SymsgCheckNotFound(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> nodeFallback = new NodeSymsgFallback(option).toAction();
		
		actions.add(nodeFallback);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnFailedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> success = new SymsgSymsgSuccess(option);
		
		actions.add(success);		
		return actions;
	}
}