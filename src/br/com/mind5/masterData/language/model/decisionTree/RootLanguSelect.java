package br.com.mind5.masterData.language.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.action.StdLanguDaoSelect;
import br.com.mind5.masterData.language.model.checker.LanguCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootLanguSelect extends DeciTreeTemplateRead<LanguInfo> {
	
	public RootLanguSelect(DeciTreeOption<LanguInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<LanguInfo> buildCheckerHook(DeciTreeOption<LanguInfo> option) {
		List<ModelChecker<LanguInfo>> queue = new ArrayList<>();		
		ModelChecker<LanguInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new LanguCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<LanguInfo>> buildActionsOnPassedHook(DeciTreeOption<LanguInfo> option) {
		List<ActionStd<LanguInfo>> actions = new ArrayList<>();
		
		ActionStd<LanguInfo> select = new StdLanguDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
