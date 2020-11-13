package br.com.mind5.masterData.materialGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.action.LazyMatoupMergeBusarea;
import br.com.mind5.masterData.materialGroup.model.action.StdMatoupDaoSelect;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatoupSelect extends DeciTreeTemplateRead<MatoupInfo> {
	
	public RootMatoupSelect(DeciTreeOption<MatoupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoupInfo> buildCheckerHook(DeciTreeOption<MatoupInfo> option) {
		List<ModelChecker<MatoupInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatoupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupInfo> option) {
		List<ActionStd<MatoupInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoupInfo> select = new StdMatoupDaoSelect(option);
		ActionLazy<MatoupInfo> mergeBusarea = new LazyMatoupMergeBusarea(option.conn, option.schemaName);
		
		select.addPostAction(mergeBusarea);
		
		actions.add(select);
		return actions;
	}
}
