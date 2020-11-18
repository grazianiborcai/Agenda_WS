package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpEmpwotmInsert;
import br.com.mind5.business.employee.model.action.StdEmpEmposInsert;
import br.com.mind5.business.employee.model.action.StdEmpSuccess;
import br.com.mind5.business.employee.model.checker.EmpCheckSytotin;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmpInsertExtra extends DeciTreeTemplateWrite<EmpInfo> {	
	
	public NodeEmpInsertExtra(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStd<EmpInfo> insertEmpos = new StdEmpEmposInsert(option);
		ActionLazy<EmpInfo> insertEmpwotm = new LazyEmpEmpwotmInsert(option.conn, option.schemaName);
		
		insertEmpos.addPostAction(insertEmpwotm);
		
		actions.add(insertEmpos);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStd<EmpInfo> success = new StdEmpSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
