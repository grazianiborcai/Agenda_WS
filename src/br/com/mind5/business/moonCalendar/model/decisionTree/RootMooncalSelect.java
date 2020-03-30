package br.com.mind5.business.moonCalendar.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.model.action.LazyMooncalMergeMoonase;
import br.com.mind5.business.moonCalendar.model.action.StdMooncalMergeToSelect;
import br.com.mind5.business.moonCalendar.model.checker.MooncalCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMooncalSelect extends DeciTreeReadTemplate<MooncalInfo> {
	
	public RootMooncalSelect(DeciTreeOption<MooncalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MooncalInfo> buildDecisionCheckerHook(DeciTreeOption<MooncalInfo> option) {
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

		
	
	@Override protected List<ActionStd<MooncalInfo>> buildActionsOnPassedHook(DeciTreeOption<MooncalInfo> option) {
		List<ActionStd<MooncalInfo>> actions = new ArrayList<>();
		
		ActionStd<MooncalInfo> mergeToSelect = new StdMooncalMergeToSelect(option);
		ActionLazy<MooncalInfo>  mergeMoonase = new LazyMooncalMergeMoonase(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeMoonase);
		
		actions.add(mergeToSelect);
		return actions;
	}
}