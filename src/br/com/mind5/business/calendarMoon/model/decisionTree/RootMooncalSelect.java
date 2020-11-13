package br.com.mind5.business.calendarMoon.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.model.action.LazyMooncalMergeMoonase;
import br.com.mind5.business.calendarMoon.model.action.StdMooncalMergeToSelect;
import br.com.mind5.business.calendarMoon.model.checker.MooncalCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMooncalSelect extends DeciTreeTemplateReadV2<MooncalInfo> {
	
	public RootMooncalSelect(DeciTreeOption<MooncalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MooncalInfo> buildCheckerHook(DeciTreeOption<MooncalInfo> option) {
		List<ModelCheckerV1<MooncalInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MooncalInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MooncalCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<MooncalInfo>> buildActionsOnPassedHook(DeciTreeOption<MooncalInfo> option) {
		List<ActionStdV2<MooncalInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MooncalInfo> mergeToSelect = new StdMooncalMergeToSelect(option);
		ActionLazy<MooncalInfo>  mergeMoonase = new LazyMooncalMergeMoonase(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeMoonase);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
