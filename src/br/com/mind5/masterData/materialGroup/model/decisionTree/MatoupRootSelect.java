package br.com.mind5.masterData.materialGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.action.MatoupVisiDaoSelect;
import br.com.mind5.masterData.materialGroup.model.action.MatoupVisiMergeBusarea;
import br.com.mind5.masterData.materialGroup.model.action.MatoupVisiMergeFimgys;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatoupRootSelect extends DeciTreeTemplateRead<MatoupInfo> {
	
	public MatoupRootSelect(DeciTreeOption<MatoupInfo> option) {
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
		
		ActionStd<MatoupInfo> select = new ActionStdCommom<MatoupInfo>(option, MatoupVisiDaoSelect.class);
		ActionLazy<MatoupInfo> mergeBusarea = new ActionLazyCommom<MatoupInfo>(option, MatoupVisiMergeBusarea.class);
		ActionLazy<MatoupInfo> mergeFimgys = new ActionLazyCommom<MatoupInfo>(option, MatoupVisiMergeFimgys.class);
		
		select.addPostAction(mergeBusarea);
		mergeBusarea.addPostAction(mergeFimgys);
		
		actions.add(select);
		return actions;
	}
}
