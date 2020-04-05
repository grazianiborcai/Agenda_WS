package br.com.mind5.business.moonCalendar.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.model.action.LazyMooncalMergeMoonase;
import br.com.mind5.business.moonCalendar.model.action.StdMooncalMergeToSelect;
import br.com.mind5.business.moonCalendar.model.checker.MooncalCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMooncalSelect extends DeciTreeReadTemplate<MooncalInfo> {
	
	public RootMooncalSelect(DeciTreeOption<MooncalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MooncalInfo> buildCheckerHook(DeciTreeOption<MooncalInfo> option) {
		List<ModelChecker<MooncalInfo>> queue = new ArrayList<>();		
		ModelChecker<MooncalInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MooncalCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
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
