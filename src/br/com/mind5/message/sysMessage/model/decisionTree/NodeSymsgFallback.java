package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.LazySymsgEnforceError;
import br.com.mind5.message.sysMessage.model.action.LazySymsgNodeSelectL1;
import br.com.mind5.message.sysMessage.model.action.StdSymsgEnforceEnglish;
import br.com.mind5.message.sysMessage.model.action.StdSymsgRestoreBase;
import br.com.mind5.message.sysMessage.model.checker.SymsgCheckNotEnglish;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSymsgFallback extends DeciTreeWriteTemplate<SymsgInfo> {
	
	public NodeSymsgFallback(DeciTreeOption<SymsgInfo> option) {
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
		checker = new SymsgCheckNotEnglish(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> enforceEnglish = new StdSymsgEnforceEnglish(option);
		ActionLazy<SymsgInfo> nodeSelect = new LazySymsgNodeSelectL1(option.conn, option.schemaName);
		
		enforceEnglish.addPostAction(nodeSelect);
		
		actions.add(enforceEnglish);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnFailedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> restoreBase = new StdSymsgRestoreBase(option);
		ActionLazy<SymsgInfo> enforceError = new LazySymsgEnforceError(option.conn, option.schemaName);
		ActionLazy<SymsgInfo> nodeSelect = new LazySymsgNodeSelectL1(option.conn, option.schemaName);
		
		restoreBase.addPostAction(enforceError);
		enforceError.addPostAction(nodeSelect);
		
		actions.add(restoreBase);		
		return actions;
	}
}
