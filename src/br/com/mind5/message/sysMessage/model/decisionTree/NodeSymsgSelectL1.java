package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.LazySymsgNodeSelectL2;
import br.com.mind5.message.sysMessage.model.action.StdSymsgMergeToSelect;
import br.com.mind5.message.sysMessage.model.checker.SymsgCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSymsgSelectL1 extends DeciTreeWriteTemplate<SymsgInfo> {
	
	public NodeSymsgSelectL1(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SymsgInfo> buildCheckerHook(DeciTreeOption<SymsgInfo> option) {	
		List<ModelChecker<SymsgInfo>> queue = new ArrayList<>();		
		ModelChecker<SymsgInfo> checker;	

		checker = new SymsgCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStdV1<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<SymsgInfo> mergeToSelect = new StdSymsgMergeToSelect(option);
		ActionLazyV1<SymsgInfo> nodeL2 = new LazySymsgNodeSelectL2(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(nodeL2);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
