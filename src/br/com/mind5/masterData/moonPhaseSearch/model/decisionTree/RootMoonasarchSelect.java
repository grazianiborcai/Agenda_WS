package br.com.mind5.masterData.moonPhaseSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.masterData.moonPhaseSearch.model.action.StdMoonasarchSelect;
import br.com.mind5.masterData.moonPhaseSearch.model.checker.MoonasarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMoonasarchSelect extends DeciTreeReadTemplate<MoonasarchInfo> {
	
	public RootMoonasarchSelect(DeciTreeOption<MoonasarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MoonasarchInfo> buildDecisionCheckerHook(DeciTreeOption<MoonasarchInfo> option) {
		List<ModelChecker<MoonasarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MoonasarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MoonasarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<MoonasarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MoonasarchInfo> option) {
		List<ActionStd<MoonasarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MoonasarchInfo> select = new StdMoonasarchSelect(option);
		
		actions.add(select);
		return actions;
	}
}
