package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmDaoInsert;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmDaoUpdate;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmpwotmInsert extends DeciTreeTemplateWriteV2<EmpwotmInfo> {
	
	public NodeEmpwotmInsert(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelCheckerV1<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpwotmInfo> checker;
		
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;
		checker = new EmpwotmCheckSoftDelete(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStdV1<EmpwotmInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpwotmDaoInsert(option));
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<EmpwotmInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStdV1<EmpwotmInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpwotmDaoUpdate(option));
		return actions;
	}
}
