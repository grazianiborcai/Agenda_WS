package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.action.StdLanguSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootLanguSelect extends DeciTreeTemplateReadV1<LanguInfo> {
	
	public RootLanguSelect(DeciTreeOption<LanguInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<LanguInfo> buildCheckerHook(DeciTreeOption<LanguInfo> option) {
		List<ModelCheckerV1<LanguInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<LanguInfo> checker;
		
		checker = new ModelCherckerTrue<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<LanguInfo>> buildActionsOnPassedHook(DeciTreeOption<LanguInfo> option) {
		List<ActionStdV1<LanguInfo>> actions = new ArrayList<>();
		
		ActionStdV1<LanguInfo> select = new StdLanguSelect(option);
		
		actions.add(select);
		return actions;
	}
}
