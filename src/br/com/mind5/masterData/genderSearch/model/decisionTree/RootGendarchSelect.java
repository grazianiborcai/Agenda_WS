package br.com.mind5.masterData.genderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.masterData.genderSearch.model.action.StdGendarchDaoSelect;
import br.com.mind5.masterData.genderSearch.model.checker.GendarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootGendarchSelect extends DeciTreeTemplateRead<GendarchInfo> {
	
	public RootGendarchSelect(DeciTreeOption<GendarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<GendarchInfo> buildCheckerHook(DeciTreeOption<GendarchInfo> option) {
		List<ModelChecker<GendarchInfo>> queue = new ArrayList<>();		
		ModelChecker<GendarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new GendarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<GendarchInfo>> buildActionsOnPassedHook(DeciTreeOption<GendarchInfo> option) {
		List<ActionStd<GendarchInfo>> actions = new ArrayList<>();
		
		ActionStd<GendarchInfo> select = new StdGendarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
