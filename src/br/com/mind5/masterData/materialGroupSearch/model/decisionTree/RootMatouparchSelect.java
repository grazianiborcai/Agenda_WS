package br.com.mind5.masterData.materialGroupSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.masterData.materialGroupSearch.model.action.StdMatouparchDaoSelect;
import br.com.mind5.masterData.materialGroupSearch.model.checker.MatouparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatouparchSelect extends DeciTreeTemplateRead<MatouparchInfo> {
	
	public RootMatouparchSelect(DeciTreeOption<MatouparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatouparchInfo> buildCheckerHook(DeciTreeOption<MatouparchInfo> option) {
		List<ModelChecker<MatouparchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatouparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatouparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatouparchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatouparchInfo> option) {
		List<ActionStd<MatouparchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatouparchInfo> select = new StdMatouparchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
