package br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.action.StdEmpwotarchMergeToSelect;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckLangu;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckOwner;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEmpwotarchSelect extends DeciTreeTemplateReadV2<EmpwotarchInfo> {
	
	public RootEmpwotarchSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpwotarchInfo> buildCheckerHook(DeciTreeOption<EmpwotarchInfo> option) {
		List<ModelCheckerV1<EmpwotarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpwotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotarchCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmpwotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotarchInfo> option) {
		List<ActionStdV2<EmpwotarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmpwotarchInfo> select = new StdEmpwotarchMergeToSelect(option);

		actions.add(select);
		return actions;
	}
}
