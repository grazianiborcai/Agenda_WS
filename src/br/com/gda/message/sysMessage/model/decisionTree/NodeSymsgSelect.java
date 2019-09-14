package br.com.gda.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.message.sysMessage.model.action.LazySymsgSelect;
import br.com.gda.message.sysMessage.model.action.StdSymsgEnforceEnglish;
import br.com.gda.message.sysMessage.model.action.StdSymsgSelect;
import br.com.gda.message.sysMessage.model.checker.SymsgCheckExist;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSymsgSelect extends DeciTreeWriteTemplate<SymsgInfo> {
	
	public NodeSymsgSelect(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SymsgInfo> buildDecisionCheckerHook(DeciTreeOption<SymsgInfo> option) {	
		List<ModelChecker<SymsgInfo>> queue = new ArrayList<>();		
		ModelChecker<SymsgInfo> checker;	
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SymsgCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> select = new StdSymsgSelect(option);
		
		actions.add(select);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnFailedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> enforceEnglish = new StdSymsgEnforceEnglish(option);
		ActionLazy<SymsgInfo> select = new LazySymsgSelect(option.conn, option.schemaName);
		
		enforceEnglish.addPostAction(select);
		
		actions.add(enforceEnglish);		
		return actions;
	}
}
