package br.com.mind5.masterData.materialCategorySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.masterData.materialCategorySearch.model.action.StdMategarchDaoSelect;
import br.com.mind5.masterData.materialCategorySearch.model.checker.MategarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMategarchSelect extends DeciTreeTemplateRead<MategarchInfo> {
	
	public RootMategarchSelect(DeciTreeOption<MategarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MategarchInfo> buildCheckerHook(DeciTreeOption<MategarchInfo> option) {
		List<ModelChecker<MategarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MategarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MategarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MategarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MategarchInfo> option) {
		List<ActionStd<MategarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MategarchInfo> select = new StdMategarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
