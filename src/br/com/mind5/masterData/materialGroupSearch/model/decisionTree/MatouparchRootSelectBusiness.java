package br.com.mind5.masterData.materialGroupSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.masterData.materialGroupSearch.model.action.MatouparchVisiEnforceBusinessKey;
import br.com.mind5.masterData.materialGroupSearch.model.action.MatouparchVisiRootSelect;
import br.com.mind5.masterData.materialGroupSearch.model.checker.MatouparchCheckReadBusiness;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatouparchRootSelectBusiness extends DeciTreeTemplateRead<MatouparchInfo> {
	
	public MatouparchRootSelectBusiness(DeciTreeOption<MatouparchInfo> option) {
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
		checker = new MatouparchCheckReadBusiness(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatouparchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatouparchInfo> option) {
		List<ActionStd<MatouparchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatouparchInfo> enforceBusinessKey = new ActionStdCommom<MatouparchInfo>(option, MatouparchVisiEnforceBusinessKey.class);
		ActionLazy<MatouparchInfo> select = new ActionLazyCommom<MatouparchInfo>(option, MatouparchVisiRootSelect.class);
		
		enforceBusinessKey.addPostAction(select);
		
		actions.add(enforceBusinessKey);
		return actions;
	}
}
