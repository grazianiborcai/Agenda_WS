package br.com.gda.business.employeeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.business.employeeSnapshot.model.action.LazyEmpnapMergeAddresnap;
import br.com.gda.business.employeeSnapshot.model.action.LazyEmpnapMergePersonap;
import br.com.gda.business.employeeSnapshot.model.action.LazyEmpnapMergePhonap;
import br.com.gda.business.employeeSnapshot.model.action.StdEmpnapMergeToSelect;
import br.com.gda.business.employeeSnapshot.model.checker.EmpnapCheckLangu;
import br.com.gda.business.employeeSnapshot.model.checker.EmpnapCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpnapSelect extends DeciTreeReadTemplate<EmpnapInfo> {
	
	public RootEmpnapSelect(DeciTreeOption<EmpnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpnapInfo> buildDecisionCheckerHook(DeciTreeOption<EmpnapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpnapInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpnapInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new EmpnapCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpnapCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpnapInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpnapInfo> option) {
		List<ActionStd<EmpnapInfo>> actions = new ArrayList<>();

		ActionStd<EmpnapInfo> select = new StdEmpnapMergeToSelect(option);
		ActionLazy<EmpnapInfo> mergePerson = new LazyEmpnapMergePersonap(option.conn, option.schemaName);
		ActionLazy<EmpnapInfo> mergeAddress = new LazyEmpnapMergeAddresnap(option.conn, option.schemaName);
		ActionLazy<EmpnapInfo> mergePhone = new LazyEmpnapMergePhonap(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		
		actions.add(select);
		return actions;
	}
}
