package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.LazyCusarchMergePerarch;
import br.com.mind5.business.customerSearch.model.action.StdCusarchEnforcePerson;
import br.com.mind5.business.customerSearch.model.action.StdCusarchSuccess;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckHasPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeCusarchPerson extends DeciTreeTemplateRead<CusarchInfo> {
	
	public NodeCusarchPerson(DeciTreeOption<CusarchInfo> option) {
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
		
		ActionStd<CusarchInfo> enforcePerson = new StdCusarchEnforcePerson(option);
		ActionLazy<CusarchInfo> mergePerarch = new LazyCusarchMergePerarch(option.conn, option.schemaName);
		
		enforcePerson.addPostAction(mergePerarch);
		
		actions.add(enforcePerson);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnFailedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> success = new StdCusarchSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
