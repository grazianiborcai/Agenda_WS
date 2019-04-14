package br.com.gda.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatMergeUsername;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatNodeInsert;
import br.com.gda.business.employeeMaterial.model.action.LazyEmpmatRootSelect;
import br.com.gda.business.employeeMaterial.model.action.StdEmpmatEnforceLChanged;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckEmp;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckLangu;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckMat;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckOwner;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpmatInsert extends DeciTreeWriteTemplate<EmpmatInfo> {
	
	public RootEmpmatInsert(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildDecisionCheckerHook(DeciTreeOption<EmpmatInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
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
		checker = new EmpmatCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpmatCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpmatCheckMat(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmpmatCheckExist(checkerOption);
		queue.add(checker);	
		//TODO: verificar se material e servico
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> enforceLChanged = new StdEmpmatEnforceLChanged(option);
		ActionLazy<EmpmatInfo> enforceLChangedBy = new LazyEmpmatMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> nodeInsert = new LazyEmpmatNodeInsert(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> select = new LazyEmpmatRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);

		
		actions.add(enforceLChanged);
		return actions;
	}
}
