package br.com.mind5.message.sysMessage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.LazySymsgNodeSelectL2;
import br.com.mind5.message.sysMessage.model.action.StdSymsgMergeToSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSymsgSelectL1 extends DeciTreeTemplateWriteV2<SymsgInfo> {
	
	public NodeSymsgSelectL1(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SymsgInfo> buildCheckerHook(DeciTreeOption<SymsgInfo> option) {	
		List<ModelCheckerV1<SymsgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SymsgInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SymsgInfo>> buildActionsOnPassedHook(DeciTreeOption<SymsgInfo> option) {
		List<ActionStdV1<SymsgInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<SymsgInfo> mergeToSelect = new StdSymsgMergeToSelect(option);
		ActionLazy<SymsgInfo> nodeL2 = new LazySymsgNodeSelectL2(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(nodeL2);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
