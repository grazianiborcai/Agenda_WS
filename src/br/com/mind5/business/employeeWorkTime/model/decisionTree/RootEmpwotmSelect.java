package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmMergeStolis;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmMergeWeekday;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmMergeToSelect;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckLangu;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckOwner;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEmpwotmSelect extends DeciTreeTemplateReadV2<EmpwotmInfo> {
	
	public RootEmpwotmSelect(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelCheckerV1<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpwotmInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotmCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotmCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotmCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStdV1<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpwotmInfo> select = new StdEmpwotmMergeToSelect(option);
		ActionLazy<EmpwotmInfo> mergeWeekday = new LazyEmpwotmMergeWeekday(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> mergeStolis = new LazyEmpwotmMergeStolis(option.conn, option.schemaName);
		
		select.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeStolis);
		
		actions.add(select);
		return actions;
	}
}
