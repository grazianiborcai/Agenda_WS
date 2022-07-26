package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.SymsgVisiNodeSelectL1;
import br.com.mind5.message.sysMessage.model.action.SymsgVisiEnforceEnglish;
import br.com.mind5.message.sysMessage.model.action.SymsgVisiEnforceError;
import br.com.mind5.message.sysMessage.model.action.SymsgVisiRestoreBase;
import br.com.mind5.message.sysMessage.model.checker.SymsgCheckNotEnglish;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SymsgNodeFallback extends DeciTreeTemplateWrite<SymsgInfo> {
	
	public SymsgNodeFallback(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SymsgInfo> buildCheckerHook(DeciTreeOption<SymsgInfo> option) {	
		List<ModelChecker<SymsgInfo>> queue = new ArrayList<>();		
		ModelChecker<SymsgInfo> checker;	
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SymsgCheckNotEnglish(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> enforceEnglish = new ActionStdCommom<SymsgInfo>(option, SymsgVisiEnforceEnglish.class);
		ActionLazy<SymsgInfo> nodeSelect = new ActionLazyCommom<SymsgInfo>(option, SymsgVisiNodeSelectL1.class);
		
		enforceEnglish.addPostAction(nodeSelect);
		
		actions.add(enforceEnglish);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnFailedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> restoreBase = new ActionStdCommom<SymsgInfo>(option, SymsgVisiRestoreBase.class);
		ActionLazy<SymsgInfo> enforceError = new ActionLazyCommom<SymsgInfo>(option, SymsgVisiEnforceError.class);
		ActionLazy<SymsgInfo> nodeSelect = new ActionLazyCommom<SymsgInfo>(option, SymsgVisiNodeSelectL1.class);
		
		restoreBase.addPostAction(enforceError);
		enforceError.addPostAction(nodeSelect);
		
		actions.add(restoreBase);		
		return actions;
	}
}
