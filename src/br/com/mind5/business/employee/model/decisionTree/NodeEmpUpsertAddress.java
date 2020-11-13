package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpAddressUpsert;
import br.com.mind5.business.employee.model.action.StdEmpEnforceAddressKey;
import br.com.mind5.business.employee.model.action.StdEmpSuccess;
import br.com.mind5.business.employee.model.checker.EmpCheckHasAddress;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmpUpsertAddress extends DeciTreeTemplateWrite<EmpInfo> {
	
	public NodeEmpUpsertAddress(DeciTreeOption<EmpInfo> option) {
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
		checker = new EmpCheckHasAddress(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> enforceAddressKey = new StdEmpEnforceAddressKey(option);
		ActionLazy<EmpInfo> upsertAddress = new LazyEmpAddressUpsert(option.conn, option.schemaName);
		
		enforceAddressKey.addPostAction(upsertAddress);
		
		actions.add(enforceAddressKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpSuccess(option));		
		return actions;
	}
}
