package br.com.mind5.masterData.gender.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.masterData.gender.model.action.StdGenderDaoSelect;
import br.com.mind5.masterData.gender.model.checker.GenderCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootGenderSelect extends DeciTreeTemplateRead<GenderInfo> {
	
	public RootGenderSelect(DeciTreeOption<GenderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<GenderInfo> buildCheckerHook(DeciTreeOption<GenderInfo> option) {
		List<ModelChecker<GenderInfo>> queue = new ArrayList<>();		
		ModelChecker<GenderInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new GenderCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<GenderInfo>> buildActionsOnPassedHook(DeciTreeOption<GenderInfo> option) {
		List<ActionStd<GenderInfo>> actions = new ArrayList<>();
		
		ActionStd<GenderInfo> select = new StdGenderDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
