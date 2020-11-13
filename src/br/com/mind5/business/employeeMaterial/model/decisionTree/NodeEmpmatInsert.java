package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatDaoInsert;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatDaoUpdate;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmpmatInsert extends DeciTreeTemplateWriteV2<EmpmatInfo> {
	
	public NodeEmpmatInsert(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpmatInfo> buildCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelCheckerV1<EmpmatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmpmatCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStdV2<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmpmatInfo> insert = new StdEmpmatDaoInsert(option);		
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<EmpmatInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStdV2<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmpmatInfo> update = new StdEmpmatDaoUpdate(option);		
		actions.add(update);
		
		return actions;
	}
}
