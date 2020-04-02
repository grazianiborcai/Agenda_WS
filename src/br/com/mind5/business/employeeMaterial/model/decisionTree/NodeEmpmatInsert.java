package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatInsert;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatUpdate;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeEmpmatInsert extends DeciTreeWriteTemplate<EmpmatInfo> {
	
	public NodeEmpmatInsert(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildDecisionCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmpmatCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStdV1<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpmatInfo> insert = new StdEmpmatInsert(option);		
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<EmpmatInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStdV1<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpmatInfo> update = new StdEmpmatUpdate(option);		
		actions.add(update);
		
		return actions;
	}
}
