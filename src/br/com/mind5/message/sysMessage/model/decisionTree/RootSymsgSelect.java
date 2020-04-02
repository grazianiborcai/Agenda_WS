package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.LazySymsgNodeSelectL1;
import br.com.mind5.message.sysMessage.model.action.StdSymsgEnforceBase;
import br.com.mind5.message.sysMessage.model.checker.SymsgCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSymsgSelect extends DeciTreeWriteTemplate<SymsgInfo> {
	
	public RootSymsgSelect(DeciTreeOption<SymsgInfo> option) {
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
		checker = new SymsgCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStdV1<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<SymsgInfo> enforceBase = new StdSymsgEnforceBase(option);
		ActionLazyV1<SymsgInfo> nodeL1 = new LazySymsgNodeSelectL1(option.conn, option.schemaName);
		
		enforceBase.addPostAction(nodeL1);
		
		actions.add(enforceBase);		
		return actions;
	}
}
