package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.LazySymsgNodeSelectL2;
import br.com.mind5.message.sysMessage.model.action.StdSymsgMergeToSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSymsgSelectL1 extends DeciTreeTemplateWrite<SymsgInfo> {
	
	public NodeSymsgSelectL1(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SymsgInfo> buildCheckerHook(DeciTreeOption<SymsgInfo> option) {	
		List<ModelChecker<SymsgInfo>> queue = new ArrayList<>();		
		ModelChecker<SymsgInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStd<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStd<SymsgInfo> mergeToSelect = new StdSymsgMergeToSelect(option);
		ActionLazy<SymsgInfo> nodeL2 = new LazySymsgNodeSelectL2(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(nodeL2);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
