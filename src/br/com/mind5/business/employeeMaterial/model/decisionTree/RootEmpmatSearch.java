package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatRootSelect;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatMergeEmpmarch;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpmatSearch extends DeciTreeReadTemplate<EmpmatInfo> {
	
	public RootEmpmatSearch(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildDecisionCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
			
		checker = new EmpmatCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> mergeEmpmarch = new StdEmpmatMergeEmpmarch(option);
		ActionLazy<EmpmatInfo> select = new LazyEmpmatRootSelect(option.conn, option.schemaName);
		
		mergeEmpmarch.addPostAction(select);
		
		actions.add(mergeEmpmarch);
		return actions;
	}
}
