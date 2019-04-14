package br.com.gda.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatMergeToDelete;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatRootDelete;
import br.com.gda.business.employeeMaterial.model.action.StdEmpmatEnforceEmpKey;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckDeleteByEmp;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckHasEmpItem;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpmatDeleteByEmp extends DeciTreeWriteTemplate<EmpmatInfo> {
	
	public RootEmpmatDeleteByEmp(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildDecisionCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checker = new EmpmatCheckDeleteByEmp();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpmatCheckHasEmpItem(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<EmpmatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> enforceEmpKey = new StdEmpmatEnforceEmpKey(option);
		ActionLazy<EmpmatInfo> mergeToDelete = new LazyEmpmatMergeToDelete(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> rootDelete = new LazyEmpmatRootDelete(option.conn, option.schemaName);
		
		enforceEmpKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(rootDelete);
		
		actions.add(enforceEmpKey);
		return actions;
	}
}
