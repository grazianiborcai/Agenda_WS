package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpMergeAddress;
import br.com.gda.business.employee.model.action.LazyEmpMergePerson;
import br.com.gda.business.employee.model.action.LazyEmpMergePhone;
import br.com.gda.business.employee.model.action.LazyEmpMergeUser;
import br.com.gda.business.employee.model.action.StdEmpMergeToSelect;
import br.com.gda.business.employee.model.checker.EmpCheckLangu;
import br.com.gda.business.employee.model.checker.EmpCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpSelect extends DeciTreeReadTemplate<EmpInfo> {
	
	public RootEmpSelect(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new EmpCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();

		ActionStd<EmpInfo> select = new StdEmpMergeToSelect(option);
		ActionLazy<EmpInfo> mergePerson = new LazyEmpMergePerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeAddress = new LazyEmpMergeAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergePhone = new LazyEmpMergePhone(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeUser = new LazyEmpMergeUser(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeUser);
		
		actions.add(select);
		return actions;
	}
}
