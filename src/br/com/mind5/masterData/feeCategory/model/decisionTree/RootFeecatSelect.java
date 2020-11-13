package br.com.mind5.masterData.feeCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.action.StdFeecatDaoSelect;
import br.com.mind5.masterData.feeCategory.model.checker.FeecatCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFeecatSelect extends DeciTreeTemplateRead<FeecatInfo> {
	
	public RootFeecatSelect(DeciTreeOption<FeecatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeecatInfo> buildCheckerHook(DeciTreeOption<FeecatInfo> option) {
		List<ModelChecker<FeecatInfo>> queue = new ArrayList<>();		
		ModelChecker<FeecatInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeecatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<FeecatInfo>> buildActionsOnPassedHook(DeciTreeOption<FeecatInfo> option) {
		List<ActionStd<FeecatInfo>> actions = new ArrayList<>();
		
		ActionStd<FeecatInfo> select = new StdFeecatDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
