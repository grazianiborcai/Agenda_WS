package br.com.mind5.masterData.materialGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.action.MatoupVisiMergeMatouparchBusiness;
import br.com.mind5.masterData.materialGroup.model.action.MatoupVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatoupRootSearchBusiness extends DeciTreeTemplateRead<MatoupInfo> {
	
	public MatoupRootSearchBusiness(DeciTreeOption<MatoupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoupInfo> buildCheckerHook(DeciTreeOption<MatoupInfo> option) {
		List<ModelChecker<MatoupInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupInfo> option) {
		List<ActionStd<MatoupInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoupInfo> mergeMatouparch = new ActionStdCommom<MatoupInfo>(option, MatoupVisiMergeMatouparchBusiness.class);
		ActionLazy<MatoupInfo> select = new ActionLazyCommom<MatoupInfo>(option, MatoupVisiRootSelect.class);
		
		mergeMatouparch.addPostAction(select);
		
		actions.add(mergeMatouparch);
		return actions;
	}
}
