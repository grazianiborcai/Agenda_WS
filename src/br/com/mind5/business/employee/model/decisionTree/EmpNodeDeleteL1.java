package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiEmplutmDelete;
import br.com.mind5.business.employee.model.action.EmpVisiEmpwotmDelete;
import br.com.mind5.business.employee.model.action.EmpVisiNodeDeleteL2;
import br.com.mind5.business.employee.model.action.EmpVisiNodeEmposDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckSytotin;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpNodeDeleteL1 extends DeciTreeTemplateWrite<EmpInfo> {	
	
	public EmpNodeDeleteL1(DeciTreeOption<EmpInfo> option) {
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
		
		ActionStd<EmpInfo> deleteEmpwotm = new ActionStdCommom<EmpInfo>(option, EmpVisiEmpwotmDelete.class);
		ActionLazy<EmpInfo> deleteEmplutm = new ActionLazyCommom<EmpInfo>(option, EmpVisiEmplutmDelete.class);
		ActionLazy<EmpInfo> deleteEmpos = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeEmposDelete.class);
		ActionLazy<EmpInfo> nodeL2 = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeDeleteL2.class);
		
		deleteEmpwotm.addPostAction(deleteEmplutm);
		deleteEmplutm.addPostAction(deleteEmpos);
		deleteEmpos.addPostAction(nodeL2);
		
		actions.add(deleteEmpwotm);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStd<EmpInfo> nodeL2 = new EmpNodeDeleteL2(option).toAction();
		
		actions.add(nodeL2);	
		return actions;
	}
}
