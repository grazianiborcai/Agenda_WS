package br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.action.EmpwocoVisiMergeToSelect;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckEmp;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckLangu;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckOwner;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckRead;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpwocoRootSelect extends DeciTreeTemplateRead<EmpwocoInfo> {
	
	public EmpwocoRootSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwocoInfo> buildCheckerHook(DeciTreeOption<EmpwocoInfo> option) {
		List<ModelChecker<EmpwocoInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwocoInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwocoCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwocoCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwocoCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwocoCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwocoCheckEmp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwocoInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwocoInfo> option) {
		List<ActionStd<EmpwocoInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwocoInfo> select = new ActionStdCommom<EmpwocoInfo>(option, EmpwocoVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
