package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpMergeAddress;
import br.com.mind5.business.employee.model.action.LazyEmpMergeFimist;
import br.com.mind5.business.employee.model.action.LazyEmpMergePerson;
import br.com.mind5.business.employee.model.action.LazyEmpMergePhone;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUser;
import br.com.mind5.business.employee.model.action.LazyEmpNodeSytotauh;
import br.com.mind5.business.employee.model.action.StdEmpMergeToSelect;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.business.employee.model.checker.EmpCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootEmpSelect extends DeciTreeTemplateRead<EmpInfo> {
	
	public RootEmpSelect(DeciTreeOption<EmpInfo> option) {
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
		checker = new EmpCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();

		ActionStd<EmpInfo> select = new StdEmpMergeToSelect(option);
		ActionLazy<EmpInfo> nodeSytotauh = new LazyEmpNodeSytotauh(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergePerson = new LazyEmpMergePerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeAddress = new LazyEmpMergeAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergePhone = new LazyEmpMergePhone(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeUser = new LazyEmpMergeUser(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeFimist = new LazyEmpMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeUser);
		mergeUser.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
