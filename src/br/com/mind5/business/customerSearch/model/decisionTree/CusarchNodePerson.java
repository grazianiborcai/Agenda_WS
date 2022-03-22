package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiEnforcePerson;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiMergePerarch;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckHasPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CusarchNodePerson extends DeciTreeTemplateRead<CusarchInfo> {
	
	public CusarchNodePerson(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusarchInfo> buildCheckerHook(DeciTreeOption<CusarchInfo> option) {
		List<ModelChecker<CusarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.SUCCESS;	
		checker = new CusarchCheckHasPerson(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> enforcePerson = new ActionStdCommom<CusarchInfo>(option, CusarchVisiEnforcePerson.class);
		ActionLazy<CusarchInfo> mergePerarch = new ActionLazyCommom<CusarchInfo>(option, CusarchVisiMergePerarch.class);
		
		enforcePerson.addPostAction(mergePerarch);
		
		actions.add(enforcePerson);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnFailedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> success = new ActionStdSuccessCommom<CusarchInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
