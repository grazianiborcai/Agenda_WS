package br.com.mind5.masterData.materialCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.action.StdMategDaoSelect;
import br.com.mind5.masterData.materialCategory.model.checker.MategCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMategSelect extends DeciTreeTemplateRead<MategInfo> {
	
	public RootMategSelect(DeciTreeOption<MategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MategInfo> buildCheckerHook(DeciTreeOption<MategInfo> option) {
		List<ModelChecker<MategInfo>> queue = new ArrayList<>();		
		ModelChecker<MategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MategInfo>> buildActionsOnPassedHook(DeciTreeOption<MategInfo> option) {
		List<ActionStd<MategInfo>> actions = new ArrayList<>();
		
		ActionStd<MategInfo> select = new StdMategDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
