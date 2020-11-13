package br.com.mind5.masterData.materialUnitSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;
import br.com.mind5.masterData.materialUnitSearch.model.action.StdMatunitarchDaoSelect;
import br.com.mind5.masterData.materialUnitSearch.model.checker.MatunitarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatunitarchSelect extends DeciTreeTemplateRead<MatunitarchInfo> {
	
	public RootMatunitarchSelect(DeciTreeOption<MatunitarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatunitarchInfo> buildCheckerHook(DeciTreeOption<MatunitarchInfo> option) {
		List<ModelChecker<MatunitarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatunitarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatunitarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatunitarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatunitarchInfo> option) {
		List<ActionStd<MatunitarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatunitarchInfo> select = new StdMatunitarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
