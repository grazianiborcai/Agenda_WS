package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiNodeDeleteL1;
import br.com.mind5.business.employee.model.action.EmpVisiNodeSytotauh;
import br.com.mind5.business.employee.model.action.EmpVisiDaoUpdate;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceLChanged;
import br.com.mind5.business.employee.model.action.EmpVisiMergeToDelete;
import br.com.mind5.business.employee.model.action.EmpVisiMergeUsername;
import br.com.mind5.business.employee.model.checker.EmpCheckDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpRootDelete extends DeciTreeTemplateWrite<EmpInfo> {
	
	public EmpRootDelete(DeciTreeOption<EmpInfo> option) {
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
		
		 return new ModelCheckerHelperQueue<EmpInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		//TODO: eliminar do carrinho de compras
		//TODO: verificar schedule
		ActionStd<EmpInfo> mergeToDelete = new ActionStdCommom<EmpInfo>(option, EmpVisiMergeToDelete.class);
		ActionLazy<EmpInfo> nodeSytotauh = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeSytotauh.class);
		ActionLazy<EmpInfo> enforceLChanged = new ActionLazyCommom<EmpInfo>(option, EmpVisiEnforceLChanged.class);
		ActionLazy<EmpInfo> enforceLChangedBy = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeUsername.class);
		ActionLazy<EmpInfo> update = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoUpdate.class);	
		ActionLazy<EmpInfo> nodeL1 = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeDeleteL1.class);	

		mergeToDelete.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(nodeL1);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
