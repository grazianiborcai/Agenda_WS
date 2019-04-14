package br.com.gda.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatDelete;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatEnforceLChanged;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatMergeUsername;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatUpdate;
import br.com.gda.business.employeeMaterial.model.action.StdEmpmatMergeToDelete;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckLangu;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpmatDelete extends DeciTreeWriteTemplate<EmpmatInfo> {
	
	public RootEmpmatDelete(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildDecisionCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;
			
		checker = new EmpmatCheckWrite();
		queue.add(checker);		
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpmatCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpmatCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<EmpmatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> mergeToDelete = new StdEmpmatMergeToDelete(option);
		ActionLazy<EmpmatInfo> enforceLChanged = new LazyEmpmatEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> enforceLChangedBy = new LazyEmpmatMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> update = new LazyEmpmatUpdate(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> deleteEmpmat = new LazyEmpmatDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(deleteEmpmat);
		
		actions.add(mergeToDelete);
		return actions;	
	}
}
