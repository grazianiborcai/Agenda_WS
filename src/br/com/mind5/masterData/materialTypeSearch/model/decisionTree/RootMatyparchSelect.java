package br.com.mind5.masterData.materialTypeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.masterData.materialTypeSearch.model.action.StdMatyparchDaoSelect;
import br.com.mind5.masterData.materialTypeSearch.model.checker.MatyparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatyparchSelect extends DeciTreeTemplateRead<MatyparchInfo> {
	
	public RootMatyparchSelect(DeciTreeOption<MatyparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatyparchInfo> buildCheckerHook(DeciTreeOption<MatyparchInfo> option) {
		List<ModelChecker<MatyparchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatyparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatyparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatyparchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatyparchInfo> option) {
		List<ActionStd<MatyparchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatyparchInfo> select = new StdMatyparchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
