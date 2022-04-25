package br.com.mind5.business.employeeLunchTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulocoInfo;
import br.com.mind5.business.employeeLunchTimeConflict.model.action.EmpulocoVisiMergeToSelect;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulocoCheckEmp;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulocoCheckLangu;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulocoCheckOwner;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulocoCheckRead;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulocoCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpulocoRootSelect extends DeciTreeTemplateRead<EmpulocoInfo> {
	
	public EmpulocoRootSelect(DeciTreeOption<EmpulocoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpulocoInfo> buildCheckerHook(DeciTreeOption<EmpulocoInfo> option) {
		List<ModelChecker<EmpulocoInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpulocoInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpulocoCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpulocoCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpulocoCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpulocoCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpulocoCheckEmp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpulocoInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpulocoInfo> option) {
		List<ActionStd<EmpulocoInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpulocoInfo> select = new ActionStdCommom<EmpulocoInfo>(option, EmpulocoVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
