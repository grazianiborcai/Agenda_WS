package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiNodeSytotauhL2;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiMergeSytotauh;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckSytotin;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpmatNodeSytotauhL1 extends DeciTreeTemplateWrite<EmpmatInfo> {
	
	public EmpmatNodeSytotauhL1(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckSytotin(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> mergeSytotauh = new ActionStdCommom<EmpmatInfo>(option, EmpmatVisiMergeSytotauh.class);
		ActionLazy<EmpmatInfo> nodeL2 = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiNodeSytotauhL2.class);
		
		mergeSytotauh.addPostAction(nodeL2);
		
		actions.add(mergeSytotauh);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> success = new ActionStdSuccessCommom<EmpmatInfo>(option);
		
		actions.add(success);		
		return actions;
	}
}
