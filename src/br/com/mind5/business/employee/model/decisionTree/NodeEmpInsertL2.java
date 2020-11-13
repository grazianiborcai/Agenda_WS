package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.StdEmpEmposInsert;
import br.com.mind5.business.employee.model.action.StdEmpSuccess;
import br.com.mind5.business.employee.model.checker.EmpCheckSytotin;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmpInsertL2 extends DeciTreeTemplateWriteV2<EmpInfo> {	
	
	public NodeEmpInsertL2(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {		
		List<ModelCheckerV1<EmpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV2<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<EmpInfo> insertEmpos = new StdEmpEmposInsert(option);
		
		actions.add(insertEmpos);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV2<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<EmpInfo> success = new StdEmpSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
