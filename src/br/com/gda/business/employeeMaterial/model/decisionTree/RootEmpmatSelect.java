package br.com.gda.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatMergeEmp;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatMergeMat;
import br.com.gda.business.employeeMaterial.model.action.StdEmpmatMergeToSelect;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckLangu;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpmatSelect extends DeciTreeReadTemplate<EmpmatInfo> {
	
	public RootEmpmatSelect(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildDecisionCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new EmpmatCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpmatCheckLangu(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> select = new StdEmpmatMergeToSelect(option);
		ActionLazy<EmpmatInfo> mergeMat = new LazyEmpmatMergeMat(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> mergeEmp = new LazyEmpmatMergeEmp(option.conn, option.schemaName);
		
		select.addPostAction(mergeMat);
		mergeMat.addPostAction(mergeEmp);
		
		actions.add(select);
		return actions;
	}
}
