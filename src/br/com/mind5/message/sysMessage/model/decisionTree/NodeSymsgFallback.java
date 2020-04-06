package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.LazySymsgEnforceError;
import br.com.mind5.message.sysMessage.model.action.LazySymsgNodeSelectL1;
import br.com.mind5.message.sysMessage.model.action.StdSymsgEnforceEnglish;
import br.com.mind5.message.sysMessage.model.action.StdSymsgRestoreBase;
import br.com.mind5.message.sysMessage.model.checker.SymsgCheckNotEnglish;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSymsgFallback extends DeciTreeTemplateWrite<SymsgInfo> {
	
	public NodeSymsgFallback(DeciTreeOption<SymsgInfo> option) {
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
		checker = new SymsgCheckNotEnglish(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStdV1<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<SymsgInfo> enforceEnglish = new StdSymsgEnforceEnglish(option);
		ActionLazyV1<SymsgInfo> nodeSelect = new LazySymsgNodeSelectL1(option.conn, option.schemaName);
		
		enforceEnglish.addPostAction(nodeSelect);
		
		actions.add(enforceEnglish);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SymsgInfo>> buildActionsOnFailedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStdV1<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<SymsgInfo> restoreBase = new StdSymsgRestoreBase(option);
		ActionLazyV1<SymsgInfo> enforceError = new LazySymsgEnforceError(option.conn, option.schemaName);
		ActionLazyV1<SymsgInfo> nodeSelect = new LazySymsgNodeSelectL1(option.conn, option.schemaName);
		
		restoreBase.addPostAction(enforceError);
		enforceError.addPostAction(nodeSelect);
		
		actions.add(restoreBase);		
		return actions;
	}
}
