package br.com.mind5.business.employeeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.action.StdEmparchMergeToSelect;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckLangu;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckOwner;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmparchSelect extends DeciTreeReadTemplate<EmparchInfo> {
	
	public RootEmparchSelect(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmparchInfo> buildDecisionCheckerHook(DeciTreeOption<EmparchInfo> option) {
		List<ModelChecker<EmparchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmparchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmparchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmparchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmparchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmparchInfo> option) {
		List<ActionStd<EmparchInfo>> actions = new ArrayList<>();

		ActionStd<EmparchInfo> select = new StdEmparchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
