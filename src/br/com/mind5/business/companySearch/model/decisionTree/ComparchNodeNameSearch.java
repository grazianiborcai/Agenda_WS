package br.com.mind5.business.companySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.model.action.ComparchVisiEnforceNameSearch;
import br.com.mind5.business.companySearch.model.checker.ComparchCheckHasNameSearch;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class ComparchNodeNameSearch extends DeciTreeTemplateRead<ComparchInfo> {
	
	public ComparchNodeNameSearch(DeciTreeOption<ComparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ComparchInfo> buildCheckerHook(DeciTreeOption<ComparchInfo> option) {
		List<ModelChecker<ComparchInfo>> queue = new ArrayList<>();		
		ModelChecker<ComparchInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ComparchCheckHasNameSearch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ComparchInfo>> buildActionsOnPassedHook(DeciTreeOption<ComparchInfo> option) {
		List<ActionStd<ComparchInfo>> actions = new ArrayList<>();
		
		ActionStd<ComparchInfo> enforceNameSearch = new ActionStdCommom<ComparchInfo>(option, ComparchVisiEnforceNameSearch.class);	
		actions.add(enforceNameSearch);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<ComparchInfo>> buildActionsOnFailedHook(DeciTreeOption<ComparchInfo> option) {
		List<ActionStd<ComparchInfo>> actions = new ArrayList<>();
		
		ActionStd<ComparchInfo> select = new ActionStdSuccessCommom<ComparchInfo>(option);
		actions.add(select);
		
		return actions;
	}
}
