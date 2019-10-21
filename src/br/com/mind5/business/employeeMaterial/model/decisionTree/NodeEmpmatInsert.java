package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatInsert;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatUpdate;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckSoftDelete;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckWrite;
import br.com.mind5.model.action.ActionStd;
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
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmpmatCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new EmpmatCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpmatInsert(option));
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpmatUpdate(option));
		return actions;
	}
}
