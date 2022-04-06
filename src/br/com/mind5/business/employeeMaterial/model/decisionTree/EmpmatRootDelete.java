package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiDaoDelete;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiDaoUpdate;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiEnforceLChanged;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiMergeToDelete;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiMergeUsername;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckLangu;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckOwner;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpmatRootDelete extends DeciTreeTemplateWrite<EmpmatInfo> {
	
	public EmpmatRootDelete(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpmatCheckWrite(checkerOption);
		queue.add(checker);	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<EmpmatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> nodeSytotauh = new EmpmatNodeSytotauhL1(option).toAction();
		ActionStd<EmpmatInfo> mergeToDelete = new ActionStdCommom<EmpmatInfo>(option, EmpmatVisiMergeToDelete.class);
		ActionLazy<EmpmatInfo> enforceLChanged = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiEnforceLChanged.class);
		ActionLazy<EmpmatInfo> enforceLChangedBy = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiMergeUsername.class);
		ActionLazy<EmpmatInfo> update = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiDaoUpdate.class);
		ActionLazy<EmpmatInfo> deleteEmpmat = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiDaoDelete.class);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(deleteEmpmat);
		
		actions.add(nodeSytotauh);
		actions.add(mergeToDelete);
		return actions;	
	}
}
