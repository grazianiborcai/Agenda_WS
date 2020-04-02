package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatMergeEmpmarch;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatRootDelete;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatEnforceEmpKey;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckDeleteByEmp;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckEmpmarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpmatDeleteByEmp extends DeciTreeWriteTemplate<EmpmatInfo> {
	
	public RootEmpmatDeleteByEmp(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildDecisionCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpmatCheckDeleteByEmp(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckEmpmarch(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<EmpmatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStdV1<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpmatInfo> enforceEmpKey = new StdEmpmatEnforceEmpKey(option);
		ActionLazyV1<EmpmatInfo> mergeEmpmarch = new LazyEmpmatMergeEmpmarch(option.conn, option.schemaName);
		ActionLazyV1<EmpmatInfo> rootDelete = new LazyEmpmatRootDelete(option.conn, option.schemaName);
		
		enforceEmpKey.addPostAction(mergeEmpmarch);
		mergeEmpmarch.addPostAction(rootDelete);
		
		actions.add(enforceEmpKey);
		return actions;
	}
}
