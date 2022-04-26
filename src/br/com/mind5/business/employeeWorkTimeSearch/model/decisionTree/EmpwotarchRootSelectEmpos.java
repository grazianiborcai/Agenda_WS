package br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.action.EmpwotarchVisiEnforceEmposKey;
import br.com.mind5.business.employeeWorkTimeSearch.model.action.EmpwotarchVisiRootSelect;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckReadEmpos;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpwotarchRootSelectEmpos extends DeciTreeTemplateRead<EmpwotarchInfo> {
	
	public EmpwotarchRootSelectEmpos(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotarchInfo> buildCheckerHook(DeciTreeOption<EmpwotarchInfo> option) {
		List<ModelChecker<EmpwotarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotarchCheckReadEmpos(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotarchInfo> option) {
		List<ActionStd<EmpwotarchInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotarchInfo> enforceEmposKey = new ActionStdCommom<EmpwotarchInfo>(option, EmpwotarchVisiEnforceEmposKey.class);
		ActionLazy<EmpwotarchInfo> select = new ActionLazyCommom<EmpwotarchInfo>(option, EmpwotarchVisiRootSelect.class);
		
		enforceEmposKey.addPostAction(select);
		
		actions.add(enforceEmposKey);		
		return actions; 
	}
}
