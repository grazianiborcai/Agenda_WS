package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpDaoDelete;
import br.com.mind5.business.employee.model.action.LazyEmpDaoUpdate;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceLChanged;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUsername;
import br.com.mind5.business.employee.model.action.LazyEmpNodeSytotauh;
import br.com.mind5.business.employee.model.action.StdEmpMergeToDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmpDelete extends DeciTreeTemplateWriteV2<EmpInfo> {
	
	public RootEmpDelete(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelCheckerV1<EmpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpCheckDelete(checkerOption);
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
		checker = new EmpCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerHelperQueueV2<EmpInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV1<EmpInfo>> actions = new ArrayList<>();
		//TODO: eliminar do carrinho de compras
		//TODO: verificar schedule
		ActionStdV1<EmpInfo> mergeToDelete = new StdEmpMergeToDelete(option);
		ActionLazy<EmpInfo> nodeSytotauh = new LazyEmpNodeSytotauh(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceLChanged = new LazyEmpEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpInfo> update = new LazyEmpDaoUpdate(option.conn, option.schemaName);	
		ActionLazy<EmpInfo> deleteEmployee = new LazyEmpDaoDelete(option.conn, option.schemaName);	

		mergeToDelete.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteEmployee);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
