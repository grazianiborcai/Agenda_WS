package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatMergeEmpmarch;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatRootDelete;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatEnforceEmpKey;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckDeleteByEmp;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckEmpmarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmpmatDeleteByEmp extends DeciTreeTemplateWriteV2<EmpmatInfo> {
	
	public RootEmpmatDeleteByEmp(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpmatInfo> buildCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelCheckerV1<EmpmatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpmatInfo> checker;
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

		return new ModelCheckerHelperQueueV2<EmpmatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStdV1<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpmatInfo> enforceEmpKey = new StdEmpmatEnforceEmpKey(option);
		ActionLazy<EmpmatInfo> mergeEmpmarch = new LazyEmpmatMergeEmpmarch(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> rootDelete = new LazyEmpmatRootDelete(option.conn, option.schemaName);
		
		enforceEmpKey.addPostAction(mergeEmpmarch);
		mergeEmpmarch.addPostAction(rootDelete);
		
		actions.add(enforceEmpKey);
		return actions;
	}
}
