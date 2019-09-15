package br.com.gda.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.message.sysMessage.model.action.LazySymsgNodeSelect;
import br.com.gda.message.sysMessage.model.action.StdSymsgEnforceBase;
import br.com.gda.message.sysMessage.model.checker.SymsgCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSymsgSelect extends DeciTreeWriteTemplate<SymsgInfo> {
	
	public RootSymsgSelect(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SymsgInfo> buildDecisionCheckerHook(DeciTreeOption<SymsgInfo> option) {		
		List<ModelChecker<SymsgInfo>> queue = new ArrayList<>();		
		ModelChecker<SymsgInfo> checker;	
		
		checker = new SymsgCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> enforceBase = new StdSymsgEnforceBase(option);
		ActionLazy<SymsgInfo> nodeSelect = new LazySymsgNodeSelect(option.conn, option.schemaName);
		
		enforceBase.addPostAction(nodeSelect);
		
		actions.add(enforceBase);		
		return actions;
	}
}
