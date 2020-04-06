package br.com.mind5.business.moonCalendar.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.model.action.LazyMooncalMergeMoonase;
import br.com.mind5.business.moonCalendar.model.action.StdMooncalMergeToSelect;
import br.com.mind5.business.moonCalendar.model.checker.MooncalCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMooncalSelect extends DeciTreeTemplateRead<MooncalInfo> {
	
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

		
	
	@Override protected List<ActionStdV1<MooncalInfo>> buildActionsOnPassedHook(DeciTreeOption<MooncalInfo> option) {
		List<ActionStdV1<MooncalInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MooncalInfo> mergeToSelect = new StdMooncalMergeToSelect(option);
		ActionLazyV1<MooncalInfo>  mergeMoonase = new LazyMooncalMergeMoonase(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeMoonase);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
